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
				<form id="fm-login" action="mycrm/Employee/addEmp" method="post"
					class="panel panel-default">
					<div class="panel-heading">
						<h4>添加普通用户</h4>
					</div>
					<div class="panel-body">
						<div>用户名</div>
						<div>
							<input type="text" name="username" class="input-sm form-control" />
						</div>
						<div>密码</div>
						<div>
							<input type="password" name="pass" class="input-sm form-control" />
						</div>
						<div>昵称</div>
						<div>
							<input type="text" name="nickname" class="input-sm form-control" />
						</div>
						<div>真名</div>
						<div>
							<input type="text" name="realname" class="input-sm form-control" />
						</div>
						<div>移动电话</div>
						<div>
							<input type="text" name="phoneno" class="input-sm form-control" />
						</div>
						<div>办公室电话</div>
						<div>
							<input type="text" name="officetel" class="input-sm form-control" />
						</div>
						<div>职位</div>
						<div>
							<select id="job" class="input-sm" name="jobid"></select>
						</div>
						<div>部门</div>
						<div>
							<select id="dept" class="input-sm" name="deptid"></select>
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
		//获取工作岗位信息
		getJob();
		//获取部门信息
		getDept();
		//工作
		function getJob() {
			$.post("mycrm/Jobinfo/listJob", {}, function(data) {
				var res = $.parseJSON(data);
				$("#job").empty();
				$.each(res,function(i, n) {
							if(n.id != 1 && n.id != 2){
								var row = "<option value='"+n.id+"'>" + n.job
								+ "</option>";
								$("#job").append(row);
							}							
						});
			});
		}
		//部门
		function getDept() {
			$.post("mycrm/Department/listDept", {}, function(data) {
				var res = $.parseJSON(data);
				$("#dept").empty();
				$.each(res,function(i, n) {
							var row = "<option value='"+n.id+"'>" + n.dname
									+ "</option>";
							$("#dept").append(row);
						});
			});
		}
		
		
		//转换为ajax表单
		$("#fm-login").ajaxForm(function(data) {
			if (data != "success") {
				layer.alert("添加失败");
				return;
			}
			layer.alert("添加成功");
		});
	</script>
</body>
</html>
