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
	</head>
	<body>
        <div class="box">
        	<div id="HBox">
			<form id="edit" action="" method="post" onsubmit="return false;">
				<ul class="list">
					<li>
						<strong>昵 称  <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="text" name="nickname" value="" class="ipt nickname" /></div>
					</li>
					<li>
						<strong>手 机 <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="text" name="phone" value="" class="ipt phone" /></div>
					</li>
					<li>
						<strong>邮 箱 <font color="#ff0000">*</font></strong>
						<div class="fl"><input type="text" name="email" value="" class="ipt email" /></div>
					</li>
					<li>
						<strong>性 别 <font color="#ff0000">&nbsp;</font></strong>
						<div class="fl">
							<label class="mr10"><input type="radio" name="sex" value="1"/>男</label>
							<label class="mr10"><input type="radio" name="sex" value="2"/>女</label>
							<label><input type="radio" name="sex" value="3"/>保密</label>
						</div>
					</li>
					<li>
						<strong>爱 好 <font color="#ff0000">&nbsp;</font></strong>
						<div class="fl">
							<label class="mr10"><input type="checkbox" name="like" value="男" />男</label>
							<label class="mr10"><input type="checkbox" name="like" value="女"/>女</label>
							<label><input type="checkbox" name="like" value="都喜欢"/>都喜欢</label>
						</div>
					</li>
					<li><input type="submit" value="确认提交" class="submitBtn" /></li>
				</ul>
			</form>
			</div><!-- HBox end -->	
        </div>
	</body>
	
<script src="<%=basePath%>/js/jquery.min.js"></script>
<script src="<%=basePath%>/js/jquery.hDialog.js"></script>
<script type="text/javascript">
	
	$('.add').hDialog({title: '测试弹框标题',height: 300});
	
</script>
</html>
