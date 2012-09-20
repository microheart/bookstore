<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑订单</title>
		<link type="text/css" rel="stylesheet" href="style/navList.css" />
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
		
		<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../../header.jsp"></jsp:include>
			<div id="content">
				<div id="side">
					<jsp:include page="../treeNav.jsp"></jsp:include>
				</div>
				<div id="main">
				<div>
					<s:actionerror />
					<div class="right" >
						<div class="inputKuang">
						<s:form action="shopping_editOrder" method="post">
							<input type="hidden" name="orderId" value="${order.orderId}" />
							<div class="danwei">
								<span class="normaltitle">收货人：</span>
								<span class="textvalue">${order.trueName}</span>
							</div>
							<div class="danwei">
								<span class="normaltitle">地  址：</span>
								<span class="textvalue">${order.address}</span>
								<span></span>
							</div>			
							<div class="danwei">
								<span class="normaltitle">邮  编：</span>
								<span class="textvalue">${order.postcode}</span>
							</div>							
							<div class="danwei">
								<span class="normaltitle">电  话：</span>
								<span class="textvalue">${order.tel}</span>
							</div>
							<div class="danwei">
								<span class="normaltitle">运送方式：</span>
								<span class="textvalue">${order.carry}</span>
							</div>							
							<div class="danwei">
								<span class="normaltitle">付款方式：</span>
								<span class="textvalue">${order.pay}</span>
							</div>							
							<div class="danwei">
								<span class="normaltitle">金  额：</span>
								<span class="textvalue">￥${order.amount}</span>
							</div>	
							<div class="danwei">
								<span class="title">状  态：</span>
								<span style="float:left;">
									<s:if test="order.status == 0">
										<input type="radio" name="status" value="0" id="nodeal" checked="checked" /><label for="nodeal">暂不处理</label> 
										<input type="radio" name="status" value="1" id="deal" /><label for="deal">处理订单</label>
									</s:if>
									<s:else>
										<input type="radio" name="status" value="0" id="nodeal2"  /><label for="nodeal2">暂不处理</label> 
										<input type="radio" name="status" value="1" id="deal2" checked="checked"/><label for="deal2">处理订单</label>
									</s:else>
								</span>
							</div>											
							<div class="danwei">
								<input type="submit" value="保存" class="btn_black" />
							</div>

						</s:form>
						</div>
					</div>
					<div></div>
				</div>
				</div>
			</div>
			<div id="footer">
				<jsp:include page="../../footer.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

