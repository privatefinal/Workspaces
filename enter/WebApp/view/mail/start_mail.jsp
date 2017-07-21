<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
  <head>
<%--   <%@include file="/view/resource.jsp" %>--%>
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
  </head>
  <body class="easyui-layout">
 	<div align="center" style="width: 100%;">
 		    <div class="state">
 		   		<span>启动读邮件功能</span>
 		    	<input id="sbutton" class="easyui-switchbutton" width='120px' onText="启动" offText="关闭" name="unitState" />
 		    </div>
 	</div>
  </body>
  <script type="text/javascript">
  	function checkeds(checked){
  		$.ajax({
  			type:'post',
  			url:'startmail.do',
  			data:{checked:checked},
  			dataType: "json",
  			success: function(result){
  				if(result.success){
  					$.messager.alert('温馨提示', "启动成功");
  				}else{
  					$.messager.alert('温馨提示', "启动失败");
  				}
  			},error:function(XMLHttpRequest, textStatus, errorThrown){
			          //通常情况下textStatus和errorThrown只有其中一个包含信息
			          alert(textStatus+","+errorThrown);
       			}
  		})
  		
  	}
  	
 $(function(){   
    $('#sbutton').switchbutton({  
        checked: false,  
        onChange: function(checked){  
           		checkeds(checked);
            }  
        })  
    }) 
  </script>
</html>
