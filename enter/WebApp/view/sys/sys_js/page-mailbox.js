$package('jeecg.mailbox');
jeecg.mailbox = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				//title:'邮箱管理',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true,width:30},
					{field:'mailaccount',title:'邮箱账号',align:'center',width:100, sortable:false,
							formatter:function(value,row,index){
								return row.mailaccount;
							}
						},
					{field:'host',title:'邮箱服务器地址',align:'center',width:80, sortable:false,
							formatter:function(value,row,index){
								return row.host;
							}
						},
					{field:'adduser',title:'添加人',align:'center',width:100,sortable:false,
							formatter:function(value,row,index){
								return row.adduser;
							}
						},
					{field:'adddate',title:'添加时间',align:'center',width:70,sortable:true,
							formatter:function(value,row,index){
								return row.adddate;
							}
						},
					{field:'updateuser',title:'修改人',align:'center',width:100,sortable:false,
							formatter:function(value,row,index){
								return row.updateuser;
							}
						},
					{field:'updatetime',title:'修改时间',align:'center',width:70,sortable:true,
							formatter:function(value,row,index){
								return row.updatetime;
							}
						},
					{field:'deletesign',title:'是否删除',align:'center',width:50,sortable:false,
							formatter:function(value,row,index){
								var deletestr = '';
								if(row.deletesign == 0){
									deletestr = '否';
								}else{
									deletestr = '<font color="red">是</font>';
								}
								return deletestr;
							}
						},
					{field:'statesign',title:'扫描状态',align:'center',width:50,sortable:false,
							formatter:function(value,row,index){
								var statestr = '';
								if(row.statesign == 0){
									statestr = '已暂停';
								}else{
									statestr = '<font color="red">扫描中</font>';
								}
								return statestr;
							}
						}
					]]
					,toolbar:[
						{id:'btnadd',text:'添加',iconCls:'icon-add',btnType:'add',handler:function(){data_add_edit('add')}},
						{id:'btnedit',text:'修改',iconCls:'icon-edit',btnType:'edit',handler:function(){data_add_edit('update')}},
						{id:'btndelete',text:'删除',iconCls:'icon-remove',btnType:'remove',handler:function(){delete_undo('dele')}},
						{id:'btndelete',text:'恢复',iconCls:'icon-undo',btnType:'undo',handler:function(){delete_undo('undo')}},
						{id:'btndelete',text:'启动扫描邮箱',iconCls:'icon-search',btnType:'search',handler:function(){searchmail('open')}},
						{id:'btndelete',text:'关闭扫描邮箱',iconCls:'icon-clear',btnType:'cancel',handler:function(){searchmail('close')}}
					]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	jeecg.mailbox.init();
});
