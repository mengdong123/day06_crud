<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.entity.Manager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
<!-- 引入zui -->
<jsp:include page="../../icd_css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">
		<jsp:include page="../../icd_body.jsp"></jsp:include>
		<div class="col-md-10">
			<div class="row">
				<!-- 面包屑-->
				<div class="col-md-4"></div>
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li class="active">个人信息</li>
					</ol>
				</div>
			</div>

			<form class="form-horizontal col-md-8" enctype="mulipart/form-data">
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户id</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" value="${person_info.id }"
							disabled="disabled">
					</div>
				</div>

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.lname }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">盐值</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.salt }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.email }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">入职时间</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.joined_date }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">状态</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.status }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">头像</label>
					<div class="col-sm-5">
					
					<c:if test="${person_info.avatar!=null }" var="bool">
					
						<img data-toggle="lightbox" src="${path }/image/${person_info.avatar }"
							data-image="${path }/image/${person_info.avatar }" data-caption="小图看大图"
							class="img-thumbnail" alt="" width="100" height="60">
							</c:if>
						<c:if test="${!bool }">
						
						<a disabled href="#" class="btn  disabled"><b>你未设置头像</b></a>
						
						</c:if>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">创建时间</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.create_time }" disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">联系电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
							value="${person_info.tel }" disabled="disabled">
					</div>
				</div>
			</form>

		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>