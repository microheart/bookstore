<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会员登录</title>
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />

		<style type="text/css">
.loginForm {
	background: url(images/login_bg.jpg); border-right : 1px solid rgb( 204,
	204, 204);
	margin: 50px 0pt 30px 50px;
	width: 550px;
	float: left;
	border-right: 1px solid rgb(204, 204, 204);
}

.loginKuang {
	border: 1px solid rgb(204, 204, 204);
	padding: 10px;
	background-color: white;
	width: 400px;
}




</style>

	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../header.jsp"></jsp:include>
			<div id="content" >
				<div class="loginForm">
					<s:form action="member_login.action" method="post" theme="simple">
						<img src="images/login_title.gif" />
						<div class="loginKuang">
							<span >请填写您的会员名和密码</span><br />
							<div class="danwei">
								<span class="title">用户名：</span><input type="text" name="loginName" class="textbox180" />
							</div>
							<div class="danwei">
								<span class="title">密&nbsp;&nbsp;码：</span><input name="password" type="password" class="textbox180"/>
							</div>
							<div class="danwei">
								<input type="image" src="images/login_button.jpg" onclick="this.form.submit()">
							</div>
						</div>

					</s:form>
				</div>
			</div>

			<div id="footer">
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</div>	
	</body>
</html>