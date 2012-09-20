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
 * ����ͼ�������Action
 * @author xushun
 *
 */
public class BookAction extends BaseAction {
	
	private File cover;                    /** ����ͼƬ  */
	private String coverContentType;       /** ����ͼƬ���� */
	private String coverFileName;          /** ����ͼƬ���� */
	
	private String savePath;               /** ͼƬ����·�� */
	private String originalsImagePath = "originals";    /** ԭͼ���Ŀ¼ */
	private String thumbnailsImagePath = "thumbnails";  /** ����ͼ���Ŀ¼ */
	
	private String publishDate;            /** ͼ��������� */
	
	private int firstTypeId;               /** ͼ���һ������Id */
	private int secondTypeId;              /** ͼ��ڶ�������Id */
	private List<FirstType> firstTypes ;   /** һ�������б� */
	private List<SecondType> secondTypes;  /** ���������б� */
	
	private int bookId;                    /** ͼ��Id */
	private Book book;                     /** ͼ����� */
	
	private String searchContent;          /** ����ͼ���ֶ� */
	
	private DataPage<Book> dataPageOfBooks;  /** ͼ���ҳ��Ϣ */
	private DataPage<BookComment> dataPageOfComments;
	

	/**
	 * ת�����ͼ��ҳ��
	 */
	public String toAddBook() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypesWithoutSubTypes();
		secondTypes = bookTypeManager.getAllSecondTypes();
		return SUCCESS;
	}
	
	/**
	 * ���ͼ�飬����������ͼ
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

		// ��ȡͼƬ�ĺ�׺��
		int index = getCoverFileName().lastIndexOf(".");
		String suffixal = getCoverFileName().substring(index);
		
		// ͼƬ���ɵ�ǰʱ�����������
		String imageName = ImageUtil.generateImageName() + suffixal;

		File target = new File(getSavePath() + "//" + getOriginalsImagePath() ,imageName);
		
		// ԭͼ����
		FileUtils.copyFile(cover, target);   
		
		// ����ͼ����
		ImageUtil.saveImageAsJpg(target.getAbsolutePath(), getSavePath()+ "//" + getThumbnailsImagePath() + "//" + imageName , 200, 400);
		
		book.setPicture(imageName);
		book.setPublishDate(DateUtil.parseDate(publishDate, "yyyy-MM-dd"));
		book.setSaleCount(0);
		book.setInTime(System.currentTimeMillis());
		
		bookManager.addBook(book);
		
		
		return SUCCESS;
	}
	
	/**
	 * ת���༭ͼ�����
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
	 * �༭ͼ��
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
	 * ���ͼ��
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
	 * ͼ���ҳ��Ϣ�б�
	 * @return
	 * @throws Exception
	 */
	public String listBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		dataPageOfBooks = bookManager.selectDataPageBooks(null, null);
		
		return SUCCESS;
	}
	
	/**
	 * ��ʾָ��������ͼ���ҳ
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
	 * ��ҳ�г���ͼ��
	 * @return
	 * @throws Exception
	 */
	public String listNewBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageNewBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ��ҳ�г��Ƽ�ͼ��
	 * @return
	 * @throws Exception
	 */
	public String listCommendBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageCommendBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ��ҳ�г�����ͼ��
	 * @return
	 * @throws Exception
	 */
	public String listHotSaleBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageHotSaleBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ����Ա�鿴��ҳͼ���б� ��ע��֮���Լ��Ϲ���Ա����Ϊ�û��͹���Ա�������ƵĲ�������ת��Ľ��治ͬ��
	 * @return
	 * @throws Exception
	 */
	public String adminListBooks() throws Exception {
		dataPageOfBooks = bookManager.selectDataPageBooks(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ����Ա����ͼ��
	 * @return
	 * @throws Exception
	 */
	public String adminListBooksByName() throws Exception {
		dataPageOfBooks = bookManager.selectDataPageBooksByName(searchContent, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * �û�ͨ����������ͼ��
	 * @return
	 * @throws Exception
	 */
	public String searchBooks() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfBooks = bookManager.selectDataPageBooksByName(searchContent, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ɾ��ͼ��
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
