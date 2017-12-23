<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
				<form id="fm-login" action="mycrm/Custom/modifyCus" method="post"
					class="panel panel-default">
					<div class="panel-heading">
						<h5>修改客户</h5>
					</div>
					<div class="panel-body">						
						<div>
							<input type="text" name="id" id="id" class="input-sm form-control" style="display:none"/>
						</div>
						<div>客户姓名</div>
						<div>
							<input type="text" name="name" id="name" class="input-sm form-control" />
						</div>
						<div>客户学历</div>
						<div>
							<input type="text" name="edu" id="edu" class="input-sm form-control" />
						</div>
						<div>客户电话</div>
						<div>
							<input type="text" name="ph" id="ph" class="input-sm form-control" />
						</div>
						<div>qq</div>
						<div>
							<input type="text" name="qq" id="qq" class="input-sm form-control" />
						</div>
						<div>邮箱</div>
						<div>
							<input type="text" name="email" id="email" class="input-sm form-control" />
						</div>												
						<div>客户状态</div>
						<div>
							<input type="text" name="statu" id="cus" class="input-sm form-control" />						
						</div>
						<div>&nbsp;</div>
						<div>
							<button type="submit" class="btn btn-sm btn-default">添加</button>
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
	<script src="web-part/easy/js/jquery.time.js"></script>
	<script src="web-part/easy/js/jquery.form.js"></script>
	<script>			
		//转换为ajax表单
		$("#fm-login").ajaxForm(function(data) {
			if (data != "success") {
				layer.alert("修改失败");
				return;
			}
			layer.alert("修改成功");
		});
	</script>
</body>
</html>
