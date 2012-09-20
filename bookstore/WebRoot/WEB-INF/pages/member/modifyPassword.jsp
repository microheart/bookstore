<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改密码</title>
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
						<s:form action="member_modifyPassword" method="post">
							<div class="danwei">
								<span class="title">用户名：</span>
								<span style="float:left; color:#676767;font-weight:bold; ">${member.loginName}</span>
								<span></span>
							</div>
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>原密码：</span>
								<input type="password" name="password" class="textbox180" value="${member.password}" />
								<span></span>
							</div>
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>新密码：</span>
								<input type="password" name="newPassword" class="textbox180" />
								<span></span>
							</div>
							<div class="danwei">
								<span class="title"><span style="color:red">*</span>确认密码：</span>
								<input type="password" name="repassword" class="textbox180" />
								<span></span>
							</div>
							<div class="danwei">
								<input type="submit" value="保存修改" class="btn_black4" />
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

