<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- css -->
<link rel="stylesheet" href="web-part/boot/bootstrap.min.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
<link rel="stylesheet" href="web-part/side/sidebar-menu.css" />
</head>
<body class="bg-c">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12  text-center">
				<h3>销售助理从数据库导出客户信息到xls</h3>
				<div>&nbsp;</div>
				<button class="btn btn-sm btn-success" onclick="output();">导出</button>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		

	</div>

	<!-- js -->
	<script src="web-part/easy/js/jquery.js"></script>
	<script src="web-part/boot/bootstrap.min.js"></script>
	<script src="web-part/side/sidebar-menu.js"></script>
	<script src="web-part/tabs/bootstrap-closable-tab.js"></script>
	<script src="web-part/layer/layer.js"></script>
	<script src="web-part/easy/js/base.js"></script>
	<script src="web-part/easy/js/jquery.time.js"></script>
	<script src="web-part/page/pagination.js"></script>
	<script type="text/javascript">
		//数据模板
		function output(){
			location.href="mycrm/Custom/outPut";
		}	
	</script>
</body>
</html>