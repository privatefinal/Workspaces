$package('jeecg.product');
jeecg.product = function(){
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
//  				title:'产品',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
//					{field:'productid',title:'产品ID',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.productid;
//							}
//						},
					{field:'productname',title:'产品名称',align:'center',width:230,sortable:false,
							formatter:function(value,row,index){
								var str = row.productname.replace('#','<br/>');
								return str;
							}
						},
					{field:'productnumber',title:'产品编号',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								return row.productnumber;
							}
						},
//					{field:'buyingprice',title:'进货价格，单位人民币（￥）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.buyingprice;
//							}
//						},
//					{field:'riseprice',title:'起标价,单位美元（US$）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.riseprice;
//							}
//						},
//					{field:'sellprice',title:'出售价格，单位美元（US$）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.sellprice;
//							}
//						},
//					{field:'publishprice',title:'刊登费用',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.publishprice;
//							}
//						},
//					{field:'releaseuser',title:'发布人账号',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.releaseuser;
//							}
//						},
					{field:'releasetime',title:'发布时间',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								return row.releasetime;
							}
						},
					{field:'saleendtime',title:'拍卖结束时间',align:'center',width:100,sortable:true,
							formatter:function(value,row,index){
								return row.saleendtime;
							}
						},
//					{field:'updateuser',title:'修改人账号',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.updateuser;
//							}
//						},
//					{field:'updatetime',title:'修改时间',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.updatetime;
//							}
//						},
					{field:'deletemark',title:'删除标记',align:'center',width:50,sortable:true,
							formatter:function(value,row,index){
								if(row.deletemark == 0){
									return '否';
								}else{
									return '<font style="color: red">是</font>';
								}
							}
						},
//					{field:'imagtype',title:'图片类型，0标题小图片，1页面展示大图',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.imagtype;
//							}
//						},
//					{field:'images',title:'产品标题小图图片',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.images;
//							}
//						},
//					{field:'imagespath',title:'产品大图图片路径',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.imagespath;
//							}
//						},
//					{field:'supplierid',title:'供货商Id',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.supplierid;
//							}
//						},
					{field:'offsign',title:'下架标记',align:'center',width:50,sortable:true,
							formatter:function(value,row,index){
								if(row.offsign == 0){
									return '否';
								}else{
									return '<font style="color: red">是</font>';
								}
							}
						},
						{field:'操作',title:'操作',align:'center',width:60,sortable:false,
							formatter:function(value,row,index){
								var urls = encodeURIComponent(row.url);
								var urlstr = "<a href='#' onclick='openwi(\""+urls+"\")' >店铺</a>";
									urlstr = urlstr+"&nbsp;|&nbsp;";
									urlstr = urlstr +"<a href='#' onclick='detail(\""+row.id+"\",\""+row.productnumber+"\")'>详细</a>";
								return urlstr;
							}
						}
//					{field:'describe',title:'产品描述',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.describe;
//							}
//						},
//					{field:'sourcesign',title:'数据来源',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								if(row.sourcesign == 0){
//									return '邮箱';
//								}else{
//									return '平台';
//								}
//							}
//						},
//					{field:'brand',title:'牌子',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.brand;
//							}
//						},
//					{field:'features',title:'产品特点',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.features;
//							}
//						},
//					{field:'color',title:'产品颜色',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.color;
//							}
//						},
//					{field:'weight',title:'产品重量（单位：克 K）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.weight;
//							}
//						},
//					{field:'width',title:'产品宽度（单位：毫米 mm）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.width;
//							}
//						},
//					{field:'height',title:'产品高度（单位：毫米 mm）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.height;
//							}
//						},
//					{field:'length',title:'产品长度（单位：毫米 mm）',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.length;
//							}
//						},
//					,{field:'操作',title:'操作',align:'center',width:60,sortable:true,
//							formatter:function(value,row,index){
//								return "<a href='#'>详细</a>";
//							}
//						},
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
	jeecg.product.init();
});
	