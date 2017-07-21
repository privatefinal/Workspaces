$package('jeecg.supplierMessage');
jeecg.supplierMessage = function(){
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
  				title:'供应商信息管理',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'company_name',title:'公司名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_name;
							}
						},
					{field:'company_phone',title:'供货商公司电话号码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_phone;
							}
						},
					{field:'contacts_name',title:'供货商联系人名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.contacts_name;
							}
						},
					{field:'contacts_phone',title:'供货商联系人手机号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.contacts_phone;
							}
						},
					{field:'company_address',title:'供货商地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.company_address;
							}
						},
					{field:'scope_of_business',title:'经营范围',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.scope_of_business;
							}
						},
					{field:'wechat',title:'微信号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.wechat;
							}
						},
					{field:'aliwangwang',title:'阿里旺旺id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.aliwangwang;
							}
						},
					{field:'qq',title:'qq号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.qq;
							}
						},
					{field:'url',title:'企业网址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.url;
							}
						},
					{field:'supplier_type',title:'供应商类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supplier_type;
							}
						},
					{field:'delete_mark',title:'删除标记，0表示未删除，1表示已经删除',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delete_mark;
							}
						},
					{field:'manage_mode',title:'经营模式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.manage_mode;
							}
						},
					{field:'supply_level',title:'供应等级',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supply_level;
							}
						},
					{field:'satisfied',title:'满意度',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.satisfied;
							}
						},
					{field:'goods_describe',title:'货描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.goods_describe;
							}
						},
					{field:'resp_speed',title:'响应速度',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.resp_speed;
							}
						},
					{field:'delivery_speed',title:'发货速度',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delivery_speed;
							}
						},
					{field:'turnover_rate',title:'回头率',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.turnover_rate;
							}
						},
					{field:'supplier_city',title:'供应商所在城市',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supplier_city;
							}
						},
					{field:'physical_store',title:'供应商是否有实体店，0 表示没有，1表示有',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.physical_store;
							}
						},
					{field:'create_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.create_time;
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
	jeecg.supplierMessage.init();
});