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
				<h2>增加职位</h2>
				<div>&nbsp;</div>
				职位:&nbsp;<input type="text" id="job"
					class="input-sm border-a input-success" />
				<div>&nbsp;</div>
				部门:&nbsp;<select id="dept" class="input-sm"	 name="dept"></select>
				<div>&nbsp;</div>
				一级权限:&nbsp;<select id="right" name="right" onchange="showR2();"></select>
				<div>&nbsp;</div>
				二级权限:&nbsp;<select id="right2" multiple="multiple" name="right2"></select>
				<div>&nbsp;</div>
				<button class="btn btn-sm btn-default" onclick="addjob();">增添职位</button>				
			</div>

		</div>
	</div>
	<!-- js -->

	<script src="web-part/page/pagination.js"></script>
	<script src="web-part/layer/layer.js"></script>
	<script src="web-part/easy/js/base.js"></script>
	<script src="web-part/easy/js/jquery.time.js"></script>


	<script>
		//获取部门
		$.post("mycrm/Department/listDept", {}, function(data) {
			var res = $.parseJSON(data);
			$.each(res, function(i, n) {
				var row = "<option value='"+n.id+"'>" + n.dname + "</option>";
				$("#dept").append(row);
			});
		});

		//获取一级去权限信息		
			$.post("mycrm/Rights/listRight", {}, function(data) {			
				var res = $.parseJSON(data);			
				$.each(res, function(i, n) {
					 var row = "<option value='"+n.rid+"'>" + n.rightname
							+ "</option>";
					$("#right").append(row);
				});			
			});
				
		//获取二级去权限信息
		function showR2(){
			$("#right2").empty();
			$.post("mycrm/Rights/listTwoRights", {
				rid:$("#right").val()
			}, function(data) {
				alert(data);
				var res = $.parseJSON(data);
				$("#right2").empty();
				$.each(res, function(i, n) {
					 var row = "<option value='"+n.rid+"'>" + n.rightname
							+ "</option>";
					$("#right2").append(row);
				});
				//调用多选
				$("#right2").multiselect();
			});
		}
		
		
		function addjob(){			
			$.post("mycrm/Jobinfo/addjob",{
				rights:$("#right").val().toString(),
				dept:$("#dept").val(),
				job:$("#job").val(),
				right2s:$("#right2").val().toString()
			},function(data){
				if("success"!=data){
					layer.msg("fail");
					return;
				}
				layer.msg("success");				
			});						
		}
		
		

		function showDept(value) {
			alert(value);
		}
	</script>
</body>
</html>
