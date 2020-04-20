<%@page import="java.util.List"%>
<%@page import="com.entity.Product"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.zhuoxun365/lzx/shop/simple/tagdemo/q" prefix="q" %>
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
				<form action="${path }/mng/pro/search">
				<div class="col-md-4">
					<div class="input-group">
						<div
							class="input-control search-box search-box-circle has-icon-left has-icon-right search-example"
							id="searchboxExample">
						
							<input id="inputSearchExample3" type="search"
								class="form-control search-input" placeholder="搜索" name="search"> <label
								for="inputSearchExample3"
								class="input-control-icon-left search-icon"><i
								class="icon icon-search"></i></label>
						</div>
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit">搜索</button>
						</span>
					</div>
				</div>
				</form>
				<!-- 麵包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">编辑</a></li>
						<li class="active">商品管理</li>
					</ol>
				</div>
			</div>
		
			<%-- <q:page totalElements="${productlist.totalcount }" url="${path }/mng/pro/list" size="${productlist.size }" number="${productlist.number }"></q:page> --%>
			<table class="table table-striped table-bordered active=success">
				<tr>
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品分类编号</td>
					<td>主配图片</td>
					<td>库存</td>
					<td>销售量</td>
					<td>价格</td>
					<td>售价</td>
					<td>详情富文本</td>
					<td>卖点富文本</td>
					<td>添加时间</td>
					<td>开售时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${search_pro }" var="productlist">
					<tr>
						<td>${productlist.id }</td>
						<td>${productlist.name }</td>
						<td>${productlist.ca_id }</td>
						<td>${productlist.thumbnail }</td>
						<td>${productlist.inventory }</td>
						<td>${productlist.sales_volume }</td>
						<td>${productlist.price }</td>
						<td>${productlist.sale_price }</td>
						<td>${productlist.detail_description }</td>
						<td>${productlist.selling_description }</td>
						<td>${productlist.create_time }</td>
						<td>${productlist.sale_time }</td>
						<td><a href="${path}/mng/pro/edit?id=${productlist.id }"><i
								class="icon icon-cog"></i></a>&nbsp&nbsp&nbsp&nbsp<a
							href="${path}/mng/pro/delete?id=${productlist.id }"><i
								class="icon icon-trash"></i></a>&nbsp&nbsp&nbsp&nbsp<a
							href="${path}/mng/shopcar/add?id=${productlist.id }"><i
								class="icon icon-shopping-cart"></i></a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>