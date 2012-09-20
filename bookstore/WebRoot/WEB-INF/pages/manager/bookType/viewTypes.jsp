<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类管理</title>

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
		<div id="side" >
			<jsp:include page="../treeNav.jsp"></jsp:include>
		</div>
		<div id="main">
			<jsp:include page="types.jsp"></jsp:include>
			
			<div>
				<div><a href="type_toAddFirstType.action">添加一级分类  </a> </div>
				<div><a href="type_toAddSecondType.action">添加二级分类 </a>  </div>
			</div>
			
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>