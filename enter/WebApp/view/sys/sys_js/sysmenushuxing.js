/*页面加载成功时调用的方法*/

$(document).ready(function () {
	$('#tt').treegrid({    
    url:'../sysMenu/getMenuTree2.do',    
    idField:'id',    
    treeField:'text',
    onClickRow:function(row){
    	cli_onClickRow(row.dataId,row.parentId,row.menu_sign);
    },
    columns:[[
    	{field:'dataId',checkbox:true},
        {title:'菜单名称',field:'text',width:180,sortable:true},    
        {title:'URL',field:'url',width:180,sortable:true},
        {title:'创建者账号',field:'createName',align:'center',width:150,sortable:true},
        {title:'创建时间',field:'createTime',align:'center',width:100,sortable:true},
        {title:'修改者账号',field:'updateName',align:'center',width:150,sortable:true},
        {title:'修改时间',field:'updateTime',align:'center',width:100,sortable:true}
    ]],toolbar:[
					{id:'btnadd',text:'添加菜单组',iconCls:'icon-add',btnType:'add',handler:function(){data_add_edit(0)}},'-',
    				{id:'btnadd',text:'添加菜单',iconCls:'icon-add',btnType:'add',handler:function(){data_add_edit(1)}},'-',
					{id:'btnedit',text:'修改',iconCls:'icon-edit',btnType:'edit',handler:function(){data_add_edit(2)}},'-',
					{id:'btndelete',text:'删除',iconCls:'icon-remove',btnType:'remove',handler:function(){data_add_edit(3)}}
				]
}); 		
});

var url_str = '';

/**
 * 表头上的按钮事件
 * @param {Object} v
 */
function data_add_edit(v){
//	jeecg.progress();
	if(v == 0){//添加菜单组
		$('#edit-win').dialog('open').dialog('setTitle', '添加菜单组');
		$('#editForm').form('clear');
		url_str = 'save.do';
		$('#labelmenunameid').html('菜单组名称:');
		$('#div_url_id').hide(); 
		$('#div_action_id').hide(); 
		$('#div_toolbar_js_id').hide();
		$('#rankid').val('1');
		$('#menu_sign_id').val('0');
	}else if(v == 1){//添加菜单
		var row = $('#tt').datagrid('getSelected');
		if(row){
			if(row.menu_sign == 0){
				delAllLine(true);
				$('#edit-win').dialog('open').dialog('setTitle', '添加菜单');
				$('#editForm').form('clear');
				url_str = 'save.do';
				$('#labelmenunameid').html('菜单名称:');
				$('#div_url_id').show();
				$('#div_action_id').show();
				$('#div_toolbar_js_id').show();
				$('#rankid').val('0');
				$('#edit_parentId').val(row.dataId);
				$('#menu_sign_id').val('1');
			}else{
				$.messager.alert('温馨提示', "请选中菜单组,菜单下面不能添加菜单");
			}
		}else{
			$.messager.alert('温馨提示', "请选中菜单组");
		}
	}else if(v == 2){//修改
		url_str = 'save.do';
		var row = $('#tt').datagrid('getSelected');
		if(row){
			jeecg.progress();
			delAllLine(true);
			$.ajax({
				type:'post',
				url:'getId.do',
				data:{id:row.dataId},
				dataType: "json",
				success: function(result){
					if(result.success){
						$('#edit-win').dialog('open').dialog('setTitle', '修改');
						$('#editForm').form('clear');
						$('#menu_sign_id').val(result.data.menu_sign);
						$('#rankid').val(result.data.rank);
						$('#edit_parentId').val(result.data.parentId);
						$('#dataId').val(result.data.id);
						$('#hidden_deletedid').val(result.data.deleted);
						$('#name_id').val(result.data.name);
						if(result.data.menu_sign != null && result.data.menu_sign == 1){
							$('#labelmenunameid').html('菜单名称:');
							$('#div_url_id').show();
							$('#div_action_id').show();
							$('#div_toolbar_js_id').show();
							$('#url_id').val(result.data.url);
							$('#actions_id').val(result.data.actions);
							$.each(result.data.btns,function(i,btn){
								addLine(btn);
							});
						}else{
							$('#labelmenunameid').html('菜单组名称:');
							$('#div_url_id').hide(); 
							$('#div_action_id').hide(); 
							$('#div_toolbar_js_id').hide();
						}
					}else{
						$.messager.alert('温馨提示', "修改失败");
					}
				},error:function(XMLHttpRequest, textStatus, errorThrown){
			          //通常情况下textStatus和errorThrown只有其中一个包含信息
			          alert(textStatus+","+errorThrown);
       			}
			});
			jeecg.closeProgress();
		}else{
			$.messager.alert('温馨提示', "请选中一条数据");
		}
	}else if(v == 3){//删除
		var row = $('#tt').datagrid('getSelected');
		if(row){
			$.messager.confirm('温馨提示','您确定要删除这条记录吗？',function(r){
					if(r){
						$.ajax({
							type:'post',
							url:'delete.do',
							data:{id:row.dataId},
							dataType: "json",
							success: function(result){
								if(result.success){
									$('#tt').treegrid('reload');
									$.messager.alert('温馨提示', result.data);
								}else{
									$.messager.alert('温馨提示', result.data);
								}
							},error:function(XMLHttpRequest, textStatus, errorThrown){
						          //通常情况下textStatus和errorThrown只有其中一个包含信息
						          alert(textStatus+","+errorThrown);
			       			}
						});
					}
				})
		}else{
			$.messager.alert('温馨提示', "请选中一条记录数据");
		}
	}
}
function addLine(data){	
	var table = $("#btn-tb");
			var	html = "<tr class='tb-line'>";
			html+=	   "	<td align='center'><span  class='newFlag red'>*</span></td>";
			html+=	   "	<td><input name=\"btnName\" class=\"easyui-validatebox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
			html+=	   "	<td><input name=\"btnType\" class=\"easyui-validatebox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
			html+=	   "	<td><input name=\"actionUrls\" class=\"easyui-validatebox text-desc\" style=\"width:100%\"  ></td>";
			html+=	   "	<td align='center'><a class=\"easyui-linkbutton remove-btn\"  iconCls=\"icon-remove\" plain=\"true\"></a>";
			html+=	   "	<input class=\"hidden\" name=\"btnId\">";
			html+=	   "	<input class=\"hidden\" name=\"deleteFlag\">";
			html+=	   "	</td>";
			html+=	   "</tr>";
			var line = $(html);
			//帮定删除按钮事件
			$(".remove-btn",line).click(function(){
				$.messager.confirm('温馨提示','你确定要删除吗?',function(r){
					if(r){
						delLine(line);
					}
				})
			});
			if(data){
				if(data.id){
					$(".newFlag",line).html(''); //清空新增标记
				}
				$("input[name='btnId']",line).val(data.id);
				$("input[name='btnName']",line).val(data.btnName);
				$("input[name='btnType']",line).val(data.btnType);
				$("input[name='actionUrls']",line).val(data.actionUrls);
			}
		$.parser.parse(line);//解析esayui标签
		table.append(line);
}
//设置默认按钮数据
function addDefBtns(){
	var defaultBtns= [
				{"btnName":"添加","menuid":2,"actionUrls":"save.do","btnType":"add"},
				{"btnName":"修改","menuid":2,"actionUrls":"getId.do|save.do","btnType":"edit"},
				{"btnName":"删除","menuid":2,"actionUrls":"delete.do","btnType":"remove"}
			];
			var tbline = $(".tb-line:visible");
			var btnType = $("input[name='btnType']",tbline);
			$.each(defaultBtns,function(i,btn){
				var isExists = false;
				//判断按钮类型是否存在
				if(btnType.length > 0){
					for(var i =0; i < btnType.length; i++){
						if(btnType.eq(i).val() == btn.btnType){
							isExists = true;
							break;
						}
					}
				}
				if(!isExists){
					addLine(btn);
				}
			});
}
//删除全部
function delAllLine(b){
			if(b){
				$(".tb-line").remove();
			}else{
				$(".tb-line").each(function(i,line){
					delLine(line);
				});
			}
		}

//删除单行
function delLine(line){
			if(line){
				var btnId = $("input[name='btnId']",line).val();
				//alert("btnId==="+btnId);
				if(btnId){
					$("input[name='deleteFlag']",line).val(1); //设置删除状态
					line.fadeOut();
				}else{
					line.fadeOut("fast",function(){
						 $(this).remove();
					});
				}
			}
}

/**
 * 表格行被选中事件方法
 */
function cli_onClickRow(dataId,parentId,menu_sign){
	$('#dataId').val(dataId);
	$('#edit_parentId').val(parentId);
//	alert(menu_sign);
}
/*
 * 提交保存表单方法
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */

function savedepartment() {
	$('#editForm').form('submit', {
		url : url_str,
		onSubmit : function() {
			return $(this).form('validate');
		},success : function(result) {		//返回的结果	
			var result = eval('(' + result + ')');
			if(result.success){
				$('#edit-win').dialog('close'); // 关闭窗口
				$('#tt').treegrid('reload');
				$.messager.alert('温馨提示', result.msg);
			}else{
				$.messager.alert('温馨提示', '提交失败...');
			}
		}
	});
}
/**
function savedepartment() {
	$('#editForm').form('submit', {
		url : ca,
		onSubmit : function() {
			return $(this).form('validate');
		},success : function(result) {		//返回的结果	
			var result = eval('(' + result + ')');
			if (result.success) {
				$.messager.show( {
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
					if(result.fua){
						$.messager.alert(prompt, updatefall);
					}else{
						$.messager.alert(prompt,updateSuccess);
						}
				$('#dlg').dialog('close'); // 关闭窗口
				$('#department').datagrid('reload'); // 刷新表格内容
			}			
		}
	});
}
*/