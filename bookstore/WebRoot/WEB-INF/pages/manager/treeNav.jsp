<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

$(document).ready(function() {

	$(".mainTitle").click(function() {	

		if($(this).parent().children("ul").css("display") == 'block') {
			$(this).parent().children("a").attr("class","mainTitle2");
		}
		else {
			$(this).parent().children("a").attr("class","mainTitle");
		}				
		$(this).parent().children("ul").toggle();
	});
});

</script>


<div id="nav_list">	
    <div class="nav">

    <ul id="globalNav" >
    
		<li><a class="mainTitle" href="javascript:void(0)" ><b>用户管理</b></a>
			<ul style="display:block">	
				<li><a href="admin_listMembers.action"  >查询用户</a></li>	
				<li><a href="admin_listAdmins.action"  >查询管理员</a></li>		
				<li><a href="admin_toAddAdmin.action"  >添加管理员</a></li>	
				<li><a href="admin_toModifyPassword.action"  >修改密码</a></li>	
			</ul>
		</li>
		
		<li><a class="mainTitle"  href="javascript:void(0)"><b>图书管理</b></a>
			<ul id="ul4">	
				<li><a href="book_adminListBooks.action">查询图书</a></li>			
				<li><a href="book_toAddBook.action">添加图书</a></li>			
			</ul>
		</li>
		
		<li><a class="mainTitle"  href="javascript:void(0)" ><b>分类管理</b></a>
			<ul>		
				<li><a href="type_viewTypes.action" >查看分类</a></li>		
				<li><a href="type_toAddFirstType.action" >添加一级分类</a></li>			
				<li><a href="type_toAddSecondType.action" >添加二级分类</a></li>			
			</ul>
		</li>
		
		<li><a class="mainTitle"  href="javascript:void(0)" ><b>订单管理</b></a>
			<ul>			
				<li><a href="shopping_adminListOrders.action" >浏览订单</a></li>			
				<li><a href="shopping_listDealedOrders.action" >已处理订单</a></li>
				<li><a href="shopping_listNonDealedOrders.action" >未处理订单</a></li>			
			</ul>
		</li>
	
	</ul>
  </div> 
</div>