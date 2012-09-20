<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="list_box">
	<div class="list_bk">
	
	<div class="list_title">图书分类</div>
	
	<!-- 
		book_listBooksByType.action?firstTypeId=${typeId} 
		book_listBooksByType.action?secondTypeId=${typeId}
	-->
	
	<s:iterator value="firstTypes" id="firstType" >
		<ul class="point02">
			<s:url action="book_listBooksByType" id="ftUrl" >
				<s:param name="firstTypeId">${firstType.typeId} </s:param>
			</s:url>
			<li> <a href="${ftUrl}"> <strong><s:property value="typeName"/></strong> </a> </li>
		
		<s:iterator value="subTypes" id="secondType"  >
			<s:url action="book_listBooksByType" id="stUrl" >
				<s:param name="secondTypeId">${secondType.typeId} </s:param>
			</s:url>
			<li> <a href="${stUrl}"> <s:property value="typeName"/> </a> </li>
		</s:iterator>
		
		</ul>
	</s:iterator>
	
	</div>
</div>
