<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

	function searchBook() {
		var searchContent = document.getElementById("searchContent").value;
		
		window.location.href = "book_searchBooks.action?searchContent="+searchContent
	}
	
	function whenDown(event) {
		if(event.keyCode == 13) {
			searchBook();
		}
	}

</script>

	<div id="header">
		<div id="head_left"><a href="home.action"><img src="images/logo.jpg"></a></div>
		<div id="head_right">
			<div class="head_top">
				<div class="login_register">
					<s:if test="#session.member == null">
					您好，请先<a href="member_toLogin.action">登陆</a> <a href="member_toRegister.action">注册</a>
					</s:if>
					<s:else>
						您好${member.loginName}
						<a href="member_logout.action">注销</a>
					</s:else> 
				</div>
				<div class="head_buy">
					<img src="images/buy01.jpg">
					<strong><a href="shopping_cart.action">购物车</a></strong>|
					<a href="shopping_listOrders.action">我的书店</a>|
					<a href="#">用户FAQ</a>
				</div>
			</div>

			<div class="head_middle" >
				<div>
					<img src="images/logo3.jpg" style="width:700;height:50;">
				</div>
			</div>

			<div class="head_buttom">
				<div id="navigation">
					<ul>
						<li><a href="home.action">首  页</a></li>
						<li><a href="#">分  类</a></li>
						<li><a href="book_listNewBooks.action">新  书</a></li>
						<li><a href="book_listHotSaleBooks.action">排  行</a></li>
						<li><a href="book_listCommendBooks.action">推  荐</a></li>
					</ul>
				</div>
			</div>
		</div>
	
	<!-- 一定得加上 -->
	<div class="clear0"> </div>
	
	<div id="search" >
		<span class="black14b" >搜索图书</span>
		<input id="searchContent" type="text" name="searchContent" value="${searchContent}" onkeypress="whenDown(event)">
		<a href="javascript:void(0)"><img src="images/search02.jpg" onclick="searchBook()" ></a>
	</div>


	</div> <!-- end header -->
