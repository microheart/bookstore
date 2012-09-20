package xushun.bookstore.action;

import java.util.List;

import xushun.bookstore.model.Book;
import xushun.bookstore.model.FirstType;
import xushun.bookstore.util.DataPage;

/**
 * 主页信息的显示
 * @author hp
 *
 */
public class HomeAction extends BaseAction {
	
	private List<FirstType> firstTypes ;
	
	private DataPage<Book> dataPageOfNewBooks;
	private DataPage<Book> dataPageOfCommendBooks;
	private DataPage<Book> dataPageOfHotSaleBooks;
	
	
	public String home() throws Exception {
		
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		dataPageOfNewBooks = bookManager.selectDataPageNewBooks(1, 4);
		dataPageOfCommendBooks = bookManager.selectDataPageCommendBooks(1, 4);
		dataPageOfHotSaleBooks = bookManager.selectDataPageHotSaleBooks(1, 4);
		
		return SUCCESS;
	}
	

	public List<FirstType> getFirstTypes() {
		return firstTypes;
	}

	public void setFirstTypes(List<FirstType> firstTypes) {
		this.firstTypes = firstTypes;
	}


	public DataPage<Book> getDataPageOfNewBooks() {
		return dataPageOfNewBooks;
	}


	public void setDataPageOfNewBooks(DataPage<Book> dataPageOfNewBooks) {
		this.dataPageOfNewBooks = dataPageOfNewBooks;
	}


	public DataPage<Book> getDataPageOfCommendBooks() {
		return dataPageOfCommendBooks;
	}


	public void setDataPageOfCommendBooks(DataPage<Book> dataPageOfCommendBooks) {
		this.dataPageOfCommendBooks = dataPageOfCommendBooks;
	}


	public DataPage<Book> getDataPageOfHotSaleBooks() {
		return dataPageOfHotSaleBooks;
	}


	public void setDataPageOfHotSaleBooks(DataPage<Book> dataPageOfHotSaleBooks) {
		this.dataPageOfHotSaleBooks = dataPageOfHotSaleBooks;
	}



	
	

}
