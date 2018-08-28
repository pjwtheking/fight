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
	    	.opacity{
	    		opacity: 0.5;
	    	}
	    </style>
	</head>
	
	<body>
	  	<div class="mybox">
			<form id="dailyForm" action="<%=basePath %>/daily/page.action"  method="post">
				<c:if test="${not empty list }">
					<ul>
			            <c:forEach items="${list }" var="daily" varStatus="status">
			         		<li>记账类目：${daily.itemTypeName }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>金额：${daily.amount }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>备注：${daily.remark }&nbsp;&nbsp;&nbsp;&nbsp;<b>|</b>类型：${daily.accbookTypeName }</li>
		        		</c:forEach>
		        		<li>&nbsp;</li>
		        		<li>上一页：${page.prePage}&nbsp;&nbsp;|&nbsp;&nbsp;当前页：${page.pageNo}&nbsp;&nbsp;|&nbsp;&nbsp;下一页：${page.nextPage}&nbsp;&nbsp;|&nbsp;&nbsp;总页数：${page.tatolPage}&nbsp;&nbsp;|&nbsp;&nbsp;总记录数：${page.dataCount}</li>
	        		</ul>
		        </c:if>
		        <c:if test="${empty list }">
		        	<h2 class="opacity" style="margin-left: -400px; margin-top: 50px;">没有数据</h2>
		        </c:if>
			</form>
	    </div>
	</body>
	
</html>
