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
				<h4>删除权限</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>权限编号</th>
							<th>权限名</th>
							<th>权限类型</th>
							<th>权限路径</th>
							<th>权限父编号</th>																					
						</tr>
					</thead>
					<tbody id="tb-emp">
						<tr>
							<td field="rid"></td>
							<td field="rightname"></td>
							<td field="righttype"></td>					
							<td field="url"></td>
							<td field="pid"></td>
							<td><button idfield="rid" onclick="deleteById(this)" class="btn btn-sm btn-default">删除权限</button></td>	
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
		read(1);
		//查询
		function read(curr) {			
			$.post("mycrm/Rights/listAllRight", {				
				curr : curr,
				limit : "6"
			}, function(data) {				
				var res = $.parseJSON(data);
				$("#tb-emp").empty();
				$.each(res.list, function(i, n) {					
					$("#tb-emp").append($.render(tpl, n));															
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
		//删除权限
		//按照id删除
		function deleteById(obj){
			var id=$(obj).attr("rowid");
			$.post("mycrm/Rights/delRight",{id:id},function(data){
				if(data=="success"){
					layer.alert("删除成功")
					read(1);
				}else{
					layer.alert("删除失败")
					read(1);
				}
			});
		}	
	</script>
</body>
</html>