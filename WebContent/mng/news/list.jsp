<%@page import="java.util.List"%>
<%@page import="com.entity.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.zhuoxun365/lzx/shop/simple/tagdemo/q"
	prefix="q"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
									class="form-control search-input" placeholder="搜索"
									name="search"> <label for="inputSearchExample3"
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
					<td align="center" width="80px">新闻编号</td>
					<td align="center" width="140px">新闻标题</td>
					<td align="center" width="100px">主配图片</td>
					<td align="center" width="500px">新闻内容</td>
					<td align="center" width="80px">点击量</td>
					<td align="center" width="80px">是否轮播图</td>
					<td align="center" width="160px">发布时间</td>
					<td align="center" width="80px">設置</td>
				</tr>
				<c:forEach items="${news.items }" var="news">
					<tr>
						<td align="center">${news.id }</td>
						<td align="center" width="140px">${news.title }</td>
						<td align="center" width="100px"><c:if
								test="${news.thumbnail!=null }" var="bool">


								<img data-toggle="lightbox"
									src="${path }/image/${news.thumbnail }"
									data-image="${path }/image/${news.thumbnail }"
									data-caption="小图看大图" class="img-thumbnail" alt="" width="100"
									height="60">

							</c:if> <c:if test="${!bool }">

								<a disabled href="#" class="btn  disabled"><b>请上传图片</b></a>

							</c:if></td>
						<td width="500px">${news.content }</td>
						<td align="center" width="80px">${news.hits }</td>
						<td align="center" width="80px">${news.top }</td>
						<td align="center" width="160px"><fmt:formatDate
								value="${news.pub_time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td align="center" width="80px"><a
							href="${path}/mng/news/edit?id=${news.id }"><i
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
					<td><a class="btn btn-primary" href="${path}/mng/news/add.jsp">添加新闻</a>
				</tr>
			</table>
			<q:page totalElements="${news.totalcount }"
				url="${path }/mng/news/list" size="${news.size }"
				number="${news.number }"></q:page>
		</div>

	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>