<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:actionerror/>
	<div class="registerKuang">
		<s:form action="member_register" method="post">
			<div class="danwei">
				<span class="title"><span style="color:red">*</span>用户名：</span>
				<input type="text" class="textbox180" name="member.loginName" value="${member.loginName}" />
				<span></span>
			</div>
			<div class="danwei">
				<span class="title"><span style="color:red">*</span>密 码：</span>
				<input type="password" name="member.password" class="textbox180"  />
				<span></span>
			</div>
			<div class="danwei">
				<span class="title"><span style="color:red">*</span>确认密码：</span>
				<input type="password" name="repassword" class="textbox180" />
				<span></span>
			</div>
			<div class="danwei">
				<span class="title">真 名：</span>
				<input type="text" class="textbox180" name="member.trueName" value="${member.trueName}"/>
			</div>
			<div class="danwei">
				<span class="title"><span style="color:red">*</span>性别：</span>
				<div style="text-align: left;">
					<input type="radio" name="member.gender" value="男" checked="checked"/> 男 &nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="radio" name="member.gender" value="女" /> 女
				</div>
			</div>
			<div class="danwei">
				<span class="title">邮 箱：</span>
				<input type="text" class="textbox180" name="member.email" value="${member.email}" />
			</div>
			<div class="danwei">
				<span class="title">地 址：</span>
				<input type="text" class="textbox300" name="member.address" value="${member.address}" />
			</div>
			<div class="danwei">
				<span class="title">邮 编：</span>
				<input type="text" class="textbox180" name="member.postcode" value="${member.postcode}" />
			</div>
			<div class="danwei">
				<span class="title">电  话：</span>
				<input type="text" class="textbox180" name="member.tel" value="${member.tel}"/>
			</div>
			
			<div class="danwei">
				<input type="submit" value="注册" class="btn_black4" />
			</div>

		</s:form>
	</div>
	<dir></dir>
</div>