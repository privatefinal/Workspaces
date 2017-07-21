<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource2.jsp" %>
  </head>
	<body class="easyui-layout">
	<!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">邮箱账号:</label><input name="email" class="easyui-box ui-text" style="width:230px;">
            <label class="ui-label">昵称: </label><input name="nickName" class="easyui-box ui-text" style="width:230px;">
        </p>
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <div region="center" border="false" >
     <table id="data-list" data-options="checkbox:false,lines:false,fit:true,fitColumns:true,nowrap: false"></table>
     </div>

     <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="添加用户" data-options="closed:true,iconCls:'icon-add',modal:true" style="width:480px;height:250px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="id">
     		 <input class="hidden" name="deleted">
     		 <div class="ui-edit">
<%--	     	   <div class="ftitle">系统用户信息</div>    --%>
	           <div class="fitem">  
	               <label>邮箱账号:</label>  
	               <input class="easyui-validatebox" type="text" name="email" style="width: 180px;" data-options="required:true,validType:'email'">
	           </div>  
	            
	           <div class="fitem">  
	               <label>昵称:</label>  
	               <input class="easyui-validatebox" type="text" name="nickName" style="width: 180px;" data-options="required:true,validType:'length[1,10]'">
	           </div>
	            <div class="fitem">  
	               <label>状态:</label>  
	               <select class="easyui-combobox" name="state" style="width: 180px;" data-options="required:true,panelHeight:'auto'">
                    	<option value="0" selected="selected">可用</option>
                    	<option value="1">禁用</option>
                   	</select>
	           </div> 
	         </div>
     	</form>
  	 </div> 
  	 
  	 <!-- Edit Password Form -->
     <div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="修改密码" data-options="closed:true,iconCls:'icon-edit',modal:true" style="width:480px;height:250px;">
     	<form id="pwdForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
<%--	     	   <div class="ftitle">User Information</div>    --%>
	           <div class="fitem">  
	               <label>邮箱:</label>  
	               <input class="easyui-validatebox" type="text" style="width: 180px;" readonly="readonly" name="email" data-options="required:true,validType:'email'">
	           </div>  
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" style="width: 180px;" class="easyui-validatebox"/>
	           </div>
	            <div class="fitem">  
	               <label>新置密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" style="width: 180px;" class="easyui-validatebox" data-options="required:true" />
	           </div> 
	           <div class="fitem">  
	               <label>确认密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" style="width: 180px;" class="easyui-validatebox"  data-options="required:true" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	</form>
     	 <div id="editPwdbtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" id="btn-pwd-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
        </div>
  	 </div> 
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/sysUser.js"></script>
  </body>
<script type="text/javascript">
  
function test(dataId){
	alert(dataId);
}
</script>
</html>
