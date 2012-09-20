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
    
	<li><a class="mainTitle" href="#" ><b>个人信息管理</b></a>
		<ul style="display:block">	
			<li><a href="member_toEditInfo.action"  >编辑个人档案</a></li>			
			<li><a href="member_toModifyPassword.action"  >修改密码</a></li>			
		</ul>
	</li>
	
	<li><a class="mainTitle"  href="#"><b>订单支付</b></a>
		<ul id="ul4">			
			<li id="li5"><a href="shopping_listOrders.action">查看订单</a></li>			
			<li id="li6"><a href="#">账户余额</a></li>			
		</ul>
	</li>
	
	
	</ul>
  </div> 
</div>