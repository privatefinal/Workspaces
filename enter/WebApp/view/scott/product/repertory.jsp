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
			<label class="ui-label">库存ID:</label><input name="repertoryid" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">产品ID:</label><input name="productid" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">库存总数:</label><input name="productcount" class="easyui-box ui-text" style="width:100px;">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">产品库存</div>
					<div class="fitem">
						<label>库存ID</label>
						<input name="repertoryid" type="text" maxlength="36" class="easyui-validatebox" data-options="required:true" missingMessage="请填写库存ID">
					</div>
					<div class="fitem">
						<label>产品ID</label>
						<input name="productid" type="text" maxlength="36" class="easyui-validatebox" data-options="required:true" missingMessage="请填写产品ID">
					</div>
					<div class="fitem">
						<label>库存总数</label>
						<input name="productcount" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写库存总数">
					</div>
					<div class="fitem">
						<label>售出总数</label>
						<input name="workoffcount" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写售出总数">
					</div>
					<div class="fitem">
						<label>库存剩余总数</label>
						<input name="surpluscount" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写库存剩余总数">
					</div>
					<div class="fitem">
						<label>添加人账号</label>
						<input name="adduser" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写添加人账号">
					</div>
					<div class="fitem">
						<label>添加时间</label>
						<input name="addtime" type="text" maxlength="" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写添加时间">
					</div>
					<div class="fitem">
						<label>最后修改人账号</label>
						<input name="lastupdateuser" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写最后修改人账号">
					</div>
					<div class="fitem">
						<label>最后修改时间</label>
						<input name="lastupdatetime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写最后修改时间">
					</div>
					<div class="fitem">
						<label>删除标记，0否，1是</label>
						<input name="deletesign" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写删除标记，0否，1是">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/view/scott/product/page-repertory.js"></script>
  </body>
</html>
