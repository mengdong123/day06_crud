<%@page import="java.util.List"%>
<%@page import="com.entity.Product"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.zhuoxun365/lzx/shop/simple/tagdemo/q"
	prefix="q"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<!-- 搜索框 -->
				<form action="${path }/mng/pro/search">
					<div class="col-md-4">
						<div class="input-group">
							<div
								class="input-control search-box search-box-circle has-icon-left has-icon-right search-example"
								id="searchboxExample">

								<input id="inputSearchExample3" type="search"
									class="form-control search-input" placeholder="搜索"
									name="search"> <label for="inputSearchExample3"
									class="input-control-icon-left search-icon"><i
									class="icon icon-search"></i></label>
							</div>
							<span class="input-group-btn">
								<button class="btn btn-primary" type="submit">搜索</button>
							</span>
						</div>
					</div>
				</form>
				<!-- 面包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">编辑</a></li>
						<li class="active">商品管理</li>
					</ol>
				</div>
			</div>
			<!-- 引入表格js -->
			<div id="test">
				<table
					class="table table-striped table-bordered active=success table.datatable">
					<tr>
						<td align="center" width="50px"><input type="checkbox"
							id="delete_all" /></td>
						<td align="center" width="50px">商品编号</td>
						<td align="center" width="120px">商品名称</td>
						<td align="center" width="100px">主配图片</td>
						<td align="center" width="70px">库存</td>
						<td align="center" width="70px">销售量</td>
						<td align="center" width="70px">价格</td>
						<td align="center" width="70px">售价</td>
						<td align="center" width="120px">详情富文本</td>
						<td align="center" width="120px">卖点富文本</td>
						<td align="center" width="80px">添加时间</td>
						<td align="center" width="80px">开售时间</td>
						<td align="center" width="70px">操作</td>
					</tr>
					<c:forEach items="${productlist.items }" var="productlist">

						<tr>
							<td align="center"><input type="checkbox" 
								class="btn_checkbox" value="${productlist.id }" /></td>
							<td align="center">${productlist.id }</td>
							<td align="center">${productlist.name }</td>
							<td align="center"><c:if
									test="${productlist.thumbnail!=null }" var="bool">

									<img data-toggle="lightbox"
										src="${path }/image/${productlist.thumbnail }"
										data-image="${path }/image/${productlist.thumbnail }"
										data-caption="" class="img-thumbnail" alt="" width="200">
								</c:if> <c:if test="${!bool }">
									<a disabled href="#" class="btn  disabled"><b>请上传图片</b></a>
								</c:if></td>
							<td align="center">${productlist.inventory }</td>
							<td align="center">${productlist.sales_volume }</td>
							<td align="center">${productlist.price }</td>
							<td align="center">${productlist.sale_price }</td>
							<td align="center">${productlist.detail_description }</td>
							<td align="center">${productlist.selling_description }</td>
							<td align="center"><fmt:formatDate
									value="${productlist.create_time }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td align="center"><fmt:formatDate
									value="${productlist.sale_time }" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td align="center"><a
								href="${path}/mng/pro/edit?id=${productlist.id }"><i
									class="icon icon-cog"></i></a>&nbsp&nbsp&nbsp&nbsp<a
								href="${path}/mng/pro/delete?id=${productlist.id }"><i
									class="icon icon-trash"></i></a>&nbsp&nbsp&nbsp&nbsp<a
								href="${path}/mng/shopcar/add?id=${productlist.id }"><i
									class="icon icon-shopping-cart"></i></a></td>
						</tr>
					</c:forEach>
					<tr>
						<!-- 删除按钮 -->


						<td><a class="btn btn-primary" href="#" id="delete_a">删除</a></td>




						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center"><a class="btn btn-primary"
							href="${path}/mng/pro/add.jsp">添加商品</a></td>
					</tr>

				</table>
			</div>

		</div>
		<q:page totalElements="${productlist.totalcount }"
			url="${path }/mng/pro/list" size="${productlist.size }"
			number="${productlist.number }"></q:page>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
	<!-- 批量删除  -->
	<script type="text/javascript">
         $("#delete_a").click(function(){
        	 var ids="";
        	 
        	 for(i=0;i<$(".btn_checkbox").length;i++){
        		 if($($(".btn_checkbox")[i]).prop('checked')){
        			 ids+=$($(".btn_checkbox")[i]).attr("value")+",";
        		 }}
        		 var url = "${path}/mng/peo/deleteall?ids="+ids.substring(0,ids.length-1);
        	
        	 window.location.href=url; 
         });
         $("#delete_all").click(function(){
        	 alert=("11111111111");
        	if($("#delete_all").prop('checked')){
        		for(var i=0;i<$(".btn_checkbox").length;i++){
        			if(!$($(".btn_checkbox")[i]).prop('checked')){
                         $($(".btn_checkbox")[i]).prop('chected',true);
        			}
        		}
        		}else{
        			if($("#delete_all").prop('checked')){
        		      for(var i=0;i<$(".btn_checkbox").length;i++){
            			if($($(".btn_checkbox")[i]).prop('checked')){
                             $($(".btn_checkbox")[i]).prop('chected',false);
            			}
            			
            		}}
        	}
         });
     </script>

</body>
</html>