package xushun.bookstore.action;

import java.util.List;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;
import xushun.bookstore.service.BookTypeManager;

/**
 * 图书分类操作Action
 * @author xushun 
 *
 */
public class BookTypeAction extends BaseAction {
	 
	private int ftId;                      /** 第一级分类Id  */
	private int typeId;                    /** 分类Id */
	private String typeName;               /** 分类名 */
	
	private List<FirstType> firstTypes ;   /** 第一级分类列表 */
	private FirstType firstType;           /** 第一级分类 */
	private SecondType secondType;         /** 第二级分类 */
	
	public String toAddFirstType() throws Exception {
		return SUCCESS;
	}

	public String toAddSecondType() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		return SUCCESS;
	}
	
	/**
	 * 添加一级分类
	 * @return
	 * @throws Exception
	 */
	public String addFirstType() throws Exception {
		
		firstType.setLastModifyTime(System.currentTimeMillis());
		
		bookTypeManager.addFirstType(firstType);

		return SUCCESS;
	}
	
	/**
	 * 添加二级分类
	 * @return
	 * @throws Exception
	 */
	public String addSecondType() throws Exception {
		
		secondType.setLastModifyTime(System.currentTimeMillis());
		
		bookTypeManager.addSecondType(secondType);
		
		return SUCCESS;
	}
	
	/**
	 * 浏览分类
	 * @return
	 * @throws Exception
	 */
	public String viewTypes() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		
		return SUCCESS;
	}
	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public SecondType getSecondType() {
		return secondType;
	}

	public void setSecondType(SecondType secondType) {
		this.secondType = secondType;
	}

	public List<FirstType> getFirstTypes() {
		return firstTypes;
	}

	public void setFirstTypes(List<FirstType> firstTypes) {
		this.firstTypes = firstTypes;
	}

	public int getFtId() {
		return ftId;
	}

	public void setFtId(int ftId) {
		this.ftId = ftId;
	}

	

}
