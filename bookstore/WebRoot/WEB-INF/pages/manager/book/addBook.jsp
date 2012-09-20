<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加图书</title>
		<link type="text/css" rel="stylesheet" href="style/navList.css" />
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />

		<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
		<script type="text/javascript" src="js/datepicker/WdatePicker.js"></script>


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
					<s:fielderror></s:fielderror>
					<h1 class="green14b" style="padding-left: 50px;">
						添加图书
					</h1>
					<div class="inputKuang">
						
						<s:form action="book_addBook" method="post" enctype="multipart/form-data" theme="simple">
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>图书名：</span>
								<input type="text" name="book.bookName" class="textbox180" value="${book.bookName}" />
								<span></span>
							</div>
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>ISBN:</span>
								<input type="text" name="book.isbn" class="textbox180" value="${book.isbn}" />
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>作者:</span>
								<input type="text" name="book.author" class="textbox180" value="${book.author}" />
								<span></span>
							</div>
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>出版社:</span>
								<input type="text" name="book.publisher" class="textbox180" value="${book.publisher}" />
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>出版时间:</span>
								<input id="publishDate" name="publishDate" type="text" class="Wdate textbox180"
									onclick="WdatePicker()" readonly="readonly" size="25"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd})" /><span></span>
							</div>							
							<div class="danwei">
								<span class="title">一级类别:</span>
								<select name="firstTypeId" class="textbox180" style="height:auto;">
									<s:iterator value="firstTypes" id="firstType">
										<option value="${typeId}">
											<s:property value="typeName" />
										</option>
									</s:iterator>
								</select>
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>二级类别</span>
								<select name="book.typeId" class="textbox180" style="height:auto;">
									<s:iterator value="secondTypes" id="secondType">
										<option value="${typeId}">
											<s:property value="typeName" />
										</option>
									</s:iterator>
								</select>
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>原价:</span>
								<input type="text" name="book.price" class="textbox180" value="${book.price}" />
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>折扣:</span>
								<input type="text" name="book.rebate" class="textbox180" value="${book.rebate}" />
								<span></span>
							</div>	
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>库存:</span>
								<input type="text" name="book.nowCount" class="textbox180" value="${book.nowCount}" />
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>新书:</span>
								<div style="float: left;width: 180px;">
									<s:radio name="book.isNewBook" list="#{'新书':'T','不是新书':'F'}"
										listKey="value" listValue="key" value="%{'T'}">
									</s:radio>
								</div>
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>推荐:</span>
								<div style="float: left;width: 180px;">
									<s:radio name="book.isCommend" list="#{'推荐':'T','不推荐':'F'}"
										listKey="value" listValue="key" value="%{'T'}">
									</s:radio>
								</div>
								<span></span>
							</div>	
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>封面图片:</span>
								<s:file name="cover" cssStyle="float:left;" ></s:file>
								<span></span>
							</div>							
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>简介:</span>
								<div class="normaltextarea490">
									<textarea name="book.introduce" id="taskContent" id="textarea"
										cols="32" rows="4" class=" textarea490">${book.introduce}</textarea>
								</div>
								<span></span>
							</div>		
							<div class="clear0"></div>					
							<div class="danwei">
								<input type="submit" value="添加" class="btn_black" />
							</div>																						
						</s:form>
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