<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加商品</title>
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
						<li><a href="your/url/">商品操作</a></li>
						<li class="active">商品添加</li>
					</ol>
				</div>
			</div>
			<form class="form-horizontal col-md-8"
				action="${path}/mng/pro/add" method="post" enctype="multipart/form-data">
				<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">商品名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name"
					placeholder="请输入商品名称">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">主配图片</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" name="thumbnail"
				placeholder="主配图片" >
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">请输入库存</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="inventory"
					placeholder="请输入库存" value="0">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">销售量</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sales_volume"
				placeholder="请输入销售量" value="0">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">价格</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="price"
					placeholder="请输入价格" value="0.00" >
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">售价</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sale_price"
					placeholder="请输入售价" value="0.00">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入详情富文本描述</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="30" name="detail_description"
				
					style="width: 700px; height: 200px; visibility: hidden;"
					></textarea>

			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入卖点富文本描述
			</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="30" name="selling_description"
					
					style="width: 700px; height: 200px; visibility: hidden;"
					></textarea>

			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">添加时间</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="create_time"
					placeholder="请输入添加时间"
					onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">开售时间</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sale_time"
					placeholder="请输入开售时间"
					onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
		</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">添加该商品</button>
					</div>
				</div>
			</form>
			<div  style="height: 1000px;width: 100px"></div>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
</body>
</html>