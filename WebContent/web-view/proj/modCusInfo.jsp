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
		<div class="row" >
			<div class="col-sm-12  text-center">
				<h3>修改客户信息</h3>
			</div>			
		</div>
		<div class="row">
			<div class="col-sm-12  text-right">
				姓名:<input type="text" id="name" class="input-sm border-a" />&nbsp;
				介绍人:<input type="text" id="invitename" class="input-sm border-a" />&nbsp;
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
							<th>学历</th>
							<th>电话</th>
							<th>qq</th>
							<th>邮箱</th>
							<th>customStatu</th>
							<th>开始时间</th>
							<th>介绍人</th>
						</tr>
					</thead>
					<tbody id="tb-cus">
						<tr>
							<td field="id"></td>
							<td field="name"></td>
							<td field="education"></td>
							<td field="phoneno" ></td>
							<td field="qq"></td>
							<td field="email"></td>
							<td field="customstatu"></td>
							<td field="createdate" formatter="fmtTm"></td>
							<td field="invitename"></td>
							<td><button idfield="id" onclick="modifyById(this)" class="btn btn-sm btn-default">修改客户信息</button></td>
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

		//查询
		function read(curr) {			
			$.post("mycrm/Custom/listCustom", {
				name : $("#name").val(),
				invitename : $("#invitename").val(),
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
		
		function modifyById(obj){			
			var id=$(obj).attr("rowid");
			$.post("mycrm/Custom/selectById",{id:id},function(data){
				var cus=$.parseJSON(data);
				openPage(cus);				
			});			 	          		
		}
		
		function openPage(cus){
			layer.open({
	            title: false,
	            type: 2,
	            closeBtn: true,
	            anim: 4,
	            offset: '20px',
	            area: ['420px', '540px'],
	            skin: 'layui-layer-molv', //加上边框
	            content: ['demo/change', 'no'],
	            success: function (layero, index) {
	            	var body = layer.getChildFrame('body', index);//巧妙的地方在这里哦
	                body.contents().find("#id").val(cus.id);
	                body.contents().find("#name").val(cus.name);
	                body.contents().find("#edu").val(cus.education);
	                body.contents().find("#ph").val(cus.phoneno);
	                body.contents().find("#qq").val(cus.qq);
	                body.contents().find("#email").val(cus.email);
	                body.contents().find("#cus").val(cus.customstatu);

	            }
	        });
		}
		 	
	</script>
</body>
</html>