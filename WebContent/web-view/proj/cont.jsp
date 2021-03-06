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
			<div class="col-sm-12  text-right">
				性别:<input type="text" id="sex" class="input-sm border-a" />&nbsp;
				系别:<input type="text" id="dept" class="input-sm border-a" />&nbsp;
				<button class="btn btn-sm btn-default" onclick="read(1);">查询</button>
				&nbsp;&nbsp;
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>生日</th>
							<th>系别</th>
							<th>地址</th>
						</tr>
					</thead>
					<tbody id="tb-stu">
						<tr>
							<td field="id"></td>
							<td field="name"></td>
							<td field="sex"></td>
							<td field="birth" formatter="fmtTm"></td>
							<td field="department"></td>
							<td field="address"></td>
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
		var tpl = $("#tb-stu").html();
		$("#tb-stu").empty();

		//查询
		function read(curr) {			
			$.post("hwua/Student/listStudent", {
				sex : $("#sex").val(),
				dept : $("#dept").val(),
				curr : curr,
				limit : "3"
			}, function(data) {				
				var res = $.parseJSON(data);
				$("#tb-stu").empty();
				$.each(res.list, function(i, n) {
					$("#tb-stu").append($.render(tpl, n));
					//$("#tb-stu").append($.render(tpl,n));
				});
				setpager(curr, res.pagecount);
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