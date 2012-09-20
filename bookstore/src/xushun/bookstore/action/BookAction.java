package xushun.bookstore.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import xushun.bookstore.model.Book;
import xushun.bookstore.model.BookComment;
import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;
import xushun.bookstore.util.DataPage;
import xushun.bookstore.util.DateUtil;
import xushun.bookstore.util.ImageUtil;

/**
 * 关于图书操作的Action
 * @author xushun
 *
 */
public class BookAction extends BaseAction {
	
	private File cover;                    /** 封面图片  */
	private String coverContentType;       /** 封面图片类型 */
	private String coverFileName;          /** 封面图片名字 */
	
	private String savePath;               /** 图片保存路径 */
	private String originalsImagePath = "originals";    /** 原图存放目录 */
	private String thumbnailsImagePath = "thumbnails";  /** 缩略图存放目录 */
	
	private String publishDate;            /** 图书出版日期 */
	
	private int firstTypeId;               /** 图书第一级分类Id */
	private int secondTypeId;              /** 图书第二级分类Id */
	private List<FirstType> firstTypes ;   /** 一级分类列表 */
	private List<SecondType> secondTypes;  /** 二级分类列表 */
	
	private int bookId;                    /** 图书Id */
	private Book book;                     /** 图书对象 */
	
	private String searchContent;          /** 搜索图书字段 */
	
	private DataPage<Book> dataPageOfBooks;  /** 图书分页信息 */
	private DataPage<BookComment> dataPageOfComments;
	

	/**
	 * 转到添加图书页面
	 */
	public String toAddBook() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypesWithoutSubTypes();
		secondTypes = bookTypeManager.getAllSecondTypes();
		return SUCCESS;
	}
	
	/**
	 * 添加图书，并生成缩略图
	 * @return
	 * @throws Exception
	 */
	public String addBook() throws Exception {
//		FileOutputStream fos = new FileOutputStream(getSavePath() + "//" + getCoverFileName());
//		FileInputStream fis = new FileInputStream(getCover());
//		byte[] buffer = new byte[1024];
//		int len =0;
//		while((len = fis.read(buffer)) > 0 ) {
//			fos.write(buffer, 0, len);
//		}

		// 获取图片的后缀名
		int index = getCoverFileName().lastIndexOf(".");
		String suffixal = getCoverFileName().substring(index);
		
		// 图片名由当前时间和随机数组成
		String imageName = ImageUtil.generateImageName() + suffixal;

		File target = new File(getSavePath() + "//" + getOriginalsImagePath() ,imageName);
		
		// 原图保存
		FileUtils.copyFile(cover, target);   
		
		// 缩略图保存
		ImageUtil.saveImageAsJpg(target.getAbsolutePath(), getSavePath()+ "//" + getThumbnailsImagePath() + "//" + imageName , 200, 400);
		
		book.setPicture(imageName);
		book.setPublishDate(DateUtil.parseDate(publishDate, "yyyy-MM-dd"));
		book.setSaleCount(0);
		book.setInTime(System.currentTimeMillis());
		
		bookManager.addBook(book);
		
		
		return SUCCESS;
	}
	
	/**
	 * 转到编辑图书界面
	 * @return
	 * @throws Exception
	 */
	public String toEditBook() throws Exception {
		book = bookManager.getBookById(bookId);
		firstTypes = bookTypeManager.getAllFirstTypesWithoutSubTypes();
		secondTypes = bookTypeManager.getAllSecondTypes();
		
		return SUCCESS;
	}
	
	/**
	 * 编辑图书
	 * @return
	 * @throws Exception
	 */
	public String editBook() throws Exception {
		Book oldBook = bookManager.getBookById(book.getBookId());
		
		book.setPublishDate(DateUtil.parseDate(publishDate, "yyyy-MM-dd"));
		book.setInTime(oldBook.getInTime());
		book.setPicture(oldBook.getPicture());
		
		bookManager.updateBook(book);
		
		return SUCCESS;
	}
	
	/**
	 * 浏览图书
	 * @return
	 * @throws Exception
	 */
	public String viewBook() throws Exception {
		book = bookManager.getBookById(bookId);
		dataPageOfComments = commentManager.selectDataPageBookComment(bookId, pageNo, pageSize);
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		return SUCCESS;
	}
	
	/**
	 * 图书分页信息列表
	 * @return
	 * @throws Exception
	 */
	public String listBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		dataPageOfBooks = bookManager.selectDataPageBooks(null, null);
		
		return SUCCESS;
	}
	
	/**
	 * 显示指定分类下图书分页
	 * @return
	 * @throws Exception
	 */
	public String listBooksByType() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		if(secondTypeId > 0){
			dataPageOfBooks = bookManager.selectDataPageBooksInSecondType(secondTypeId, pageNo, pageSize);
		}
		else if(firstTypeId > 0) {
			dataPageOfBooks = bookManager.selectDataPageBooksInFirstType(firstTypeId, pageNo, pageSize);
		}
		else {
			dataPageOfBooks = bookManager.selectDataPageBooks(pageNo, pageSize);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 分页列出新图书
	 * @return
	 * @throws Exception
	 */
	public String listNewBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageNewBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 分页列出推荐图书
	 * @return
	 * @throws Exception
	 */
	public String listCommendBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageCommendBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 分页列出热销图书
	 * @return
	 * @throws Exception
	 */
	public String listHotSaleBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageHotSaleBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 管理员查看分页图书列表 （注：之所以加上管理员是因为用户和管理员都有类似的操作，而转入的界面不同）
	 * @return
	 * @throws Exception
	 */
	public String adminListBooks() throws Exception {
		dataPageOfBooks = bookManager.selectDataPageBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 管理员搜索图书
	 * @return
	 * @throws Exception
	 */
	public String adminListBooksByName() throws Exception {
		dataPageOfBooks = bookManager.selectDataPageBooksByName(searchContent, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 用户通过书名搜索图书
	 * @return
	 * @throws Exception
	 */
	public String searchBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageBooksByName(searchContent, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 删除图书
	 * @return
	 * @throws Exception
	 */
	public String deleteBook() throws Exception {
		bookManager.removeBookById(bookId);
		
		return SUCCESS;
	}
	
	
	public String getSubTypes() throws Exception {
		secondTypes = bookTypeManager.getSubTypesOfFirstType(firstTypeId);
		
		return SUCCESS;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getOriginalsImagePath() {
		return originalsImagePath;
	}

	public void setOriginalsImagePath(String originalsImagePath) {
		this.originalsImagePath = originalsImagePath;
	}

	public String getThumbnailsImagePath() {
		return thumbnailsImagePath;
	}

	public void setThumbnailsImagePath(String thumbnailsImagePath) {
		this.thumbnailsImagePath = thumbnailsImagePath;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public List<FirstType> getFirstTypes() {
		return firstTypes;
	}

	public void setFirstTypes(List<FirstType> firstTypes) {
		this.firstTypes = firstTypes;
	}

	public List<SecondType> getSecondTypes() {
		return secondTypes;
	}

	public void setSecondTypes(List<SecondType> secondTypes) {
		this.secondTypes = secondTypes;
	}

	public int getFirstTypeId() {
		return firstTypeId;
	}

	public void setFirstTypeId(int firstTypeId) {
		this.firstTypeId = firstTypeId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public DataPage<Book> getDataPageOfBooks() {
		return dataPageOfBooks;
	}

	public void setDataPageOfBooks(DataPage<Book> dataPageOfBooks) {
		this.dataPageOfBooks = dataPageOfBooks;
	}

	public int getSecondTypeId() {
		return secondTypeId;
	}

	public void setSecondTypeId(int secondTypeId) {
		this.secondTypeId = secondTypeId;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public DataPage<BookComment> getDataPageOfComments() {
		return dataPageOfComments;
	}

	public void setDataPageOfComments(DataPage<BookComment> dataPageOfComments) {
		this.dataPageOfComments = dataPageOfComments;
	}
	
}
