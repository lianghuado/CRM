<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<!-- css -->
<link rel="stylesheet" href="web-part/boot/bootstrap.min.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
</head>
<body class="bg-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<form id="fm-login" action="mycrm/Employee/login" method="post"
				class="panel panel-default">
					<div class="panel-heading">用户登录</div>
					<div class="panel-body">
						<div>用户名</div>
						<div>
							<input type="text" name="username" class="input-sm form-control"/>
						</div>
						<div>密码</div>
						<div>
							<input type="password" name="pass" class="input-sm form-control"/>
						</div>
						<div> &nbsp;</div>
						<div>
							<button type="submit" class="btn btn-sm btn-default">登录</button>							
						</div>						
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="web-part/easy/js/jquery.js"></script>
	<script src="web-part/boot/bootstrap.min.js"></script>
	<script src="web-part/page/pagination.js"></script>
	<script src="web-part/layer/layer.js"></script>
	<script src="web-part/easy/js/base.js"></script>
	<script src="web-part/tabs/bootstrap-closable-tab.js"></script>
	<script src="web-part/easy/js/jquery.form.js"></script>
	<script>
		//转换为ajax表单
		$("#fm-login").ajaxForm(function(data){			
			if(data!="success"){
				layer.alert("登录失败");
				parent.location.reload();
				return;
			}
			layer.alert("登录成功");
			parent.location.reload();
		});
				
	</script>
</body>
</html>
