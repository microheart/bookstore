<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="border">
	<s:form action="shopping_submitOrder.action" method="post" theme="simple">
	<div id="div_consignee">
		<div class="kuang">
			<h3>
				收货人信息
			</h3>
			<div class="m_list">
				<span class="text"> 收货人：</span>
				<input type="text" name="order.trueName" value="${member.trueName}" id="ship_name" maxlength="40"
					class="textbox_4" />
			</div>

			<div class="m_list">
				<span class="text">详细地址：</span>
				<!-- (单位地址)江南大学蠡湖校区桂圆公寓10号楼311室 -->
				<input type="text" name="order.address" value="${member.address}"
					id="txt_ship_address" maxlength="100" class="textbox_1" />
			</div>

			<div class="m_list">
				<span class="text">邮政编码：</span>
				<!-- 214122 -->
				<input type="text" name="order.postcode" value="${member.postcode }" id="txt_ship_zip" maxlength="20"
					class="textbox_4" />
				<span class="m_list_notice">请务必正确填写您的邮编，以确保订单顺利送达。</span>
			</div>

			<div class="m_list">
				<span class="text">电话：</span>
				<input type="text" name="order.tel" maxlength="20" value="${member.tel}"
					id="txt_ship_mb" class="textbox_4" />
			</div>


		</div>
	</div>

	<div id="div_shipment">
		<div class="kuang">
			<h3>
				送货方式
			</h3>
			<ul>
				<li>
					<input type="radio" name="order.carry" value="普通快递"
						checked="checked">
					普通快递送货上门
				</li>
				<li>
					<input type="radio" name="order.carry" value="普通邮递">
					普通邮递
				</li>
				<li>
					<input type="radio" name="order.carry" value="邮政特快专递">
					邮政特快专递
				</li>
			</ul>
		</div>
	</div>

	<div id="div_payment">
		<div class="kuang">
			<h3>
				付款方式
			</h3>
			<ul>
				<li>
					<input type="radio" name="order.pay" value="网上支付" checked="checked">
					网上支付
				</li>
				<li>
					<input type="radio" name="order.pay" value="货到付款">
					货到付款
				</li>
				<li>
					<input type="radio" name="order.pay" value="邮局汇款">
					邮局汇款
				</li>
				<li>
					<input type="radio" name="order.pay" value="银行转帐">
					银行转帐
				</li>
			</ul>
		</div>
	</div>

	<div id="div_cartItems">
		<div class="kuang">
			<h3>
				商品清单
			</h3>

			<div class="business_name">
				<span class="back_shop"> <a href="shopping_cart.action">回到购物车，删除或添加商品</a>
				</span>
			</div>

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

						<s:iterator value="orderDetails">
							<tr bordercolor="gray" id="cart_${bookId}">
								<td>
									<a target="_blank" href="book_viewBook.action?bookId=${bookId}"
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
					<span class="black14b">您需要为订单支付：</span><span class="orange14b">￥<span
						id="amount">${amount}</span> </span>
				</div>
			</div>

			<!--增加div_order_part区域-->
			<div id="div_order_part" />

				<div class="order_refer" style="text-align: center;">
					<span >请核对以上信息，点击“提交订单”</span>
					<input type="image" src="images/butt_refer.gif" onclick="this.form.submit()" alt="提交订单" />
				</div>
			</div>
		</div>
	</div>
	</s:form>
</div>


