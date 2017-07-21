<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
<%--<title>Demo</title>--%>

<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui-1.5/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/base.css">
<!-- ** Javascript ** -->
<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/package.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/urls.js?v=11"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/base.js?v=11"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.easyui-validatebox{width: 180px;}
</style>

</head>
<body class="easyui-layout">
<%--	<div class="ui-search-panel" region="north" style="height: 3px;" ></div>--%>
     <div region="center" border="false">
    	<table id="tt" data-options="checkbox:false,lines:false,fit:true,fitColumns:true,nowrap: false"></table>  
    </div>
    
     <!-- Edit Win&From -->
     <div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true"  style="width:600px;height:450px;" buttons="#dlg-buttons">  
     	<form id="editForm" class="ui-form" method="post"> 
     	 <!-- 隐藏文本框 -->
     	 <input class="hidden" name="id" id='dataId'/>
     	 <input class="hidden" name="deleted" id="hidden_deletedid"/>
    	 <input class="hidden" name="parentId" id='edit_parentId' />
    	 <input class="hidden" name="rank" id="rankid" value="0"/>
    	 <input class="hidden" name="menu_sign" id="menu_sign_id"/>
    	 <div class="easyui-panel" border='false' style="width:550px;height: 350px;">  
	        <div class="easyui-layout" data-options="fit:true">
	            <div data-options="region:'north',split:true" style="height:185px;padding:10px">  
		           <div class="fitem">  
		               <label id="labelmenunameid"></label>  
		               <input class="easyui-validatebox" style="width: 350px;height: 25px;font-size: 14px;" type="text" name="name" id="name_id" data-options="required:true">
		           </div>  
		           <div class="fitem" id="div_url_id">  
		               <label>URL:</label>  
		               <input type="text" class="easyui-validatebox"  style="width: 350px;height: 25px;font-size: 14px;" name="url" id="url_id"></input>
		           </div>  
		           <div class="fitem" id="div_action_id">  
		               <label>Actions:</label>  
		               <textarea id="actions_id" placeholder="页面按钮注册的Action.按'|'分隔" style="width: 350px;font-size: 14px;" name="actions"></textarea>
		           </div> 
	            </div>
	            <div data-options="region:'center'" id="div_toolbar_js_id">  
	              	<div id="toolbar">  
				        <a href="javascript:void(0)" id='addLine_btn' class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addLine();">添加按钮</a>  
				        <a href="javascript:void(0)" id='addDefLine_btn'class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDefBtns();" >添加默认按钮</a>
				    </div>  
				    <table id="btn-tb" style="width:100%">
				    	<thead>
				    	<tr>
				    		<th width="5%"></th>
				    		<th width="25%">按钮名称:</th>
				    		<th width="25%">按钮类型</th>
				    		<th width="35%">注册Action(用"|"分格)</th>
				    		<th width="10%">操作</th>
				    	</tr>
				    	</thead>
				    	<tbody>
				    	</tbody>
				    </table>
	            </div>
	         </div>
	       </div>
     	</form>
  	 </div>
<!--  弹框按钮	 -->
  	 	<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="savedepartment()">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#edit-win').dialog('close')">关闭</a>
		</div>	
	<script type="text/javascript" src="<%=basePath%>/view/sys/sys_js/sysmenushuxing.js"></script>	
</body>
</html>
