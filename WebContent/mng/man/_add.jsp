<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<div class="col-md-10"style="text-align: center;line-height:500px;font-size: 20px">

			<a href="${path}/mng/man/list?number=1&size=2" >管理员添加成功，返回管理员列表</a>
		</div>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>