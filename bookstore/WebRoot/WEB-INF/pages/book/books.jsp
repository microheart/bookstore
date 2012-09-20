<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags" %>

<div>

	<div class="tw_bk">		
		<s:iterator value="%{dataPageOfBooks.data}">	
			<s:url action="book_viewBook" id="bookUrl">
				<s:param name="bookId">${bookId}</s:param>
			</s:url>			
			<div class="tw_left">
				<a target="_blank" href="${bookUrl}"><img width="100" src="images/thumbnails/${picture}"/></a>
			</div>
										
			<div class="tw_right">
				<div class="tw_right_box">
					<a class="unblue14a" target="_blank" href="${bookUrl}"> <s:property value="bookName"/> </a><br/>
					<span class=""><br/>
						作者：<s:property value="author" /> <br/>
						出版日期：<p:dateTimeFormat pattern="yyyy年MM月" type="long" value="${publishDate}" /><br/>
						出版社：<s:property value="publisher"/>
					</span>
					<div class="tw_right_buy">市 场 价：￥${price}优惠价：
						<span class="orange12">￥${price*rebate}</span>
						<a href="shopping_addCartItem.action?bookId=${bookId}" target="_blank"><img src="images/buy02.jpg"/></a>
					</div>
				</div>
			</div>
		
			<div class="clear1"></div>
			<div class="dashed1"></div>
		</s:iterator>							
	</div>
	
</div>