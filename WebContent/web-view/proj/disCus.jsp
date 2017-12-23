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
				<h2>分配客户</h2>
				<div>&nbsp;</div>
				客户编号:&nbsp;<input type="text" id="cid" name="cid"
					class="input-sm "  onblur="getStatu();"/>					
				<div>&nbsp;</div>
				客户状态:&nbsp;<input id="statu" class="input-sm"	 name="statu" type="text"/>
				<div>&nbsp;</div>
				接手职业:&nbsp;<select id="job"  class="input-sm" name="job" onchange="showMan();"></select>				
				<div>&nbsp;</div>
				接手人:&nbsp;<select id="emp"  name="emp" class="input-sm" ></select>					
				<div>&nbsp;</div>				
				<button class="btn btn-sm btn-success" onclick="addjob();">分配客户</button>				
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
		//获取接手职业
		getJob();
		
		function getJob(){
			$.post("mycrm/Jobinfo/listDispaterJob", {}, function(data) {			
				var res = $.parseJSON(data);
				$.each(res, function(i, n) {				
					var row = "<option value='"+n.id+"'>" + n.job + "</option>";
					$("#job").append(row);
				});
			});
		}
		function showMan(){
			$.post("mycrm/Employee/listEmpByJobid",{
				id:$("#job").val()
			},function(data){				
				var res = $.parseJSON(data);
				$("#emp").empty();
				$.each(res, function(i, n) {				
					var row = "<option value='"+n.id+"'>" + n.realname + "</option>";
					$("#emp").append(row);
				});
			});
		}
		
		//获取客户状态
		function getStatu(){			
			$.post("mycrm/Custom/selectById",{
				id:$("#cid").val()
			},function(data){				
				var res=$.parseJSON(data);
				$("#statu").val(res.customstatu);
			});
		}
		
		//分配客户							
		function addjob(){
			var jobid=$("#job").val();
			if(jobid==3){
				consult();
			}
			if(jobid==8||jobid==5){
				custominfo();
			}
								
		}
		//分配客户到咨询记录表		
		function consult() {			
			$.post("mycrm/Consultrecord/addCRecord",{
				cid:$("#cid").val(),
				statu:$("#statu").val(),
				eid:$("#emp").val()
			},function(data){
				if(data=="fail"){
					layer.msg("客户分配失败");
					return;
				}
				layer.msg("客户分配成功");
			});
		}
		
		//分配客户到销售记录表		
		function custominfo() {
			$.post("mycrm/Custominfo/addSell",{
				cid:$("#cid").val(),
				statu:$("#statu").val(),
				eid:$("#emp").val()
			},function(data){
				if(data=="fail"){
					layer.msg("客户分配失败");
					return;
				}
				layer.msg("客户分配成功");
			});
		}
	</script>
</body>
</html>
