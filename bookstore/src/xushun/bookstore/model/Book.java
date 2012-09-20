package xushun.bookstore.model;

/**
 * ͼ����Ϣ
 * @author xushun
 *
 */
public class Book implements java.io.Serializable {

	// Fields
	private Integer bookId;     /** ͼ��Id */
	private String isbn;        /** ͼ��ISBN�� */
	private Integer typeId;     /** ͼ��ڶ�������Id */
	private String bookName;    /** ͼ���� */
	private String publisher;   /** ������ */
	private String author;      /** ���� */
	private String introduce;   /** ��� */
	private String picture;     /** ����ͼƬ */
	private Double price;       /** ԭ�� */
	private Double rebate;      /** �ۿ� */
	private Long publishDate;   /** �������� */
	private String isCommend;   /** �Ƿ��Ƽ������Ƽ���ΪT�����Ƽ�ΪF */
	private String isNewBook;   /** �Ƿ�Ϊ���飬 ������ΪT������ΪF */
	private Integer saleCount;  /** �������� */
	private Long nowCount;      /** ������� */
	private Long inTime;        /** ���ʱ�� */

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