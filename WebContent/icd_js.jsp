<%@ page language="java" 
    pageEncoding="utf-8"%>
<!-- 引入jq -->
	<script type="text/javascript"
		src="${path}/js/jquery-3.4.1.js"></script>

	<!-- 最新的 zui 核心 JavaScript 文件 -->
	<script type="text/javascript"
		src="${path}/zui-1.9.1-dist/dist/js/zui.min.js"></script>
		
	<!-- 引入时间js -->
	<script language="javascript" type="text/javascript" src="${path}/My97DatePicker/WdatePicker.js"></script>
	<!-- 引入bootstrapvalidator.js -->
		<script type="text/javascript"
		src="${path}/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
	
	
 	<!-- 引入kingeditors.js -->	
	<script charset="utf-8" src="${path}/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="${path}/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="${path}/kindeditor/plugins/code/prettify.js"></script>
	
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="memo"]', {
				cssPath : '${path}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${path}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${path}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	
	
	<!-- 详细富文本描述_引入kingeditors.js -->	
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="detail_description"]', {
				cssPath : '${path}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${path}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${path}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
		<!-- 卖点富文本描述_引入kingeditors.js -->	
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="selling_description"]', {
				cssPath : '${path}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${path}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${path}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
