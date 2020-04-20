<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加管理员</title>
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
				<!-- 麵包屑 -->
				<div class="col-md-4"></div>
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">编辑</a></li>
						<li class="active">管理员添加</li>
					</ol>
				</div>
			</div>
			<form class="form-horizontal col-md-8"
				action="${path}/mng/man/add?sign=add" method="post" enctype="multipart/form-data" id="defaultForm">

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="lname" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="pwd"placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="real_name" placeholder="请输入真实姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">盐值</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="salt" placeholder="请输入盐值">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email"
							placeholder="请输入邮箱">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">入职时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="joined_date"
						onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入入职时间">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">状态</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="status"placeholder="请输入状态">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">头像</label>
					<div class="col-sm-10">
						<input type="file" class="form-control" name="avatar" placeholder="请设置头像">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">联系方式</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="tel"
							placeholder="请输入联系方式">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">备注</label>
					<div class="col-sm-10">
						<textarea rows="10" cols="30" name="memo"
							style="width: 700px; height: 200px; visibility: hidden;"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">创建时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="create_time">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">添加</button>
					</div>
				</div>
			</form>
				<div  style="height: 900px;width: 100px"></div>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
	<!-- 模态框验证 -->
					<script type="text/javascript">
						$(document).ready(function() {
							$('#defaultForm').bootstrapValidator({
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									lname : {
										validators : {
											notEmpty : {
												message : '用户名不能为空'
											},
										}
									},

									pwd : {
										validators : {
											notEmpty : {
												message : '密码不能为空'
											},
										}
									},
									salt : {
										validators : {
											notEmpty : {
												message : '请输入员工状态'
											},
										}
									},

									email : {
										validators : {
											notEmpty : {
												message : '邮箱不能为空'
											},
											emailAddress : {
												message : '邮箱格式不正确'
											}
										}
									},

								}
							});
						});
					</script>
					
</body>
</html>