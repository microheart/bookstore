<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags" %>

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

</head>
<body>

<div id="wrap">

	<jsp:include page="../header.jsp"></jsp:include>
	
	<div id="content">
		<div id="side" >
			<jsp:include page="../member/personalManageSide.jsp"></jsp:include>
		</div>
		<div id="main">
			<div style="padding:20px 10px 10px 30px" >
				<table  class="tabl_buy" >
					<tr class="buy_title">
						<td>订单号</td>
						<td>收货人</td>
						<td>付款方式</td>
						<td>订单总金额</td>
						<td>订单状态</td>
						<td>下单时间</td>
					</tr>
					
					<s:iterator value="dataPageOfOrder.data">
						<tr bordercolor="gray" >
							<td><a target="_blank" href="shopping_viewOrder.action?orderId=${orderId}" ><s:property value="orderId"/> </a></td>
							<td><span><s:property value="trueName"/> </span></td>
							<td><span><s:property value="pay" /></span> </td>
							<td>
								<span class="black14b">￥<s:property value="amount" /> </span>
							</td>
							<td>
								<s:if test="status == 0">
									<span>尚未处理 </span>
								</s:if>
								<s:else>
									<span>交易成功 </span>
								</s:else>
							</td>
							<td> <span> <p:dateTimeFormat value="${orderTime}"  /> </span> </td>
						</tr>
			
					</s:iterator>
						
				</table>
			</div>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>