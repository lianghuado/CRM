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
				<h3>部门主管查看员工的客户开发信息</h3>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>序号</th>
							<th>记录编号</th>
							<th>客户姓名</th>
							<th>跟单人编号</th>
							<th>跟单人姓名</th>
							<th>跟单状态</th>
							<th>开始日期</th>
							<th>最近联系</th>
							<th>计划联系日期</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody id="tb-cus">
						<tr>
							<td field="id"></td>
							<td field="customId"></td>
							<td field="name"></td>
							<td field="followManId"></td>
							<td field="realname"></td>
							<td field="statu"></td>
							<td field="startDate" formatter="fmtTm"></td>
							<td field="lastFollowDate" formatter="fmtTm"></td>
							<td field="planDate" formatter="fmtTm"></td>
							<td field="mark"></td>							
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
		var tpl = $("#tb-cus").html();
		$("#tb-cus").empty();
		read(1);

		//查询
		function read(curr) {
			$.post("mycrm/Custominfo/listDeveByDid", {				
				curr : curr,
				limit : "10"
			}, function(data) {
				var res = $.parseJSON(data);
				$("#tb-cus").empty();
				$.each(res.list, function(i, n) {
					$("#tb-cus").append($.render(tpl, n));
				});
				setpager(curr, res.pagecount);
			});
		}

		//处理日期格式
		function fmtTm(val) {
			if (val == null) {
				return "无";
			}
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
		//处理日期时间格式
		var fmtDate=function (date) {
			var da = new Date(date);
			var y = da.getFullYear();
			var m = da.getMonth() + 1;
			m = m < 10 ? '0' + m : m;
			var d = da.getDate();
			d = d < 10 ? ('0' + d) : d;
			return y + '-' + m + '-' + d;
		};
	</script>
</body>
</html>