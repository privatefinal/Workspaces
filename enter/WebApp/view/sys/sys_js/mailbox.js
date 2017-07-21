/**
 * 按钮点击事件调用的方法,添加，修改
 * @param {Object} str
 */
var urlstr = '';
function data_add_edit(str){
	$('#password_meg_id').text("");
	$('#meg_id').text("");
	//初始化form表单
	$('#editForm').form('clear');
	if(str == 'add'){
		$('#edit-win').dialog('open').dialog('setTitle', '添加邮箱账号');
		urlstr = 'save.do';
	}else if(str == 'update'){
		urlstr = 'save.do';
		var row = $('#data-list').datagrid('getSelected');
//		var row = $('#data-list').datagrid('getChecked');  
		if(row){
			if(row.deletesign == 0){
			jeecg.progress();
			$.ajax({
				type:'post',
				url:'getId.do',
				data:{id:row.id},
				dataType: "json",
				success: function(result){
					if(result.success){
						$('#edit-win').dialog('open').dialog('setTitle', '修改邮箱账号');
						$('#mailaccount_id').validatebox('disableValidation'); //禁止验证
						$('#mailaccount_id').val(result.data.mailaccount);
						$('#hidd_host_id').val(result.data.host);
						$('#mailaccount_id').validatebox('enableValidation'); //启动输入框验证
						$('#hidden_delete_id').val(result.data.deletesign);
						$('#hidden_statesign_id').val(result.data.statesign);
						$('#hidd_id').val(row.id);
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
				$.messager.alert('温馨提示', "这条记录已删除，不能修改...");
			}
		}else{
			$.messager.alert('温馨提示', "请选中一条记录");
		}
	}
}
/**
 * 验证邮箱是否是网易邮箱，
 * 如果是一定要输入授权码
 */
function verifyMail(){
	var mailaccount = $('#mailaccount_id').val();
	
	if(mailaccount != null && mailaccount != ""){
		 var las = '@126.com';
		 var pos = mailaccount.lastIndexOf(las);
		 var d = mailaccount.length - las.length;
		
		 if(d > 0 && pos === d){
			 	$('#hidd_host_id').val('imap.126.com');
				var maillicense = $('#maillicense_id').val();
				if(maillicense == null || maillicense == ""){
					$('#meg_id').text("请输入授权码");
					return false;
				}else{
					return true;
				}
		} 
		 var las_163 = '@163.com';
		 var pos_163 = mailaccount.lastIndexOf(las_163);
		 var d_163 = mailaccount.length - las_163.length;
		if(d_163 > 0 && pos_163 === d_163){
			   $('#hidd_host_id').val('imap.163.com');
				var maillicense = $('#maillicense_id').val();
				if(maillicense == null || maillicense == ""){
					$('#meg_id').text("请输入授权码");
					return false;
				}else{
					 return true;
				}
		}
		var las_qq = '@qq.com';
		var pos_qq = mailaccount.lastIndexOf(las_qq);
		var d_qq = mailaccount.length - las_qq.length;
		if(d_qq > 0 && pos_qq == d_qq ){
			$('#hidd_host_id').val('imap.qq.com');
			var mailpassword = $('#mailpassword_id').val();
			if(mailpassword == null || mailpassword == ""){
				$('#password_meg_id').text("请输入邮箱登录密码");
				return false;
			}else{
				return true;
			}
			var maillicense = $('#maillicense_id').val();
				if(maillicense == null || maillicense == ""){
					$('#meg_id').text("请输入授权码");
					return false;
				}else{
					 return true;
				}
		}
			 
	}
}

/**
 * 邮箱服务器地址文本框获得焦点后的事件
 */
function onfocussev(){
	verifyMail();
}

/**
 * 删除,恢复
 */
function delete_undo(v){
	var row = $('#data-list').datagrid('getSelected');
	if(row){
		if(v === 'dele'){
			if(row.deletesign == 0){
				jeecg.progress();
				$.ajax({
					type:'post',
					url:'deleteUndo.do',
					data:{id:row.id,deletesign:1},
					dataType: "json",
					success: function(result){
						if(result.success){
							$('#data-list').datagrid('reload');//刷新表格数据
							$.messager.alert('温馨提示', result.msg);
						}else{
							$.messager.alert('温馨提示', "删除失败");
						}
					},error:function(XMLHttpRequest, textStatus, errorThrown){
				          //通常情况下textStatus和errorThrown只有其中一个包含信息
				          alert(textStatus+","+errorThrown);
	       			}
				});
				jeecg.closeProgress();
			}else{
				$.messager.alert('温馨提示', "这条记录已经是被删除...");
			}
		}else if(v === 'undo'){
			if(row.deletesign == 1){
				jeecg.progress();
				$.ajax({
					type:'post',
					url:'deleteUndo.do',
					data:{id:row.id,deletesign:0},
					dataType: "json",
					success: function(result){
						if(result.success){
							$('#data-list').datagrid('reload');//刷新表格数据
							$.messager.alert('温馨提示', result.msg);
						}else{
							$.messager.alert('温馨提示', "恢复失败");
						}
					},error:function(XMLHttpRequest, textStatus, errorThrown){
				          //通常情况下textStatus和errorThrown只有其中一个包含信息
				          alert(textStatus+","+errorThrown);
	       			}
				});
				jeecg.closeProgress();
			}else{
				$.messager.alert('温馨提示', "这条记录已经是正常...");
			}
		}
	}else{
		$.messager.alert('温馨提示', "请选中一条记录");
	}
}

/**
 * 提交表单保存数据
 */
function saveform(){
	var bool = verifyMail();
	if(bool){
		$('#editForm').form('submit', {
			url : urlstr,
			onSubmit : function() {
				return $(this).form('validate');
			},success : function(result) {		//返回的结果	
				var result = eval('(' + result + ')');
				if(result.success){
					$('#edit-win').dialog('close'); // 关闭窗口
					$('#data-list').datagrid('reload');//刷新表格数据
					$.messager.alert('温馨提示', result.msg);
				}else{
					$.messager.alert('温馨提示', '提交失败...');
				}
			}
		});
	}
}

/**
 * 邮件扫描
 */
function searchmail(v){
	var row = $('#data-list').datagrid('getSelected');
	if(row){
		if(v === 'open'){
			if(row.statesign == 0 && row.deletesign == 0){
				$.messager.confirm('温馨提示','您确定要启动扫描这个邮箱吗？',function(r){
					if(r){
						jeecg.progress();
						$.ajax({
							type:'post',
							url:'startmail.do',
							data:{id:row.id,statesign:1,mailaccount:row.mailaccount,maillicense:row.maillicense,host:row.host},
							dataType: "json",
							success: function(result){
								if(result.success){
									$('#data-list').datagrid('reload');//刷新表格数据
									$.messager.alert('温馨提示', result.msg);
								}else{
									$.messager.alert('温馨提示', "邮箱扫描启动失败");
								}
							},error:function(XMLHttpRequest, textStatus, errorThrown){
						          //通常情况下textStatus和errorThrown只有其中一个包含信息
						          alert(textStatus+","+errorThrown);
			       			}
						});
						jeecg.closeProgress();
					}
				})
			}else{
				$.messager.alert('温馨提示', "该邮箱已在扫描中...");
			}
		}else if(v === 'close'){
			if(row.statesign == 1 && row.deletesign == 0){
				$.messager.confirm('温馨提示','您确定要暂停扫描这个邮箱吗？',function(r){
					if(r){
						jeecg.progress();
						$.ajax({
							type:'post',
							url:'startmail.do',
							data:{id:row.id,statesign:0,mailaccount:row.mailaccount},
							dataType: "json",
							success: function(result){
								if(result.success){
									$('#data-list').datagrid('reload');//刷新表格数据
									$.messager.alert('温馨提示', result.msg);
								}else{
									$.messager.alert('温馨提示', "邮箱扫描关闭失败");
								}
							},error:function(XMLHttpRequest, textStatus, errorThrown){
						          //通常情况下textStatus和errorThrown只有其中一个包含信息
						          alert(textStatus+","+errorThrown);
			       			}
						});
						jeecg.closeProgress();
					}
				})
			}else{
				$.messager.alert('温馨提示', "该邮箱已暂停扫描...");
			}
		}
	}else{
		$.messager.alert('温馨提示', "请选中一条记录");
	}
	
}


/**
 * 网易邮箱获取授权码教程
 */
function openMail(){
	window.open("http://mail.126.com/",'网易邮箱获取授权码教程', 'width='+ (screen.availWidth - 10) +',height='+ (screen.availHeight-50) +',top=0, left=0, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes, location=yes, status=yes, fullscreen=yes')
}
