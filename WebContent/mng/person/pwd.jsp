<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.entity.Manager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
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
						<li><a href="#">用户管理</a></li>
						<li><a href="#">个人信息</a></li>
						<li class="active">修改密码</li>
					</ol>
				</div>
			</div>
			<form class="form-horizontal col-md-8"
				action="${path}/mng/person/pwd" method="post" id="defaultForm">
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-5">

						<input type="text" class="form-control" value="${curr_mrg.lname }"
							disabled="disabled">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">旧密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="old_pwd">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="new_pwd">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="again_pwd">
					</div>
				</div>
				<p style="font-size: 15px; color: red;">${mes }</p>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">确认修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
	<!-- 表单验证 -->
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#defaultForm').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	           
	        	old_pwd: {
	                validators: {
	                    notEmpty: {
	                        message: '旧密码不能为空'
	                    },
	                }
	            },
	        	
	        	
	            new_pwd: {
	                validators: {
	                    notEmpty: {
	                        message: '新密码不能为空'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: '密码长度为6到30位'
	                    },
	                    identical: {
	                        field: 'again_pwd',
	                        message: '两次新密码不一致'
	                    }
	                }
	            },
	            again_pwd: {
	                validators: {
	                    notEmpty: {
	                        message: '新密码不能为空'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: '密码长度为6到30位'
	                    },
	                    identical: {
	                        field: 'new_pwd',
	                        message: '两次新密码不一致'
	                    }
	                }
	            },
	            
	        }
	    });
	});
	
	
	</script>
</body>
</html>