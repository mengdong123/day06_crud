<%@page language="java" pageEncoding="utf-8"%>
<%@page import="com.entity.Manager"%>
<!-- 导航头开始部分 -->

<!-- 导航头部 -->
<nav class="navbar navbar navbar-inverse" role="navigation">

	<!-- 导航头部 -->
	<div class="navbar-header">

		<!-- 品牌名称或logo -->
		<a class="navbar-brand" href="${path}/mng/home/home.jsp">微商场管理系统&nbsp;&nbsp;<i
			class="icon icon-user"></i>${count }</a>
	</div>
	<!-- 导航项目 -->
	<div class="collapse navbar-collapse navbar-collapse-example">

		<!-- 右侧的导航项目 -->
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="your/nice/url"
				class="dropdown-toggle" data-toggle="dropdown">${curr_mrg.lname}<b
					class="caret"></b></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="${path}/person/info"><i class="icon icon-user"></i>&nbsp;&nbsp;个人中心</a></li>
					<li><a href="${path}/mng/person/pwd.jsp"><i class="icon icon-key"></i>&nbsp;&nbsp;修改密码</a></li>
					<li class="divider"></li>
					<li><a href="${path}/mng/exit">退出</a></li>
				</ul> <!-- END .navbar-collapse --> <!-- 右侧单行项目结束 -->
	</div>
	<!-- END .navbar-collapse -->
	</div>
</nav>
<!-- 导航头结束 -->