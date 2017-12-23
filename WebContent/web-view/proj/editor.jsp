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
<body class="bg-c">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 text-center">小肥肥编辑器</div>
		</div>
		<div>&nbsp;</div>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div id="edit" style="height: 250px"></div>
				<div>&nbsp;</div>
				<button class="btn btn-sm btn-sucess" onclick="getCont();">获取文本内容</button>
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
	<script src="web-part/edit/ueditor.config.js"></script>
	<script src="web-part/edit/ueditor.all.min.js"></script>
	<script style="text/javascript">
		var ue = UE.getEditor("edit",{
			toolbars: [
			           ['insertimage', 'fontfamily', 'fontsize', 'emotion', 'link', 'bold',]
			       ]
			       
		});
		
		function getCont(){
			var str=ue.getContent();
			alert(str);
		}
	</script>
</body>
</html>
