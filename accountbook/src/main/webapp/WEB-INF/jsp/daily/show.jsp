<%@ page contentType="text/html;charset=UTF-8" language="java"  session="false" %>
<%@ include file="/common/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="<%=basePath%>/css/common.css"/>
		<link rel="stylesheet" href="<%=basePath%>/css/animate.min.css"/>
	    <title>记账本</title>
	    <style type="text/css">
	    	.mybox{
	    		width: 1020px; 
	    		height: auto; 
	    		margin: auto;
	    		padding: 10px;
	    		text-align: center;
	    	}
	    	.div_seach{
	    		padding: 10px; 
	    		border-bottom: 1px solid;
	    	}
	    	.left{
	    		width: 497px; 
	    		height: auto;
	    		float: left;
	    		margin-top: 30px;
	    		padding-bottom: 30px;
	    		border-right: 2px solid #DDDDDD;
	    	}
	    	.right{
	    		width: 497px; 
	    		height: auto;
	    		float: left;
	    		margin-top: 30px;
	    		margin-left: 20px;
	    		padding-bottom: 30px;
	    	}
	    	.opacity{
	    		opacity: 0.5;
	    	}
	    	.left_01{
	    		width: auto; 
	    		height: auto;
	    		float: left;
	    	}
	    	.img_seach{
	    		height: 23px;
	    		float: left;
	    		border: 1px solid #DDDDDD;
	    		margin-left: 10px;
	    		cursor: pointer;
	    	}
	    	.mybox li{
	    		float: left;
	    	}
	    </style>
	</head>
	
	<body>
	  	<div class="mybox">
		<form id="dailyForm" action="<%=basePath %>/daily/show.action"  method="post">
	        <div class="div_seach" >
	        	<b class="left_01">查询日期：</b><input type="date" class="left_01" name="createtime" value="${query }" >
	        	<img class="img_seach" src="<%=basePath%>/image/seach.jpg" alt="搜索" onclick="seach()" />
	        	<input type="button" class="add" value="新增记账" onclick="add()" style="margin-left: 500px;">
	        </div>
	        <p style="clear: both;"></p>
			<c:if test="${not empty list }">
	            <div class="left">
	            	<p style="margin-bottom: 10px;"><b>老公记账明细</b></p>
	            	<ul>
	         			<c:forEach items="${list }" var="daily" varStatus="status">
			         		<c:if test="${daily.keeperCode == '01'}">
								<li>记账类目：${daily.itemTypeName }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>金额：${daily.amount }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>备注：${daily.remark }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>类型：${daily.accbookTypeName }</li>
							</c:if>
		        		</c:forEach>
	         		</ul>
	         	</div>
	         	<div class="right">
	         		<p style="margin-bottom: 10px;"><b>老婆记账明细</b></p>
	         		<ul>
	         			<c:forEach items="${list }" var="daily" varStatus="status">
			         		<c:if test="${daily.keeperCode == '02'}">
								<li>记账类目：${daily.itemTypeName }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>金额：${daily.amount }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>备注：${daily.remark }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>类型：${daily.accbookTypeName }</li>
							</c:if>
		        		</c:forEach>
	         		</ul>
	         	</div>
	        </c:if>
	        <c:if test="${empty list }">
	        	<h2 class="opacity" style="margin-left: -400px; margin-top: 50px;">今天没有数据</h2>
	        </c:if>
		</form>
	    </div>
		
		<div id="HBox">
			<form id="save" action="<%=basePath %>/daily/save.action" method="post">
				<ul class="list">
					<li>
						<strong>记账人 <font color="#ff0000">&nbsp;</font></strong>
						<div class="fl">
							<label class="mr10"><input type="radio" checked="checked" name="keeperCode" value="01"/>老公</label>
							<label class="mr10"><input type="radio" name="keeperCode" value="02"/>老婆</label>
						</div>
					</li>
					<li>
						<strong>日期 <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="date" name="createtime" class="ipt nickname" /></div>
					</li>
					<li>
						<strong>类型 <font color="#ff0000">*</font></strong>
						<div class="fl">
							<select name="accbookTypeCode">
								<option value="01">支出</option>
								<option value="02">收入</option>
							</select>
						</div>
					</li>
					<li>
						<strong>类目 <font color="#ff0000">*</font></strong>
						<div class="fl">
							<select name="itemTypeCode">
								<option value="01">个人用餐</option>
								<option value="02">买菜水果</option>
								<option value="03">生活用品</option>
								<option value="04">化妆品</option>
								<option value="05">首饰衣服</option>
								<option value="06">社交费用</option>
								<option value="07">为爱而生</option>
								<option value="08">百善孝为先</option>
								<option value="09">财政收入</option>
							</select>
						</div>
					</li>
					<li>
						<strong>金额 <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="text" name="amount" value="" class="ipt nickname" /></div>
					</li>
					<li>
						<strong>备注 <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="text" name="remark" value="" class="ipt nickname" /></div>
					</li>
					<li><input type="submit" value="确认提交" class="submitBtn" /></li>
				</ul>
			</form>
		</div><!-- HBox end -->	
		
	</body>

<script src="<%=basePath%>/js/jquery-1.4.2.js"></script>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<script src="<%=basePath%>/js/jquery.hDialog.js"></script>
<script type="text/javascript">

	var $el = $('.dialog');
	$el.hDialog();
	
	function seach(){
	   $("#dailyForm").submit();
	}
	
	$('.add').hDialog({title: '新增记账记录',height: 360});
	
</script>
</html>
