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
				<h4>销售助理查询所有咨询人员</h4>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>编号</th>
							<th>昵称</th>
							<th>真名</th>
							<th>职位</th>
							<th>部门</th>
							<th>移动电话</th>
							<th>办公室电话</th>
						</tr>
					</thead>
					<tbody id="tb-emp">
						<tr>
							<td field="id"></td>
							<td field="nickname"></td>
							<td field="realname"></td>
							<td field="job"></td>
							<td field="dname"></td>
							<td field="phoneNo"></td>
							<td field="officeTel"></td>
						</tr>
					</tbody>
				</table>
				<div id="mypager" class="text-center"></div>
			</div>
		</div>

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
		var tpl = $("#tb-emp").html();
		$("#tb-emp").empty();
		read();
		//查询
		function read() {
			alert("ok");
			$.post("mycrm/Employee/selectConsult", {}, function(data) {				
				var res = $.parseJSON(data);
				$("#tb-emp").empty();
				$.each(res, function(i, n) {
					$("#tb-emp").append($.render(tpl, n));					
				});				
			});
		}

		//处理日期格式
		function fmtTm(val) {
			return $.msfmt.todate(val, false, 8);
		}

		//设置分页
		function setpager(curr, pagecount) {
			$("#mypager").pagination({
				current_page : curr,
				total_pages : pagecount,
				callback : function(e, p) {					
					read(p);
					//showblogs(p);
					//scrollTo(0, 0);
				}
			});
		}
	</script>
</body>
</html>