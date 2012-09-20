<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/bookstore-tags" %>

<script type="text/javascript">

	function getCurrentTime() {
		var date = new Date();
		
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate() ;
		var hours = date.getHours();
		var miniutes = date.getMinutes();
		var seconds = date.getSeconds();
		
		var currentTime = year+"-"+month + "-" + day + " " + hours + ":" + miniutes + ":" + seconds;
		
		return currentTime;
	}

	function submitComment() {
		var isLogin = $("#isLogin").val();
		if(isLogin == "false") {
			alert("您还没有登陆，请先登录！");
			return ;
		}
		
		var bookId = $("#bookId").val();
		var content = $("#comment_content").val();
		var loginName = $("#loginName").val();
		var nowTime = getCurrentTime();
		
		var commentHtml = "<div class='commentDiv'><div>" + nowTime + "</div><div class='commentName' >"+loginName+"：</div><div>" + content + "</div></div>"
		
		$.post(
			"comment_addComment.action",
			{"bookId":bookId,"content":content},
			function() {
				$("#discus").append(commentHtml);
				$("#comment_content").val("");
			},
			"json"
		);
			
	}

</script>

<div class="left2">
	<h1 class="solid3">
		<span class="black14b">${book.bookName}</span>
		<span id="txtBookStatus"></span>
	</h1>
				
	<div class="left2_shupi">
		<a href="javascript:void(0)"><img width="200" src="images/thumbnails/${book.picture}"/></a>
		<div align="center"><img width="14" height="13" src="images/search03.jpg"/><a target="_blank" href="http://localhost:8080/bookstore/images/originals/${book.picture}" class="blue12a"><span class="gray12">点击看大图</span></a></div>
	</div>

	<div class="left2_info">
		<div class="left2_info_box">
		<table width="540" cellspacing="8" border="0">
			<tbody>
			<tr>
			<td width="80" align="right">会员评价：</td>
			<td width="460" align="left">(<a href="#discus" class="blue1d64b6a">共${dataPageOfComments.totalCount} 条</a>)
				<a href="#commentSubmit" class="blue1d64b6a"> 参与评论</a></td>
			</tr>

			<tr>
				<td align="right">书名：</td>
				<td align="left">${book.bookName}</td>
			</tr>

			<tr>
				<td align="right">作者：</td>
				<td align="left">${book.author}</td>
			</tr>

			<tr>
				<td align="right">出版社：</td>
				<td align="left"><a href="#" class="blue1d64b6a">${book.publisher}</a></td>
			</tr>
							
			<tr>
				<td align="right">书号：</td>
				<td align="left">${book.isbn}
				</td>
			</tr>
			
			<tr>
				<td align="right">出版日期：</td>
				<td align="left"> <p:dateTimeFormat type="long" pattern="yyyy年MM月" value="${book.publishDate}"/> </td>
			</tr>
			
			<tr>
				<td align="right">所属类别：</td>
				<td align="left"><span id="txtBookSort"></span></td>
			</tr>
								
			</tbody>
		</table>

	<div class="dashed1"></div>
	<div class="left2_buy">
		<span class="black14b">市场价： ${book.price} 会员价：</span><span class="orange14b">${book.price*book.rebate}</span><br/>
		<a href="shopping_addCartItem.action?bookId=${book.bookId}" ><img width="58" hspace="3" height="21" id="IMG1" src="images/buy02.jpg"/></a>
	</div>
							
	<div class="clear1"></div>
	<div class="dashed1"></div>
	</div>
	
	<div class="clear1"></div>
	<h2 class="green14b" >内容简介</h2>
	<div class="left2_bk">
		${book.introduce}
	</div>
</div>


<div style="margin-top:20px;">
	<h1 class="green14b">用户评论</h1>
	
	<div class="discus" id="discus">
		<s:iterator value="dataPageOfComments.data">
			<div class="commentDiv">
				<div><p:dateTimeFormat value="${commentTime}" /> </div>
				<div class="commentName" ><s:property value="loginName" />：</div>
				<div ><s:property value="content" /></div>
			</div>
		</s:iterator>
	</div>
	
	<div id="commentSubmit">
	
		<s:if test="#session.member == null">
			<input type="hidden" id="isLogin" value="false">
		</s:if>
		<s:else>
			<input type="hidden" id="isLogin" value="true">
		</s:else>
	
		<table cellspacing="8">
			<tr>
				<td colspan="2">
					<input type="hidden" id="memberId" name="memberId" value="#session.member.memberId">
					<input type="hidden" id="loginName" name="loginName" value="${member.loginName}">
					<input type="hidden" id="bookId" value="${book.bookId}" >
				</td>
			</tr>
			<tr>
				<td>
					<div class="normaltextarea490" style="text-align: center;">
						<textarea name="comment_content" id="comment_content" cols="32" rows="4"
						class=" textarea490"></textarea>
					</div>	
				</td>
			</tr>
			
			<tr><td><input type="button"  class="btn_black" value="提交" onclick="submitComment()" /></td></tr>
		
		</table>
	</div>

</div>







