<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 60px;" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">邮箱账号:</label><input name="mailaccount" class="easyui-box ui-text" style="width:180px;">
	    </p>
	    <p class="ui-fields">
			<label class="ui-label">是否删除:</label>
			<select class="easyui-combobox" name="deletesign" style="width: 100px;" data-options="required:true,panelHeight:'auto'">
                 <option value="2" selected="selected">请选择</option>
                 <option value="0">未删除</option>
                 <option value="1">已删除</option>
            </select>
	    </p>
	    <p class="ui-fields">
			<label class="ui-label">扫描状态:</label>
			<select class="easyui-combobox" name="statesign" style="width: 100px;" data-options="required:true,panelHeight:'auto'">
                 <option value="2" selected="selected">请选择</option>
                 <option value="1">正在扫描</option>
                 <option value="0">已停止扫描</option>
            </select>
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
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:580px;height:380px;" buttons="#dlg-buttons">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id" id="hidd_id">
     		 <input class="hidden" name="deletesign" id="hidden_delete_id"/>
     		 <input class="hidden" name="statesign" id="hidden_statesign_id"/>
<%--     		 <input class="hidden" name="host" id="hidd_host_id">--%>
     		 <div class="ui-edit">
		     	   <div class="ftitle">邮箱管理</div>
					<div class="fitem">
						<label>邮箱账号:</label>
						<input id="mailaccount_id" name="mailaccount" type="text" style="width:60%;height:34px;padding:5px;font-size: 14px;" class="easyui-validatebox" data-options="required:true,validType:'email'">
					</div>
					<div class="fitem">
						<label>邮箱服务器地址:</label>
						<input id="hidd_host_id" name="host" type="text" style="width:60%;height:34px;padding:5px;font-size: 14px;" class="easyui-validatebox" onfocus='onfocussev();'>
					</div>
					<div class="fitem">
						<label>邮箱登录密码:</label>
						<input class="easyui-passwordbox" id="mailpassword_id" name="mailpassword" prompt="请填写邮箱登录密码" iconWidth="28" style="width:60%;height:34px;padding:10px"> 
						<span id="password_meg_id" style="color: red;"></span>
					</div>
					<div class="fitem">
						<label>邮箱授权码:</label>
						<input class="easyui-passwordbox" id="maillicense_id" name="maillicense" prompt="请填写邮箱授权码" iconWidth="28" style="width:60%;height:34px;padding:10px"> 
						<span id="meg_id" style="color: red;"></span>
					</div>
					<br/>
					<div>
						<span style="color: red;font-size: 14px;">&nbsp;&nbsp;&nbsp;
						注：QQ邮箱,网易邮箱&nbsp;126.com,163.com&nbsp;这类邮箱请输入邮箱授权码</span>
						&nbsp;
						<a href="#" onclick="openMail();">获取邮箱授权码</a>
					</div>
  			</div>
     	</form>
  	 </div>
  	 <!--  弹框按钮	 -->
  	 	<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveform()">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#edit-win').dialog('close')">关闭</a>
		</div>
  	 <script type="text/javascript" src="<%=basePath%>/view/sys/sys_js/page-mailbox.js"></script>
  	 <script type="text/javascript" src="<%=basePath%>/view/sys/sys_js/mailbox.js"></script>
  </body>
</html>
