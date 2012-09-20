<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会员列表</title>
		<link type="text/css" rel="stylesheet" href="style/navList.css" />
		<link type="text/css" rel="stylesheet" href="style/base.css" />
		<link type="text/css" rel="stylesheet" href="style/layout.css" />
		<link type="text/css" rel="stylesheet" href="style/booklist.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
		
		<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".deleteMember").click( function() {
					var memberId = $(this).attr("memberId");
					
					if(!confirm("您确定删除此会员吗？"))
						return false;
						
					$.post(
						"member_deleteMember.action",
						{"memberId":memberId},
						function() {
							$("#member_"+memberId).remove();
							$("#memberCount").text($("#memberCount").text()-1);
						},
						"json"
					);
				});
			});
		</script>
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
						<s:form action="admin_listMembersByName" method="post" theme="simple">
						<div class="danwei">
							<span class="title">用户名：</span>
							<input type="text" class="textbox180" name="name" />
							<span style="float:left;"><input type="submit" value="搜索" class="btn_black" /></span>
						</div>
						<div class="clear1"></div>
						</s:form>
						<div>	
							<div style="text-align: left;font-weight: bold;" >共搜索到<span style="color:red" id="memberCount"><s:property value="dataPageOfMember.totalCount"/> </span>个用户 </div>
							<table class="table">
								<thead>
									<tr class="table_header">
										<td>用户名</td>
										<td>密  码</td>
										<td>性  别</td>
										<td>邮  箱</td>
										<td>消费金额</td>
										<td>注册时间</td>
										<td>用户管理</td>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="dataPageOfMember.data">
									<tr id="member_${memberId}">
										<td><s:property value="loginName"/> </td>
										<td><s:property value="password" /> </td>
										<td><s:property value="gender" /> </td>
										<td><s:property value="email" /> </td>
										<td>￥<s:property value="amount" /> </td>
										<td><p:dateTimeFormat value="${registerTime}" /> </td>
										<td><a href="#">编辑</a>　<a href="javascript:void(0)" class="deleteMember" memberId="${memberId}">删除</a></td>
									</tr>									
								</s:iterator>
								</tbody>
							</table>
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

