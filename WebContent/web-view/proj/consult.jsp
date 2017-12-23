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
				<h3>查看及修改所有状态的客户咨询信息</h3>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>序号</th>
							<th>客户编号</th>
							<th>客户姓名</th>
							<th>咨询师编号</th>
							<th>咨询师姓名</th>
							<th>咨询状态</th>
							<th>咨询日期</th>
							<th>咨询备注</th>
							
						</tr>
					</thead>
					<tbody id="tb-cus">
						<tr>
							<td field="id"></td>
							<td field="customId"></td>
							<td field="name"></td>
							<td field="consultManId"></td>
							<td field="realname"></td>
							<td field="consultStatu"></td>
							<td field="consultDate" formatter="fmtTm"></td>						
							<td field="result"></td>
							<td><button idfield="id" onclick="modifyById(this)"
									class="btn btn-sm btn-default">修改咨询信息</button></td>
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
			$.post("mycrm/Consultrecord/listRecord", {				
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
		//按照idxiugai
		function modifyById(obj) {
			alert("ok");
			var id = $(obj).attr("rowid");
			$.post("mycrm/Consultrecord/selectRecordById", {
				id : id
			}, function(data) {
				var cus = $.parseJSON(data);			
				openPage(cus);
			});
		}
		//打开弹框
		function openPage(cus) {
			layer.open({
				title : false,
				type : 2,
				closeBtn : true,
				anim : 4,
				offset : '5px',
				shade : 0.8,
				area : [ '360px', '100%' ],
				skin : 'layui-layer-molv', //加上边框
				content : [ 'demo/modCon', 'no' ],
				success : function(layero, index) {
					var body = layer.getChildFrame('body', index);//巧妙的地方在这里哦
					body.contents().find("#id").val(cus.id);
					body.contents().find("#consultstatu").val(cus.consultstatu);
					body.contents().find("#consultdate").val(fmtDate(cus.consultdate));
					body.contents().find("#result").val(cus.result);

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