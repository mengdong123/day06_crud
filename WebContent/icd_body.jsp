<%@ page language="java" pageEncoding="utf-8"%>
<div class="col-md-2">
	<nav class="menu" data-ride="menu" style="width: 200px">
		<ul id="treeMenu" class="tree tree-menu" data-ride="tree">
			<li align="center"><a href="#"><img
					src="${ path}/image/${curr_mrg.avatar }" width="120px"
					height="90px" class="img-rounded" alt="圆角图片">
				<div>
						<b>当前管理员：${curr_mrg.lname}</b>
					</div></a></li>
			<li><a href="${path}/mng/home/home.jsp"><i
					class="icon icon-spinner-snake icon-spin"></i>首页</a></li>
			<li><a href="#"><i class="icon icon-user"></i>用户</a></li>
			<li><a href="${path}/mng/news/list?number=1&size=2"><i
					class="icon icon-weibo"></i>今日头条</a></li>
			<li><a href="${path}/mng/pro/list?number=1&size=2"><i
					class="icon icon-time"></i>商品列表</a></li>
			<li><a href="${path}/mng/shop/list"><i
					class="icon icon-trash"></i>购物车</a></li>
			<li><a href="${path}/mng/man/list?number=1&size=2"><i
					class="icon icon-list-ul"></i>管理员管理</a></li>

			<li class="open"><a href="${path}/mng/data/database.jsp"><i
					class="icon icon-tasks"></i>数据库操作</a></li>

		</ul>
	</nav>
</div>
