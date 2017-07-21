/*
 * 店铺
 * @param {Object} url
 */
function openwi(url){
	window.open(decodeURIComponent(url),'', 'width='+ (screen.availWidth - 10) +',height='+ (screen.availHeight-50) +',top=0, left=0, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes, location=yes, status=yes, fullscreen=yes');
}
/*
 * 详细
 * @param {Object} id 
 * @param {Object} productnumber 物品编号
 */

function detail(id,productnumber){
//	alert(id+"==="+productnumber);
	$('#detail_id').window('open');
$('#detail_table_id').datagrid({  
//    title:'详细',  
//    width:680,  
//    height:400,  
    remoteSort:false,  
    singleSelect:true,  
    striped:true,  
    fitColumns:true,  
    url:'../product/detail.do?id='+id,  
    columns:[[  
//        {field:'id',title:'Item ID',width:80},  
        {field:'productname',title:'产品名称',width:100,sortable:true,hidden:true},  
        {field:'riseprice',title:'起标价',width:80,align:'right',sortable:true,hidden:true},  
        {field:'productnumber',title:'物品编号',width:80,align:'right',sortable:true,hidden:true},  
        {field:'saleendtime',title:'拍卖结束时间',width:60,align:'center',hidden:true}  
    ]],  
    view: cardview  
});
}
var cardview = $.extend({}, $.fn.datagrid.defaults.view, {  
    renderRow: function(target, fields, frozen, rowIndex, rowData){  
        var cc = [];  
        cc.push('<td colspan=' + fields.length + ' style="padding:5px;border:0;">');  
        if (!frozen){  
            cc.push('<img src="/enter/images/' + rowData.productnumber + '.png" style="height:150px;float:left">');  
            cc.push('<div style="float:left">');  
            for(var i=0; i<fields.length; i++){  
//              cc.push('<p>' + fields[i] + ': ' + rowData[fields[i]] + '</p>'); 
              var copts = $(target).datagrid('getColumnOption', fields[i]);
              cc.push('<p><span class="c-label">' + copts.title + ':</span> ' + rowData[fields[i]] + '</p>')
                
            }  
            cc.push('</div>');  
        }  
        cc.push('</td>');  
        return cc.join('');  
    }  
});