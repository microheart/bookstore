<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<style type="text/css">

	.listType {
		background-color: #EEEEEE;
		width:200px;
		height:auto;
		font-size:14px;
		float:left;
		text-align:left;
		margin:5px;
	}
	
	.listType ul {
		padding:2px 5px;
		border-bottom:1px solid gray;
	}
	
	.listType ul li {
		padding:2px 20px;
		
	}

</style>

<div class="listType">
	
	<s:iterator value="firstTypes" id="firstType" >
		<ul class="">
			<li> <strong><s:property value="typeName"/></strong>  
				<ul>
					<s:iterator value="subTypes">
						<li>  <s:property value="typeName"/> </li>
					</s:iterator>
				</ul>
			</li>
		</ul>
	</s:iterator>
	
</div>

<div class="clear1"></div>







