<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 引入zui -->
<jsp:include page="../../icd_css.jsp"></jsp:include>

<title>商品列表</title>
</head>
<body>
	<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">

		<jsp:include page="../../icd_body.jsp"></jsp:include>
		<div class="col-md-10">
			<div class="row">
				<!-- 搜索框 -->
				<div class="col-md-4"></div>
				<!-- 麵包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">购物车</a></li>
						<li class="active">购物车列表</li>
					</ol>
				</div>
			</div>
		</div>
		<div class="col-md-10"style="text-align: center;line-height:500px;font-size: 20px">

			<a href="${path}/mng/shop/list" >添加购物车成功，查看购物车</a>
		</div>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>