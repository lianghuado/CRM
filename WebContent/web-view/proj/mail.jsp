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
			<div class="col-sm-12 text-center">邮件</div>
		</div>
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div>
					<textarea rows="5" class="form-control border-b"></textarea>
				</div>

				<div>&nbsp;</div>
				<div>
					<button class="btn btn-sm btn-success" onclick="send();">发送到目标邮箱:</button>
					<input type="text" id="target" class="input-sm border-a" />
				</div>
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
	<script>
		function send(){
			$.post("demo/send",{
				cont:$.trim($("#cont").val()),
				target:$.trim($("#target").val())
				},function(data){
					layer.msg(data);
			});
			
			
		}
	</script>
</body>
</html>
