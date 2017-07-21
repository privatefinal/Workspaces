<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">名称:</label><input name="keyname" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">key对应的值:</label><input name="keyvalue" class="easyui-box ui-text" style="width:100px;">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list" data-options="checkbox:false,lines:false,fit:true,fitColumns:true,nowrap: false"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">字典数据表</div>
					<div class="fitem">
						<label>名称</label>
						<input name="keyname" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写名称">
					</div>
					<div class="fitem">
						<label>属性值</label>
						<input name="keyvalue" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写key对应的值">
					</div>
<!-- 					<div class="fitem"> -->
<!-- 						<label>创建时间</label> -->
<!-- 						<input name="create_time" type="text" maxlength="" class="easyui-validatebox" data-options="required:true" missingMessage="请填写创建时间"> -->
<!-- 					</div> -->
<!-- 					<div class="fitem"> -->
<!-- 						<label>删除标记，0表示未删除，1表示已删除</label> -->
<!-- 						<input name="delete_mark" type="text" maxlength="" class="easyui-numberbox" data-options="required:true" missingMessage="请填写删除标记，0表示未删除，1表示已删除"> -->
<!-- 					</div> -->
					<div class="fitem">
						<label>组别类型</label>
						<input name="grouptype" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写组别类型">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/view/scott/dictionary/page-dictionary.js"></script>
  </body>
</html>
