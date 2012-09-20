<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑个人信息</title>
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../header.jsp"></jsp:include>
			<div id="content">
				<div>
					<s:actionerror />
					<div class="registerKuang">
						<s:form action="member_editInfo" method="post">
							<div class="danwei">
								<span class="title"><span style="color: red">*</span>用户名：</span>
								<span style="float:left; color:#676767;font-weight:bold; ">${member.loginName}</span>
								<span></span>
							</div>
							<div class="danwei">
								<span class="title">真 名：</span>
								<input type="text" class="textbox180" name="member.trueName"
									value="${member.trueName}" />
							</div>
							<div class="danwei">
								<span class="title"><span style="color: red">*</span>性别：</span>
								<div style="text-align: left;">
									<input type="radio" name="member.gender" value="男"
										checked="checked" />
									男 &nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="member.gender" value="女" />
									女
								</div>
							</div>
							<div class="danwei">
								<span class="title">邮 箱：</span>
								<input type="text" class="textbox180" name="member.email"
									value="${member.email}" />
							</div>
							<div class="danwei">
								<span class="title">地 址：</span>
								<input type="text" class="textbox300" name="member.address"
									value="${member.address}" />
							</div>
							<div class="danwei">
								<span class="title">邮 编：</span>
								<input type="text" class="textbox180" name="member.postcode"
									value="${member.postcode}" />
							</div>
							<div class="danwei">
								<span class="title">电 话：</span>
								<input type="text" class="textbox180" name="member.tel"
									value="${member.tel}" />
							</div>

							<div class="danwei">
								<input type="submit" value="保存" class="btn_black4" />
							</div>

						</s:form>
					</div>
					<dir></dir>
				</div>
			</div>
			<div id="footer">
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>

