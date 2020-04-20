<%@page import="com.entity.Product"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>编辑商品</title>
<!-- 引入bootstrapcss -->
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
						<li class="active">商品编辑</li>
					</ol>
				</div>
			</div>
	<form class="form-horizontal col-md-8" method="post"
		action="${path }/mng/pro/update?id=${memberedit.id }" enctype="multipart/form-data">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入商品名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name"
					value="${memberedit.name }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">主配图片</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" name="thumbnail"
					value="${memberedit.thumbnail }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">请输入库存</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="inventory"
					value="${memberedit.inventory }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">请输入销售量</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sales_volume"
					value="${memberedit.sales_volume }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">请输入价格</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="price"
					value="${memberedit.price }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">请输入售价</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sale_price"
					value="${memberedit.sale_price }">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入详情富文本描述</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="30" name="detail_description"
					value="${memberedit.detail_description }"
					style="width: 700px; height: 200px; visibility: hidden;"
					></textarea>

			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入卖点富文本描述
			</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="30" name="selling_description"
					value="${memberedit.selling_description }"
					style="width: 700px; height: 200px; visibility: hidden;"
					></textarea>

			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入添加时间</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="create_time"
					value="${memberedit.create_time }"
					onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">请输入开售时间</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sale_time"
					value="${memberedit.sale_time }"
					onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">确定修改</button>
				</a>
			</div>
		</div>
	</form>
	<div  style="height: 1000px;width: 100px"></div>
	</div></div>
	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
    

</body>
</html>