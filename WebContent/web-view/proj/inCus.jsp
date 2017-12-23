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
			<div class="col-sm-12 text-center">
				<h3>销售助理导入xls中的数据到数据库</h3>	
				<div>&nbsp;</div>			
				<button type="button" class="btn btn-sm btn-success" onclick="uploadClick()">上传</button>
				<input type="file" name="myFile" id="myFile" style="display:none"/>				
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
	<script src="web-part/easy/js/jquery.upload.js"></script>
	<script>
		$("#myFile").ajaxfileupload({
			action:"mycrm/Custom/inCus",
			valid_extensions:["jsp","jpeg","png","txt","xls"],
			params:{},
			onComplete:function(data){
				layer.msg(data);				
			},
			onCancel :function(){
				
			}
		});
		
		function uploadClick(){
			$("#myFile").click();
		}
	</script>
</body>
</html>
