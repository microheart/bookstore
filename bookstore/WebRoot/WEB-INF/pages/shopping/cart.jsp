<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="js/jquery-1.3.2.js"></script>

<script type="text/javascript">
	
	function deleteCartItem(obj) {
		var bookId = $(obj).attr("bookId");
		
		if(!confirm("您确定删除这本图书")) 
			return false;
		
		$.post(
			"shopping_deleteCartItem.action" ,
			{"bookId":bookId},
			function(data) {
				 $("#cart_"+bookId).remove();
				 $("#amount").text(data.amount);
			},
			"json"
		);
	}
	
	function modifyCartItemCount(obj) {
		var bookId = $(obj).attr("bookId");
		var count = $(obj).attr("value");
		
		if(count <= 0) {
			alert("数量不能小于或等于0");
			$(obj).attr("value",$(obj).attr("currentCount"));
			return false;
		}
		
		$.post(
			"shopping_modifyCartItemCount.action",
			{"bookId":bookId,"count":count},
			function(data) {
				$(obj).attr("currentCount",count)
				$("#amount").text(data.amount);
			},
			"json"
		);
	}
	
</script>

<div style="margin:20px 0;" >

	<h2 class="green14b" >您已选购以下商品</h2>
	<div class="choice_bord">
	
		<table  class="tabl_buy" >
			<tr class="buy_title">
				<td>商品名</td>
				<td>市场价</td>
				<td>会员价</td>
				<td>数量</td>
				<td>管理</td>
			</tr>
			
			<s:iterator value="orderDetails">
				<tr bordercolor="gray" id="cart_${bookId}">
					<td><a target="_blank" href="book_viewBook.action?bookId=${bookId}" title="${bookName}"><s:property value="bookName"/> </a></td>
					<td><span><s:property value="price"/> </span></td>
					<td><span class="orange12">${price*rebate} </span>(${rebate*100}折)</td>
					<td>
						<input type="text" onblur="modifyCartItemCount(this)" value="${count}"
							maxlength="4" size="3" bookId="${bookId}" currentCount="${count}" />
						<input type="hidden" name="bookId" value="${bookId}" />
					</td>
					<td>
						<a href="#" name="Remove" onclick="deleteCartItem(this);" bookId="${bookId}">删除</a>
					</td>
				</tr>
	
			</s:iterator>
				
		</table>
		
		<div class="dashed1"></div>		
		<div><span class="black14b">商品金额总计：</span><span class="orange14b">￥<span id="amount">${amount}</span></span> </div>

	</div>
	
	<div style="padding:20px 0;">
		<a href="home.action" style="padding-right:40px;"><img src="images/jxgw.gif" /></a> 
		<a href="shopping_checkout.action"><img src="images/jrjs.gif" /> </a> 
	</div>
</div>