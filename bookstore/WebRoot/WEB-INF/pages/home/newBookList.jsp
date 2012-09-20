<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<h1> 
	<span class="green14b">新书展示</span>
	<a href="book_listNewBooks.action" class="brownae6e09a">更多新书</a>
</h1>


<div class="info_bk1">

	<s:iterator value="%{dataPageOfNewBooks.data}">
		<div class="xh4">
			<s:url action="book_viewBook" id="bookUrl">
				<s:param name="bookId">${bookId}</s:param>
			</s:url>
			<a  href="${bookUrl}"> <img width="160" src="images/thumbnails/${picture}"/></a><br/>
			<a title="${bookName}" class="blue12a" target="_blank" href="${bookUrl}"><s:property value="bookName"/> </a><br/>
			￥${price}<span class="redf00">￥${price*rebate}</span>
			<span class="gray12italic">(${rebate*10}折)</span>
		</div>		
	</s:iterator>

	<div class="clear1"></div>
	
</div>

<div class="clear1"></div>

<h1> 
	<span class="green14b">经典推荐</span>
	<a href="book_listCommendBooks.action" class="brownae6e09a">更多推荐图书</a>
</h1>

<div class="info_bk1">

	<s:iterator value="%{dataPageOfCommendBooks.data}">
		<div class="xh4">
			<s:url action="book_viewBook" id="bookUrl">
				<s:param name="bookId">${bookId}</s:param>
			</s:url>
			<a target="_blank" href="${bookUrl}"> <img width="160" src="images/thumbnails/${picture}"/></a><br/>
			<a title="${bookName}" class="blue12a" target="_blank" href="${bookUrl}"><s:property value="bookName"/> </a><br/>
			￥${price}<span class="redf00">￥${price*rebate}</span>
			<span class="gray12italic">(${rebate*10}折)</span>
		</div>		
	</s:iterator>

	<div class="clear1"></div>
	
</div> 

<h1> 
	<span class="green14b">热销排行</span>
	<a href="book_listHotSaleBooks.action" class="brownae6e09a">更多热销图书</a>
</h1>

<div class="info_bk1">

	<s:iterator value="%{dataPageOfHotSaleBooks.data}">
		<div class="xh4">
			<s:url action="book_viewBook" id="bookUrl">
				<s:param name="bookId">${bookId}</s:param>
			</s:url>
			<a target="_blank" href="${bookUrl}"> <img width="160" src="images/thumbnails/${picture}"/></a><br/>
			<a title="${bookName}" class="blue12a" target="_blank" href="${bookUrl}"><s:property value="bookName"/> </a><br/>
			￥${price} <span class="redf00">￥${price*rebate}</span>
			<span class="gray12italic">(${rebate*10}折) </span>
		</div>		
	</s:iterator>

	<div class="clear1"></div>
	
</div> 



