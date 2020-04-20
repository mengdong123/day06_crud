<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<div>
					<a id="loadingBtnExample" type="button" data-loading-text="正在备份..."
						href="${path}/mng/program?state=backup" class="btn btn-primary">点击备份数据库</a>
				</div>
				<br>
				<div>
					<a id="loadingBtnExample1" type="button"
						data-loading-text="正在还原..."
						href="${path}/mng/program?state=restore" class="btn btn-primary">点击还原数据库</a>
				</div>
			</div>
		</div>

	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
	<script type="text/javascript">
		$('#loadingBtnExample').on('click', function() {
			var $btn = $(this);
			$btn.button('loading');

			// 此处使用 setTimeout 来模拟复杂功能逻辑
			setTimeout(function() {
				$btn.button('reset');
			}, 2000);
		});
		$('#loadingBtnExample1').on('click', function() {
			var $btn = $(this);
			$btn.button('loading');

			// 此处使用 setTimeout 来模拟复杂功能逻辑
			setTimeout(function() {
				$btn.button('reset');
			}, 2000);
		});
	</script>
</body>
</html>