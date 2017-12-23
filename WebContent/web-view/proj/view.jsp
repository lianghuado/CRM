<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>哈哈</title>
<!-- css -->
<link rel="stylesheet" href="web-part/boot/bootstrap.min.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
<link rel="stylesheet" href="web-part/side/sidebar-menu.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4 text-center text-success lead">
				<h2>过江千尺浪,入竹万竿斜</h2>
			</div>
			<div class="col-sm-4 text-center text-success">
				<span view="login" onclick="opentab(this);">登录</span>
				|<span view="resetPass" onclick="opentab(this);">忘记密码</span>
				|<span>${sessionScope.user.username}</span>
			</div>
		</div>
		<!-- 左侧菜单右侧工作区 -->
		<div class="row">
			<div class="col-sm-2">
				<ul class="sidebar-menu">
					<c:forEach var="m1" items="${list}">
						<c:if test="${m1.rid==m1.pid }">
							<li><a href="javascript:"><i class="fa fa-globe"></i>${m1.rightname}</a>
								<ul class="sidebar-submenu">
									<c:forEach var="m2" items="${list}">
										<c:if test="${m1.pid==m2.pid and m2.pid!=m2.rid}">
											<li><a href="javascript:" onclick="opentab(this);"
												view="${m2.url}">${m2.rightname}</a></li>
										</c:if>
									</c:forEach>
								</ul></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<!-- 工作区 -->
			<div class="col-sm-10">
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
	<script type="text/javascript">
		//初始化右侧菜单
		$.sidebarMenu($(".sidebar-menu"));
		//打开标签页
		function opentab(obj) {
			var opt = {
				closable : true,
				id : $(obj).attr("view"),
				name : $(obj).text(),
				url : "demo/tabOrPop/" + $(obj).attr("view")
			};
			closableTab.addTab(opt);
		}
	</script>
</body>
</html>
