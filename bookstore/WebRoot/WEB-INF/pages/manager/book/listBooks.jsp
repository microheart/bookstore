<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书列表</title>
		<link type="text/css" rel="stylesheet" href="style/navList.css" />
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
		
		<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
				<script type="text/javascript">
			$(document).ready(function() {
				$(".deleteBook").click( function() {
					var bookId = $(this).attr("bookId");
					
					if(!confirm("您确定删除此本书吗？"))
						return false;
						
					$.post(
						"book_deleteBook.action",
						{"bookId":bookId},
						function() {
							$("#book_"+bookId).remove();
							$("#bookCount").text($("#bookCount").text()-1);
						},
						"json"
					);
				});
			});
		</script>
	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../../header.jsp"></jsp:include>
			<div id="content">
				<div id="side">
					<jsp:include page="../treeNav.jsp"></jsp:include>
				</div>
				<div id="main">
					<div class="right">
						<s:form action="book_adminListBooksByName" method="post" theme="simple">
						<div class="danwei">
							<span class="title">图书名：</span>
							<input type="text" class="textbox180" name="searchContent" />
							<span style="float:left;"><input type="submit" value="搜索" class="btn_black" /></span>
						</div>
						<div class="clear1"></div>
						</s:form>
						<div>	
							<div style="text-align: left;font-weight: bold;" >共搜索到<span style="color:red" id="bookCount"><s:property value="dataPageOfBooks.totalCount"/> </span>本图书 </div>
							<table class="table">
								<thead>
									<tr class="table_header">
										<td>ISBN</td>
										<td>书名</td>
										<td>作者</td>
										<td>价格</td>
										<td>库存量</td>
										<td>销售量</td>
										<td>图书管理</td>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="dataPageOfBooks.data">
									<tr id="book_${bookId}">
										<td> <a href="book_viewBook.action?bookId=${bookId}"> <s:property value="isbn"/> </a>  </td>
										<td><s:property value="bookName"/> </td>
										<td><s:property value="author"/> </td>
										<td>￥<s:property value="price" /> </td>
										<td><s:property value="nowCount" /> </td>
										<td><s:property value="saleCount" /> </td>
										<td><a href="book_toEditBook.action?bookId=${bookId}">编辑</a>　<a href="javascript:void(0)" class="deleteBook" bookId="${bookId}">删除</a></td>
									</tr>									
								</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<jsp:include page="../../footer.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

