$package('jeecg.dictionary');
jeecg.dictionary = function(){
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
//  				title:'字典数据表',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'keyname',title:'名称',align:'center',width:150,sortable:false,
							formatter:function(value,row,index){
								return row.keyname;
							}
						},
					{field:'keyvalue',title:'属性值',align:'center',width:150,sortable:true,
							formatter:function(value,row,index){
								return row.keyvalue;
							}
						},
					{field:'create_time',title:'创建时间',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								return row.create_time;
							}
						},
					{field:'grouptype',title:'组别类型编号',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								return row.grouptype;
							}
						},
					{field:'delete_mark',title:'是否删除',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								if(row.delete_mark == 0){
									return '否';
								}else{
									return '<font style="color: red">是</font>';
								}
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
	jeecg.dictionary.init();
});