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
<script src="web-part/easy/js/jquery.js"></script>
<script src="web-part/boot/bootstrap.min.js"></script>
<script src="web-part/boot/bootstrap-mulselect.js"></script>
<link rel="stylesheet" href="web-part/boot/bootstrap-multiselect.css" />
</head>
<body class="bg-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 text-center">
				<h3>修改职位权限(增加,修改)</h3>
				<div>&nbsp;</div>				
				职位:&nbsp;<select id="job" class="input-sm"	 name="job" onchange="showRight(this.value);"></select>
				<div>&nbsp;</div>
				职位现有权限:&nbsp;<select id="r1" class="input-sm" ></select>
				<div>&nbsp;</div>
				所有的权限:&nbsp;<select id="right" class="input-sm" name="right"></select>
				<div>&nbsp;</div>
				<button class="btn btn-sm btn-default" onclick="addjob();">增加权限</button>
				<button class="btn btn-sm btn-default" onclick="deljob();">删除权限</button>				
			</div>

		</div>
	</div>
	<!-- js -->

	<script src="web-part/page/pagination.js"></script>
	<script src="web-part/layer/layer.js"></script>
	<script src="web-part/easy/js/base.js"></script>
	<script src="web-part/easy/js/jquery.time.js"></script>


	<script>
		//获取工作
		getJob();
		//获取所有的职位权限
		getAllJobRight();

		
		//获取职位的的权限
		function showRight(){			
			$.post("mycrm/Rights/listJobRight",{
				id:$("#job").val()
			},function(data){
				var res = $.parseJSON(data);
				$("#r1").empty();
				$.each(res, function(i, n) {
					var row = "<option value='"+n.rid+"'>" + n.rightname+ "</option>";
					$("#r1").append(row);
				});
			});
		}
		
	
		
		

		function getJob() {
			$.post("mycrm/Jobinfo/listJob", {}, function(data) {
				var res = $.parseJSON(data);
				$("#job").empty();
				$.each(res, function(i, n) {
					var row = "<option  value='"+n.id+"'>" + n.job + "</option>";
					$("#job").append(row);
				});
			});
		}
		//获取职位的权限信息
		function getJobRight(){
			$.post("mycrm/Rights/listRight", {
				id:$("#job").val()
			}, function(data) {			
				var res = $.parseJSON(data);
				$("#right").empty();
				$.each(res, function(i, n) {
					 var row = "<option value='"+n.rid+"'>" + n.rightname
							+ "</option>";
					$("#right").append(row);
				});
				
			});
		}
		
		//获取所有的职位权限
		function getAllJobRight(){			
			$.post("mycrm/Rights/listRight", {}, function(data) {			
				var res = $.parseJSON(data);			
				$.each(res, function(i, n) {
					 var row = "<option value='"+n.rid+"'>" + n.rightname
							+ "</option>";
					$("#right").append(row);
				});
				
			});
		}
		//删除职位的权限
		function deljob(){
			$.post("mycrm/Jobright/delRight",{
				id:$("#job").val(),
				right:$("#r1").val()
			},function(data){
				layer.msg(data);
			})
		}		
	</script>
</body>
</html>
