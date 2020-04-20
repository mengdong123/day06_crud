<%@page import="java.util.List"%>
<%@page import="com.entity.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.zhuoxun365/lzx/shop/simple/tagdemo/q" prefix="q" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 引入zui -->
<jsp:include page="../../icd_css.jsp"></jsp:include>

<title>菜单列表功能</title>
</head>
<body>
	<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">
		<jsp:include page="../../icd_body.jsp"></jsp:include>
		<div class="col-md-10">
			<div class="row">
				<!-- 搜索框 -->
				<form action="${path }/mng/news/search">
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
						<li><a href="your/url/">今日头条</a></li>
						<li class="active">消息管理</li>
					</ol>
				</div>
			</div>
			
			<table class="table table-striped table-bordered active=success">
				<tr>
					<td>新闻编号</td>
					<td>新闻标题</td>
					<td>主配图片</td>
					<td>新闻内容</td>
					<td>点击量</td>
					<td>是否轮播图</td>
					<td>发布时间</td>
					<td>設置</td>
				</tr>


				<c:forEach items="${searchnews }" var="news">
					<tr>
						<td>${news.id }</td>
						<td>${news.title }</td>
						<td>${news.thumbnail }</td>
						<td>${news.content }</td>
						<td>${news.hits }</td>
						<td>${news.top }</td>
						<td>
						${news.pub_time }
						
						
						</td>
						<td><a href="${path}/mng/news/edit?id=${news.id }"><i
								class="icon icon-cog"></i></a>&nbsp&nbsp&nbsp&nbsp<a
							href="${path}/mng/news/delete?id=${news.id }"><i
								class="icon icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="${path}/mng/news/add.jsp"><i
							class="icon icon-plus"></i></a></td>
				</tr>
			</table>
			
		</div>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>