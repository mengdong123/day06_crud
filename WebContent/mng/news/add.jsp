<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加菜单</title>
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
						<li><a href="your/url/">新闻管理</a></li>
						<li class="active">添加新闻</li>
					</ol>
				</div>
			</div>
			<form class="form-horizontal col-md-8" action="${path}/mng/news/add"
				method="post"enctype="multipart/form-data">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">新闻标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="title"
							placeholder="请输入新闻标题">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">主配图片</label>
					<div class="col-sm-10">
						<input type="file" class="form-control" name="thumbnail"
							placeholder="主配图片">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">新闻内容</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="content"
							placeholder="请输入新闻内容">
					</div>
				</div>

				<!-- 获取点击量 -->
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">点击量</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="hits"
							placeholder="请输入点击量">
					</div>
				</div>

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">轮播图</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="top"
							placeholder="请设置此项是否轮播图">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">新闻发布时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="pub_time"
							placeholder="请点击设置新闻发布时间"
							onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox"></div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">添加</button>
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