<%@page import="java.util.List"%>
<%@page import="com.entity.Manager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 引入zui -->
<jsp:include page="../../icd_css.jsp"></jsp:include>

<title>管理员列表</title>
</head>
<body>
	<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">

		<jsp:include page="../../icd_body.jsp"></jsp:include>
		<div class="col-md-10">
			<div class="row">
				<!-- 搜索框 -->
				<form action="${path }/mng/man/search">
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
						<li><a href="your/url/">管理员编辑</a></li>
						<li class="active">管理员管理</li>
					</ol>
				</div>
			</div>
			
			<table class="table table-striped table-bordered active=success">
				<tr>
					<td>管理员编号</td>
					<td>登录名</td>
					<td>密码</td>
					<td>真实姓名</td>
					<td>密码盐值</td>
					<td>加入时间</td>
					<td>邮箱</td>
					<td>员工入职日期</td>
					<td>状态</td>
					<td>头像</td>
					<td>联系方式</td>
					<td>备注</td>
					<td>注册时间</td>
				</tr>


				<c:forEach items="${searchmanager }" var="man">

					<tr>
						<td>${man.id }</td>
						<td>${man.lname }</td>
						<td>${man.pwd }</td>
						<td>${man.real_name }</td>
						<td>${man.salt }</td>
						<td>${man.email }</td>
						<td>${man.joined_date }</td>
						<td>${man.status }</td>
						<td>${man.avatar }</td>
						<td>${man.tel }</td>
						<td>${man.memo }</td>
						<td>${man.create_time }</td>
						<td><a href="${path}/mng/man/edit?id=${man.id}"><i
								class="icon icon-cog"></i></a>&nbsp&nbsp&nbsp&nbsp<a
							href="${path}/mng/man/delete?id=${man.id}"><i
								class="icon icon-trash"></i></a></td>
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