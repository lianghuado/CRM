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
<link rel="stylesheet" href="web-part/side/sidebar-menu.css" />
</head>
<body class="bg-a">
	<div class="container-fluid">
		<!-- 标题 -->
		<div class="row">
			<div class="col-sm-12 text-center">
				<h4>
					<i class="fa fa-sticky-note-o"></i> EASYWORK
				</h4>
			</div>
		</div>
		<!-- 边栏按钮 -->
		<div class="row">
			<div class="col-sm-12">
				<a href="javascript:callside();"><i class="fa fa-bars"></i><i
					class="fa fa-cog"></i></a>&nbsp;欢迎访问
			</div>
		</div>
		<!-- 边栏/中央 -->
		<div class="row">
			<!-- 边栏 -->
			<div class="col-sm-2" id="sidebar">
				<ul class="sidebar-menu">
					<li><a href="javascript:"><i class="fa fa-clone"></i>菜单项-1</a>
						<ul class="sidebar-submenu">
							<li><a href="javascript:" view="start"
								onclick="opentab(this,true);"><i class="fa fa-square-o"></i>快速开始</a></li>
						</ul></li>
					<li><a href="javascript:"><i class="fa fa-clone"></i>菜单项-2</a></li>
					<li><a href="javascript:"><i class="fa fa-clone"></i>菜单项-3</a>
						<ul class="sidebar-submenu">
							<li><a href="javascript:" view="data"
								onclick="opentab(this,true);"><i class="fa fa-square-o"></i>数据分页</a></li>
							<li><a href="javascript:"><i class="fa fa-square-o"></i>文本编辑</a></li>
						</ul></li>
					<li><a href="javascript:"><i class="fa fa-clone"></i>菜单项-4</a></li>
					<li><a href="javascript:"><i class="fa fa-clone"></i>菜单项-5</a>
						<ul class="sidebar-submenu">
							<li><a href="javascript:"><i class="fa fa-square-o"></i>子菜单项-5-1</a></li>
							<li><a href="javascript:"><i class="fa fa-square-o"></i>子菜单项-5-2</a></li>
							<li><a href="javascript:"><i class="fa fa-square-o"></i>子菜单项-5-3</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- 中央 -->
			<div class="col-sm-12" id="main">
				<ul class="nav nav-tabs"></ul>
				<div class="tab-content"></div>
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="web-part/easy/js/jquery.js"></script>
	<script src="web-part/boot/bootstrap.min.js"></script>
	<script src="web-part/side/sidebar-menu.js"></script>
	<script src="web-part/tabs/bootstrap-closable-tab.js"></script>
	<script src="web-part/layer/layer.js"></script>
	<script>
		//边栏初始化/隐藏
		$.sidebarMenu($(".sidebar-menu"));
		$("#sidebar").hide();

		//边栏呼出/折叠
		function callside() {
			$("#sidebar").slideToggle(250);
			setmain();
		}

		//设置中央宽度
		function setmain() {
			if ($("#main").hasClass("col-sm-12")) {
				$("#main").removeClass("col-sm-12").addClass("col-sm-10");
			} else {
				$("#main").removeClass("col-sm-10").addClass("col-sm-12");
			}
		}

		//打开标签页
		function opentab(obj, flag) {
			var item = {
				closable : flag,
				id : $(obj).attr("view"),
				name : $(obj).text(),
				url : "demo/tabOrPop/" + $(obj).attr("view")
			};
			closableTab.addTab(item);
		}

		//默认标签页
		opentab($("#sidebar a[view='start']")[0], false);
	</script>
</body>
</html>
