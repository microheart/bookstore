<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加二级分类</title>
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
					<div class="right">
						<div class="inputKuang">
							<s:form action="type_addSecondType" method="post" theme="simple">

								<table cellspacing="8">
									<tr>
										<td class="title120">
											请选择上级分类：
										</td>
										<td>
											<select name="secondType.superId" size="1" style="width:100px;">
												<s:iterator value="firstTypes" id="firstType">
													<option value="${typeId}">
														<s:property value="typeName" />
													</option>
												</s:iterator>
											</select>
										</td>
									</tr>
									<tr>
										<td class="title120">
											分类名：
										</td>
										<td>
											<div class="normal190">
												<input type="text" name="secondType.typeName"
													class="text190" />
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="2" style="padding-top: 10px;">
											<input type="submit" class="btn_black" value="确定" />
										</td>
									</tr>
								</table>

							</s:form>
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<jsp:include page="../../footer.jsp"></jsp:include>
			</div>
		</div>

	</body>
</html>