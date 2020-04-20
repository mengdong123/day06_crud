<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<form action="${path }/mng/shopcar/search">
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
						<li><a href="your/url/">购物车</a></li>
						<li class="active">购物车列表</li>
					</ol>
				</div>
			</div>

		<c:if test="${shoplist!=null }" var="boolshop">
			<table class="table table-striped table-bordered active=success">
				<tr>
					<td>商品id</td>
					<td>商品名称</td>
					<td>商品单价</td>
					<td>件数</td>
					<td>单品总价</td>
					<td>用户操作</td>
				</tr>
				<c:forEach items="${shoplist }" var="shoplist">
					<tr>
						<td>${shoplist.key.id }</td>
						<td>${shoplist.key.name }</td>
						<td>${shoplist.key.sale_price }</td>
						<td><a
							href="${path }/mng/shopcar/valueadd?id=${shoplist.key.id }"><i
								class="icon icon-plus"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;${shoplist.value }&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="${path }/mng/shopcar/valueminu?id=${shoplist.key.id }"><i
								class="icon icon-minus"></i></a></td>
						<td><c:set value="${shaoplist.key.sale_price*shoplist.value }"
								var="cc">
							</c:set> <c:out value="${cc }"></c:out></td>
				</c:forEach>

				<td><a href="${path}/newsdeleteservlet?id=${shoplist.key.id }"><i
						class="icon icon-trash"></i></a></td>
				</tr>


				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>总计：<c:out value="${cc+=cc }"></c:out></td>
					<td><a href=""><i class="icon icon-zhifubao-square"></i>&nbsp点此付款</a></td>
				</tr>
			</table>

		</c:if>

		<c:if test="${!boolshop }">
			<div class="col-md-10"
				style="text-align: center; line-height: 500px; font-size: 20px">

				<a href="${path}/mng/pro/list?number=1&size=2">购物车空空如也，点此返回商场</a>

			</div>
		</c:if>
</div>
	</div>
	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>