<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 45px;" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">产品ID:</label><input name="productid" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">产品名称:</label><input name="productname" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">物品编号:</label><input name="productnumber" class="easyui-box ui-text" style="width:100px;">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list" data-options="fit:true,fitColumns:true"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
<%--		     	   <div class="ftitle">产品</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品ID</label>--%>
<%--						<input name="productid" type="text" maxlength="36" class="easyui-validatebox" data-options="required:true" missingMessage="请填写产品ID">--%>
<%--					</div>--%>
					<div class="fitem">
						<label>产品名称</label>
						<input name="productname" type="text" maxlength="200" class="easyui-validatebox" data-options="" missingMessage="请填写产品名称">
					</div>
					<div class="fitem">
						<label>物品编号</label>
						<input name="productnumber" type="text" maxlength="36" class="easyui-validatebox" data-options="" missingMessage="请填写物品编号">
					</div>
<%--					<div class="fitem">--%>
<%--						<label>进货价格，单位人民币（￥）</label>--%>
<%--						<input name="buyingprice" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写进货价格，单位人民币（￥）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>起标价,单位美元（US$）</label>--%>
<%--						<input name="riseprice" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写起标价,单位美元（US$）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>出售价格，单位美元（US$）</label>--%>
<%--						<input name="sellprice" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写出售价格，单位美元（US$）">--%>
<%--					</div>--%>
					<div class="fitem">
						<label>拍卖结束时间</label>
						<input name="saleendtime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写拍卖结束时间">
					</div>
<%--					<div class="fitem">--%>
<%--						<label>刊登费用</label>--%>
<%--						<input name="publishprice" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写刊登费用">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品发布人账号</label>--%>
<%--						<input name="releaseuser" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写产品发布人账号">--%>
<%--					</div>--%>
					<div class="fitem">
						<label>产品发布时间</label>
						<input name="releasetime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写产品发布时间">
					</div>
<%--					<div class="fitem">--%>
<%--						<label>修改人账号</label>--%>
<%--						<input name="updateuser" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写修改人账号">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>修改时间</label>--%>
<%--						<input name="updatetime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写修改时间">--%>
<%--					</div>--%>
					<div class="fitem">
						<label>删除标记，0否，1是</label>
						<input name="deletemark" type="text" maxlength="" class="easyui-numberbox" data-options="required:true" missingMessage="请填写删除标记，0否，1是">
					</div>
<%--					<div class="fitem">--%>
<%--						<label>图片类型，0标题小图片，1页面展示大图</label>--%>
<%--						<input name="imagtype" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写图片类型，0标题小图片，1页面展示大图">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品标题小图图片</label>--%>
<%--						<input name="images" type="text" maxlength="65535" class="easyui-validatebox" data-options="" missingMessage="请填写产品标题小图图片">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品大图图片路径</label>--%>
<%--						<input name="imagespath" type="text" maxlength="200" class="easyui-validatebox" data-options="" missingMessage="请填写产品大图图片路径">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>供货商Id</label>--%>
<%--						<input name="supplierid" type="text" maxlength="36" class="easyui-validatebox" data-options="" missingMessage="请填写供货商Id">--%>
<%--					</div>--%>
					<div class="fitem">
						<label>产品下架标记，0否，1是</label>
						<input name="offsign" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写产品下架标记，0否，1是">
					</div>
					<div class="fitem">
						<label>产品描述</label>
						<input name="describe" type="text" maxlength="500" class="easyui-validatebox" data-options="" missingMessage="请填写产品描述">
					</div>
					<div class="fitem">
						<label>数据来源标记，0是扫描邮箱，1是手动添加</label>
						<input name="sourcesign" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写数据来源标记，0是扫描邮箱，1是手动添加">
					</div>
					<div class="fitem">
						<label>商标，牌子</label>
						<input name="brand" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写商标，牌子">
					</div>
					<div class="fitem">
						<label>产品特点，特征</label>
						<input name="features" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写产品特点，特征">
					</div>
<%--					<div class="fitem">--%>
<%--						<label>产品颜色</label>--%>
<%--						<input name="color" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写产品颜色">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品重量（单位：克 K）</label>--%>
<%--						<input name="weight" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写产品重量（单位：克 K）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品宽度（单位：毫米 mm）</label>--%>
<%--						<input name="width" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写产品宽度（单位：毫米 mm）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品高度（单位：毫米 mm）</label>--%>
<%--						<input name="height" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写产品高度（单位：毫米 mm）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>产品长度（单位：毫米 mm）</label>--%>
<%--						<input name="length" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写产品长度（单位：毫米 mm）">--%>
<%--					</div>--%>
<%--					<div class="fitem">--%>
<%--						<label>生产地址</label>--%>
<%--						<input name="country" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写生产地址">--%>
<%--					</div>--%>
  			</div>
     	</form>
  	 </div>
  	<div id="detail_id" class="easyui-window" title="产品详细" 
  	data-options="modal:true,minimizable:false,border:'thick',closed:true,iconCls:'icon-save'" 
  	style="width:80%;height:480px;padding:10px;">
       	 <table id="detail_table_id">
       	 
       	 </table>
    </div>
  	 
  	 <script type="text/javascript" src="<%=basePath%>/view/scott/product/page-product.js"></script>
  	 <script type="text/javascript" src="<%=basePath%>/view/scott/product/product.js"></script>
  </body>
</html>


