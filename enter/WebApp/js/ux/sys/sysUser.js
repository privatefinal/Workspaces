$package('jeecg.sysUser');
jeecg.sysUser = function(){
	var _box = null;
	var _this = {
		updatePwdAction:'updatePwd.do',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			jeecg.progress();//缓冲条
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				jeecg.saveForm(_this.editPwdForm(),function(data){
					jeecg.closeProgress();//关闭缓冲条
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				$.messager.confirm('温馨提示','你确定要提交吗?',function(r){  
				    if (r){  
				     	_this.savePwd();
				    }  
				});
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('温馨提示','你确定要关闭吗?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
  			dataGrid:{
  				title:'系统用户列表',
	   			url:'dataList.do',
	   			autoRowHeight:false,
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'email',title:'邮箱',align:'center',sortable:true,width:200},
						{field:'nickName',title:'昵称',align:'center',sortable:true,width:180},
						{field:'state',title:'状态',align:'center',width:100,sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
						{field:'createTime',title:'创建时间',width:100,align:'center',sortable:true},
						{field:'loginCount',title:'登陆次数',width:80,align:'center',sortable:true},
						{field:'loginTime',title:'登陆时间',width:100,align:'center',sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btnedit',text:'修改密码',btnType:'editPwd',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='id']").val(selected[0].id);
								_this.editPwdForm().find("input[name='email']").val(selected[0].email);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id:'btndelete',text:'删除',btnType:'remove'}
				]
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	jeecg.sysUser.init();
});		