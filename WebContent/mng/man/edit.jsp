<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.entity.Manager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员编辑功能</title>
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
				<!-- 搜索框 -->
				<div class="col-md-4"></div>
				<!-- 麵包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">管理员编辑</a></li>
					</ol>
				</div>
				<h3>编辑菜单</h3>
				<form class="form-horizontal col-md-8"
					action="${path}/mng/man/update?id=${manageredit.id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">管理员id</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="id"
								value="${manageredit.id }" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="lname"
								value="${manageredit.lname }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="pwd"
								value="${manageredit.pwd }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">真实姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="real_name"
								value="${manageredit.real_name }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">盐值</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="salt"
								value="${manageredit.salt }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="email"
								value="${manageredit.email }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">入职时间</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="joined_date"
								onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								value="${manageredit.joined_date }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">状态</label>

						<div>
							<label> <input type="radio" name="status${manageredit.id }" value="1"
								<c:if test="${manageredit.status==1 }" var="bool">
						
						checked="checked"  
						</c:if>>
								在职
							</label> <label> <input type="radio" name="status${manageredit.id }" value="0"
								<c:if test="${!bool }">checked="checked"</c:if>>
								离职
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">头像</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" name="avatar"
								value="${img_path }/${manageredit.avatar }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">联系方式</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="tel"
								value="${manageredit.tel }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">备注</label>
						<div class="col-sm-10">
							<textarea rows="10" cols="30" name="memo"
								style="width: 700px; height: 200px; visibility: hidden;"
								value="${manageredit.memo }"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">创建时间</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="create_time"
								value="${manageredit.create_time }">
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">确定</button>
						</div>
					</div>
				</form>
				<div style="height: 1000px; width: 100px"></div>
			</div>

		</div>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>

</body>
</html>