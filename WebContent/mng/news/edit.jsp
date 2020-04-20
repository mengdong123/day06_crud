<%@ page language="java" 
    pageEncoding="utf-8"%>
    <%@page import="com.entity.News"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>编辑菜单功能</title>
<!-- 引入zui -->
<jsp:include page="../../icd_css.jsp"></jsp:include>
</head>
<body>
<%
	News news = (News)request.getAttribute("newsedit");
%>
<jsp:include page="../../icd_daohang.jsp"></jsp:include>
	<!-- 主体部分 -->
	<div class="row">
	<jsp:include page="../../icd_body.jsp"></jsp:include>
	<div class="col-md-10">
			<div class="row">
				<!-- 搜索框 -->
				<div class="col-md-4">
</div>
				<!-- 麵包屑 -->
				<div class="col-md-8" style="text-align: right">
					<ol class="breadcrumb">
						<li><a href="your/url/">新闻管理</a></li>
						<li><a href="your/url/">新闻编辑</a></li>
					</ol>
				</div>
 <h3>编辑</h3>
<form class="form-horizontal col-md-8" action="${path}/mng/news/update?id=${newsedit.id}" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">新闻编号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="id" value="${newsedit.id}"
      placeholder="" disabled="disabled" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">新闻标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" value="${newsedit.title}"
      placeholder="" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">主配图片</label>
    <div class="col-sm-10">
      <input type="file" class="form-control" name="thumbnail" value="${newsedit.thumbnail }"
      placeholder="" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">新闻内容</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="content" value="${newsedit.content}" >
    </div>
    </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">点击量</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="hits" value="${newsedit.hits}" >
    </div>
  </div>
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">轮播图</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="top" value="${newsedit.top}" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">新闻发布时间</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="pub_time" value="${newsedit.pub_time}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
    </div>
    </div>
   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">

      </div>
    </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <button type="submit" class="btn btn-success">确定</button>
    </div>
  </div>
</form>
		</div>
	</div>
</div>
	<!-- 主体结束 -->
	<!-- 底部 -->
	<jsp:include page="../../icd_foot.jsp"></jsp:include>
	<jsp:include page="../../icd_js.jsp"></jsp:include>

</body>
</html>