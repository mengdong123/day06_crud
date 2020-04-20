<%@page import="java.util.List"%>
<%@page import="com.entity.Manager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
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

<title>管理员列表</title>
</head>
<body>
	<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">

		<jsp:include page="../../icd_body.jsp"></jsp:include>
		<div class="col-md-10">
			<div class="row">
				<!-- 搜索框 -->
				<form action="${path }/mng/man/search">
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
				<!-- 麵包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">

						<li><a href="your/url/">用户管理</a></li>
						<li><a href="your/url/">管理员编辑</a></li>
						<li class="active">管理员管理</li>
					</ol>
				</div>
			</div>

			<table class="table table-striped table-bordered active=success">
				<tr>
					<td><input type="checkbox" id="all_checked"
						class="btn_all_checkbox"></td>
					<td align="center">管理员编号</td>
					<td align="center">登录名</td>
					<td align="center">密码</td>
					<td align="center">真实姓名</td>
					<td align="center">密码盐值</td>
					<td align="center">加入时间</td>
					<td align="center">邮箱</td>
					<td align="center">状态</td>
					<td align="center">头像</td>
					<td align="center">联系方式</td>
					<td align="center">备注</td>
					<td align="center">注册时间</td>
					<td align="center">操作</td>
				</tr>


				<c:forEach items="${managerlist.items }" var="man">

					<tr>
						<td><input type="checkbox" class="btn_checkbox"
							name="alldelete" id="alldelete" value="${man.id }"></td>
						<td align="center">${man.id }</td>
						<td align="center">${man.lname }</td>
						<td align="center">${man.pwd }</td>
						<td align="center">${man.real_name }</td>
						<td align="center">${man.salt }</td>
						<td align="center">${man.email }</td>
						<td align="center"><fmt:formatDate
								value="${man.joined_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td align="center">
							<div>
								<label> <input type="radio" name="${man.id }"
									disabled="disabled"
									<c:if test="${man.status==1 }" var="bool">
						
						checked="checked"
						</c:if>>
									在职
								</label> <label> <input type="radio" name="${man.id }"
									disabled="disabled"
									<c:if test="${!bool }">checked="checked"</c:if>> 离职
								</label>
							</div>
						</td>
						<td align="center"><c:if test="${man.avatar!=null }"
								var="bool">


								<img data-toggle="lightbox" src="${path }/image/${man.avatar }"
									data-image="${path }/image/${man.avatar }" data-caption="小图看大图"
									class="img-thumbnail" alt="" width="100" height="60">

							</c:if> <c:if test="${!bool }">

								<a disabled href="#" class="btn  disabled"><b>请上传图片</b></a>

							</c:if></td>
						<td align="center">${man.tel }</td>
						<td align="center">${man.memo }</td>
						<td align="center"><fmt:formatDate
								value="${man.create_time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td align="center"><a
							href="${path}/mng/man/edit?id=${man.id}"><i
								class="icon icon-cog "></i></a>&nbsp&nbsp&nbsp&nbsp<a
							href="${path}/mng/man/delete?id=${man.id}"><i
								class="icon icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr>
					<button id="a_delete" class="btn btn-danger">批量删除</button>
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
					<td></td>
					<td></td>
					<td align="center"><a class="btn btn-primary"
						href="${path}/mng/man/add.jsp">添加管理员</a></td>
				</tr>
			</table>
		</div>
		<q:page totalElements="${managerlist.totalcount }"
			url="${path }/mng/man/list" size="${managerlist.size }"
			number="${managerlist.number }"></q:page>
	</div>

	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>
	<!-- 批量刪除 -->
	<script type="text/javascript">
		$("#a_delete")
				.click(
						function() {
							var ids = '';
							for (var i = 0; i < $(".btn_checkbox").length; i++) {
								//alert($($(".btn_checkbox")[i]).prop('checked'));
								if ($($(".btn_checkbox")[i]).prop('checked')) {
									ids += $($(".btn_checkbox")[i]).attr(
											'value')
											+ ",";
								}
							}

							var url = "${path}/mng/man/delete_all?ids="
									+ ids.substring(0, ids.length - 1);
							window.location.href = url;
						});

		$("#all_checked").click(function() {

			//if($("#all_checked").prop('checked')){
			//for(var i = 0 ;i<$(".btn_checkbox").length;i++){
			//     if(!$($(".btn_checkbox")[i]).prop('checked')){
			////		$($(".btn_checkbox")[i]).prop('checked',true);
			//	}
			//}
			//}else{
			//	for(var i = 0 ;i<$(".btn_checkbox").length;i++){
			//	if($($(".btn_checkbox")[i]).prop('checked')){
			//		$($(".btn_checkbox")[i]).prop('checked',false);
			//	}
			//}
			//}
			for (var i = 0; i < $(".btn_checkbox").length; i++) {
				var sign = false;
				if ($($(".btn_checkbox")[i]).prop('checked')) {
					sign = true;
					$($(".btn_checkbox")[i]).prop('checked', false);
				}
				if (!sign) {
					$($(".btn_checkbox")[i]).prop('checked', true);
				}
			}

		});
	</script>
</body>
</html>