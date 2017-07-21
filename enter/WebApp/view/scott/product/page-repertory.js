$package('jeecg.repertory');
jeecg.repertory = function(){
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
  				title:'产品库存',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'repertoryid',title:'库存ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.repertoryid;
							}
						},
					{field:'productid',title:'产品ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.productid;
							}
						},
					{field:'productcount',title:'库存总数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.productcount;
							}
						},
					{field:'workoffcount',title:'售出总数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.workoffcount;
							}
						},
					{field:'surpluscount',title:'库存剩余总数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.surpluscount;
							}
						},
					{field:'adduser',title:'添加人账号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.adduser;
							}
						},
					{field:'addtime',title:'添加时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.addtime;
							}
						},
					{field:'lastupdateuser',title:'最后修改人账号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lastupdateuser;
							}
						},
					{field:'lastupdatetime',title:'最后修改时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lastupdatetime;
							}
						},
					{field:'deletesign',title:'删除标记，0否，1是',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.deletesign;
							}
						},
					]]
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
	jeecg.repertory.init();
});