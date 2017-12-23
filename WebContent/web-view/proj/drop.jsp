<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<body class="bg-c">
	<div class="container-fluid">
		<div class="row" style="margin-top: 25px">
			<div class="col-sm-12">
				省&nbsp;<select id="prov" class="input-sm" onchange="showCity(this.value);"></select>
				市&nbsp;<select id="city" class="input-sm" onchange="showCounty(this.value);"></select>
				县&nbsp;<select id="county" class="input-sm" onchange="showDist(this.value);"></select>
				区&nbsp;<select id="dist" class="input-sm"></select>
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
		//获取省
		$.post("hwua/China/listProv",{},function(data){
			var res=$.parseJSON(data);
			$.each(res,function(i,n){
				var row="<option value='"+n.id+"'>"+n.name+"</option>";
				$("#prov").append(row);
			});
			$("#county").empty();
			$("#dist").empty();
		});
		
		//获取市
		function showCity(id){			
			$.post("hwua/China/listCity",{id:id},function(data){
				var res=$.parseJSON(data);
				$("#city").empty();
				$.each(res,function(i,n){
					var row="<option value='"+n.id+"'>"+n.name+"</option>";
					$("#city").append(row);
				});
				$("#dist").empty();
			});
			
		}
		
		//获取县
		function showCounty(id){
			$.post("hwua/China/listCounty",{id:id},function(data){
				var res=$.parseJSON(data);
				$("#county").empty();
				$.each(res,function(i,n){
					var row="<option value='"+n.id+"'>"+n.name+"</option>";
					$("#county").append(row);
				});				
			});	
		}
		
		//获取区
		function showDist(id){
			$.post("hwua/China/listDist",{id:id},function(data){
				var res=$.parseJSON(data);
				$("#dist").empty();
				$.each(res,function(i,n){
					var row="<option value='"+n.id+"'>"+n.name+"</option>";
					$("#dist").append(row);
				});
			});	
		}
		
	</script>
</body>
</html>
</html>