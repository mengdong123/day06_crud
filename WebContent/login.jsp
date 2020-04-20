<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 引入zui -->
<jsp:include page="/icd_css.jsp"></jsp:include>
<title>登陆界面</title>
</head>
<body>
	<!-- 导航头开始部分 -->

	<!-- 导航头部 -->
	<nav class="navbar navbar navbar-inverse" role="navigation">

		<!-- 导航头部 -->
		<div class="navbar-header">

			<!-- 品牌名称或logo -->
			<a class="navbar-brand" href="#">微商场管理系统</a>
		</div>
		<!-- 导航项目 -->

		<!-- END .navbar-collapse -->
		</div>
	</nav>
	<!-- 导航头结束 -->
	<!-- 表单 -->
	<div style="margin-left: 30%; margin-top: 10%">
		<form class="form-horizontal" method="post" action="${path}/login"
			id="defaultForm1">
			<div class="form-group" style="">
				<label for="exampleInputAccount4" class="col-sm-2">账号</label>
				<div class="col-md-3 col-sm-10">
					<input type="text" class="form-control" id="exampleInputAccount4"
						name="lname" placeholder="电子邮件/手机号/用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword4" class="col-sm-2">密码</label>
				<div class="col-md-3 col-sm-10">
					<input type="password" class="form-control"
						id="exampleInputPassword4" name="pwd" placeholder="密码">
				</div>
			</div>
			<!-- 验证码 -->
			<div class="form-group">
				<label for="exampleInputPassword4" class="col-sm-2">验证码</label>
				<div class="col-md-2 col-sm-10">
					<input type="text" class="form-control" id="exampleInputPassword4"
						name="cc" placeholder="请输入验证码">
				</div>
				<img src="${path}/ValidCodeServlet" id="img_vc">
			</div>
			<!-- 验证码结束 -->
			<!-- 输入提示 -->
			<div style="margin-left: 25%">
				<p style="color: red; font-size: 15px;">${msg }</p>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#myModal">注册</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					<button type="submit" class="btn btn-success">登录</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 引入js -->
	<jsp:include page="/icd_foot.jsp"></jsp:include>
	<jsp:include page="/icd_js.jsp"></jsp:include>
	<!-- 表单验证 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#defaultForm1').bootstrapValidator({
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

				}
			});
		});
	</script>

	<!-- 模态框开始 -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">
						<span class="label label-info">注册</span>
					</h4>
				</div>
				<div class="modal-body" style="margin-left: 50px">

					<form class="form-horizontal col-md-11"
						action="${path}/mng/man/add?sign=regist" method="post"
						enctype="multipart/form-data" id="defaultForm">

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="lname"
									placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="pwd"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">真实姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="real_name"
									placeholder="请输入真实姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">盐值</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="salt"
									placeholder="请输入盐值">
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
									onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									placeholder="请输入入职时间">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="status"
									placeholder="请输入状态">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">头像</label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="avatar"
									placeholder="请设置头像">
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
							<label for="inputPassword3" class="col-sm-2 control-label">创建时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="create_time"
									onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
							</div>
						</div>
						<div class="form-group" align="center">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success">注册</button>
							</div>
						</div>
					</form>
				</div>


				<div class="modal-footer">

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
					<!-- 加入时间戳更新验证码刷新地址==开始 -->
					<script type="text/javascript">
						$("#img_vc")
								.click(
										function() {
											var src = $(this).attr("src");
											if (src.indexOf("?") != -1) {
												src = src.substring(0, src
														.indexOf("?"));
											}
											$(this).attr(
													"src",
													src
															+ "?d="
															+ new Date()
																	.getTime());

										});
					</script>
					<!-- 加入时间戳更新验证码刷新地址==结束 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>