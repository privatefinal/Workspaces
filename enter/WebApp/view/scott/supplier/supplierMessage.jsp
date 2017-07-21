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
			<label class="ui-label">公司名称:</label><input name="company_name" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">供货商公司电话号码:</label><input name="company_phone" class="easyui-box ui-text" style="width:100px;">
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
		     	   <div class="ftitle">供应商信息管理</div>
					<div class="fitem">
						<label>公司名称</label>
						<input name="company_name" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写公司名称">
					</div>
					<div class="fitem">
						<label>供货商公司电话号码</label>
						<input name="company_phone" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写供货商公司电话号码">
					</div>
					<div class="fitem">
						<label>供货商联系人名称</label>
						<input name="contacts_name" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写供货商联系人名称">
					</div>
					<div class="fitem">
						<label>供货商联系人手机号</label>
						<input name="contacts_phone" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写供货商联系人手机号">
					</div>
					<div class="fitem">
						<label>供货商地址</label>
						<input name="company_address" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写供货商地址">
					</div>
					<div class="fitem">
						<label>经营范围</label>
						<input name="scope_of_business" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写经营范围">
					</div>
					<div class="fitem">
						<label>微信号</label>
						<input name="wechat" type="text" maxlength="60" class="easyui-validatebox" data-options="" missingMessage="请填写微信号">
					</div>
					<div class="fitem">
						<label>阿里旺旺id</label>
						<input name="aliwangwang" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写阿里旺旺id">
					</div>
					<div class="fitem">
						<label>qq号</label>
						<input name="qq" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写qq号">
					</div>
					<div class="fitem">
						<label>企业网址</label>
						<input name="url" type="text" maxlength="200" class="easyui-validatebox" data-options="" missingMessage="请填写企业网址">
					</div>
					<div class="fitem">
						<label>供应商类型</label>
						<input name="supplier_type" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写供应商类型">
					</div>
					<div class="fitem">
						<label>删除标记，0表示未删除，1表示已经删除</label>
						<input name="delete_mark" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写删除标记，0表示未删除，1表示已经删除">
					</div>
					<div class="fitem">
						<label>经营模式</label>
						<input name="manage_mode" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写经营模式">
					</div>
					<div class="fitem">
						<label>供应等级</label>
						<input name="supply_level" type="text" maxlength="10" class="easyui-validatebox" data-options="" missingMessage="请填写供应等级">
					</div>
					<div class="fitem">
						<label>满意度</label>
						<input name="satisfied" type="text" maxlength="10" class="easyui-validatebox" data-options="" missingMessage="请填写满意度">
					</div>
					<div class="fitem">
						<label>货描述</label>
						<input name="goods_describe" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写货描述">
					</div>
					<div class="fitem">
						<label>响应速度</label>
						<input name="resp_speed" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写响应速度">
					</div>
					<div class="fitem">
						<label>发货速度</label>
						<input name="delivery_speed" type="text" maxlength="50" class="easyui-validatebox" data-options="" missingMessage="请填写发货速度">
					</div>
					<div class="fitem">
						<label>回头率</label>
						<input name="turnover_rate" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写回头率">
					</div>
					<div class="fitem">
						<label>供应商所在城市</label>
						<input name="supplier_city" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写供应商所在城市">
					</div>
					<div class="fitem">
						<label>供应商是否有实体店，0 表示没有，1表示有</label>
						<input name="physical_store" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写供应商是否有实体店，0 表示没有，1表示有">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="create_time" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/view/scott/supplier/page-supplierMessage.js"></script>
  </body>
</html>
