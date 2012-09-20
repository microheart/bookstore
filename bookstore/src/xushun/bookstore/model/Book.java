package xushun.bookstore.model;

/**
 * 图书信息
 * @author xushun
 *
 */
public class Book implements java.io.Serializable {

	// Fields
	private Integer bookId;     /** 图书Id */
	private String isbn;        /** 图书ISBN号 */
	private Integer typeId;     /** 图书第二级分类Id */
	private String bookName;    /** 图书名 */
	private String publisher;   /** 出版社 */
	private String author;      /** 作者 */
	private String introduce;   /** 简介 */
	private String picture;     /** 封面图片 */
	private Double price;       /** 原价 */
	private Double rebate;      /** 折扣 */
	private Long publishDate;   /** 出版日期 */
	private String isCommend;   /** 是否推荐，若推荐则为T，不推荐为F */
	private String isNewBook;   /** 是否为新书， 若是则为T，否则为F */
	private Integer saleCount;  /** 销售数量 */
	private Long nowCount;      /** 库存数量 */
	private Long inTime;        /** 入库时间 */

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String isbn, Integer typeId, String bookName, String publisher,
			String author, String introduce, Double price, Double rebate,
			Long publishDate, Integer saleCount, Long nowCount, Long inTime) {
		this.isbn = isbn;
		this.typeId = typeId;
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
		this.introduce = introduce;
		this.price = price;
		this.rebate = rebate;
		this.publishDate = publishDate;
		this.saleCount = saleCount;
		this.nowCount = nowCount;
		this.inTime = inTime;
	}

	/** full constructor */
	public Book(String isbn, Integer typeId, String bookName, String publisher,
			String author, String introduce, String picture, Double price,
			Double rebate, Long publishDate, String isCommend,
			String isNewBook, Integer saleCount, Long nowCount, Long inTime) {
		this.isbn = isbn;
		this.typeId = typeId;
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
		this.introduce = introduce;
		this.picture = picture;
		this.price = price;
		this.rebate = rebate;
		this.publishDate = publishDate;
		this.isCommend = isCommend;
		this.isNewBook = isNewBook;
		this.saleCount = saleCount;
		this.nowCount = nowCount;
		this.inTime = inTime;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRebate() {
		return this.rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	public Long getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Long publishDate) {
		this.publishDate = publishDate;
	}

	public String getIsCommend() {
		return this.isCommend;
	}

	public void setIsCommend(String isCommend) {
		this.isCommend = isCommend;
	}

	public String getIsNewBook() {
		return this.isNewBook;
	}

	public void setIsNewBook(String isNewBook) {
		this.isNewBook = isNewBook;
	}

	public Integer getSaleCount() {
		return this.saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Long getNowCount() {
		return this.nowCount;
	}

	public void setNowCount(Long nowCount) {
		this.nowCount = nowCount;
	}

	public Long getInTime() {
		return this.inTime;
	}

	public void setInTime(Long inTime) {
		this.inTime = inTime;
	}

}