<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>订单列表</title>
		<link type="text/css" rel="stylesheet" href="style/navList.css" />
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
		
		<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$(".deleteOrder").click( function() {
					var orderId = $(this).attr("orderId");
					
					if(!confirm("您确定删除此条订单记录吗？"))
						return false;
						
					$.post(
						"shopping_deleteOrder.action",
						{"orderId":orderId},
						function() {
							$("#order_"+orderId).remove();
							$("#orderCount").text($("#orderCount").text()-1);
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
						<div>	
							<table class="table">
								<thead>
									<tr class="table_header">
										<td>订单号</td>
										<td>收货人</td>
										<td>订单总金额</td>
										<td>下单时间</td>
										<td>处理时间</td>
										<td>管理</td>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="dataPageOfOrder.data">
									<tr id="order_${orderId}">
										<td><a target="_blank" href="shopping_viewOrder.action?orderId=${orderId}" ><s:property value="orderId"/></a> </td>
										<td><s:property value="trueName" /> </td>
										<td>￥<s:property value="amount" /> </td>
										<td><p:dateTimeFormat value="${orderTime}" /> </td>
										<td>
											<s:if test="status == 0">
												<span>尚未处理 </span>
											</s:if>
											<s:else>
												<p:dateTimeFormat value="${dealTime}" />
											</s:else>
										 </td>
										<td><a href="shopping_toEditOrder.action?orderId=${orderId}">编辑</a>　<a href="javascript:void(0)" class="deleteOrder" orderId="${orderId}">删除</a></td>
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

