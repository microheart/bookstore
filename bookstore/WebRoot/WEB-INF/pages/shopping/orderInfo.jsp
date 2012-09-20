<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>订单结算</title>
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/order.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../header.jsp"></jsp:include>
			<div id="content">
				<div class="orderstatus">
					<span class="black14b">订单号：${order.orderId}</span>
					<span class="black14b">下单时间：</span>
					<span><p:dateTimeFormat pattern="yyyy-MM-dd HH:mm:ss"
							value="${order.orderTime}" type="long" /> </span>


					<s:if test="order.status == 0">
						<span class="black14b">尚未处理</span>
					</s:if>
					<s:else>
						<span class="black14b">交易成功</span>
						<span class="black14b">发货时间：</span>
						<span class="t_time_n"><p:dateTimeFormat
								pattern="yyyy-MM-dd HH:mm:ss" value="${order.dealTime}"
								type="long" />
						</span>
					</s:else>
				</div>
				<div class="border" style="background-color: #FEF8E7;">
					<div id="div_consignee">
						<div class="kuang">
							<h3>
								收货人信息
							</h3>
							<div class="m_list">
								<span class="text"> 收货人：</span>
								<span>${order.trueName}</span>
							</div>

							<div class="m_list">
								<span class="text">详细地址：</span>
								<!-- (单位地址)江南大学蠡湖校区桂圆公寓10号楼311室 -->
								<span>${order.address}</span>
							</div>

							<div class="m_list">
								<span class="text">邮政编码：</span>
								<!-- 214122 -->
								<span>${order.postcode}</span>
							</div>

							<div class="m_list">
								<span class="text">电话：</span>
								<span>${order.tel}</span>
							</div>


						</div>
					</div>

					<div id="div_shipment">
						<div class="kuang">
							<h3>
								送货方式
							</h3>
							<div>
								<span>${order.carry}</span>
							</div>
						</div>
					</div>

					<div id="div_payment">
						<div class="kuang">
							<h3>
								付款方式
							</h3>
							<div>
								<span>${order.pay}</span>
							</div>
						</div>
					</div>

					<div id="div_cartItems">
						<div class="kuang">
							<h3>
								商品清单
							</h3>

							<div id="div_order_all" class="">
								<div class="choice_bord">

									<table class="tabl_buy">
										<tr class="buy_title">
											<td>
												商品名
											</td>
											<td>
												市场价
											</td>
											<td>
												会员价
											</td>
											<td>
												数量
											</td>
											<td>
												小计
											</td>
										</tr>

										<s:iterator value="order.orderDetails">
											<tr bordercolor="gray" id="cart_${bookId}">
												<td>
													<a target="_blank"
														href="book_viewBook.action?bookId=${bookId}"
														title="${bookName}"><s:property value="bookName" /> </a>
												</td>
												<td>
													<span><s:property value="price" /> </span>
												</td>
												<td>
													<span class="orange12">${price*rebate} </span>(${rebate*100}折)
												</td>
												<td>
													<span>${count}</span>
												</td>
												<td>
													<s:property value="%{price*rebate*count}" />
												</td>
											</tr>

										</s:iterator>

									</table>

								</div>


								<div class="dashed1"></div>
								<div>
									<span class="black14b">您已经为订单支付了：</span><span class="orange14b">￥<span
										id="amount">${order.amount}</span> </span>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
	</body>
</html>




