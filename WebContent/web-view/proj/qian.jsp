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
			<div class="col-sm-12 text-center">前端强化</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<button class="btn btn-sm btn-success" id="mybtn" name="mybtn">按钮</button>
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
	<script src="web-part/easy/js/test.js"></script>
	<script>
		function Teacher(name,sex,age){
			this.name=name;
			this.age=age;
			this.sex=sex;
		}
		
		Teacher.prototype.skill="教书";
		var t1=new Teacher("张三", "男", 30);
		//layer.msg(t1.sex);
		
		!function(){
			$("#mybtn").click(function(){
				$("#mybtn").f1();
				$.f1();
			});
		}();
	</script>
</body>
</html>
