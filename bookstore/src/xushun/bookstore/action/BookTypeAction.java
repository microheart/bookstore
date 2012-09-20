package xushun.bookstore.action;

import java.util.List;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;
import xushun.bookstore.service.BookTypeManager;

/**
 * ͼ��������Action
 * @author xushun 
 *
 */
public class BookTypeAction extends BaseAction {
	 
	private int ftId;                      /** ��һ������Id  */
	private int typeId;                    /** ����Id */
	private String typeName;               /** ������ */
	
	private List<FirstType> firstTypes ;   /** ��һ�������б� */
	private FirstType firstType;           /** ��һ������ */
	private SecondType secondType;         /** �ڶ������� */
	
	public String toAddFirstType() throws Exception {
		return SUCCESS;
	}

	public String toAddSecondType() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		return SUCCESS;
	}
	
	/**
	 * ���һ������
	 * @return
	 * @throws Exception
	 */
	public String addFirstType() throws Exception {
		
		firstType.setLastModifyTime(System.currentTimeMillis());
		
		bookTypeManager.addFirstType(firstType);

		return SUCCESS;
	}
	
	/**
	 * ��Ӷ�������
	 * @return
	 * @throws Exception
	 */
	public String addSecondType() throws Exception {
		
		secondType.setLastModifyTime(System.currentTimeMillis());
		
		bookTypeManager.addSecondType(secondType);
		
		return SUCCESS;
	}
	
	/**
	 * �������
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
