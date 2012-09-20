<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link type="text/css" rel="stylesheet" href="style/base.css" />
<link type="text/css" rel="stylesheet" href="style/layout.css" />
<link type="text/css" rel="stylesheet" href="style/booklist.css" />
</head>

<body>
<div id="wrap">
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="content">
		<div id="side" >
			<jsp:include page="../bookType/type.jsp"></jsp:include>
		</div>
		<div id="main" style="" >
			<jsp:include page="../home/newBookList.jsp"></jsp:include>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>