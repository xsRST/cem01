function searchCustomerLosses(){
	$("#dg").datagrid("load",{
		cusName:$("#s_cusName").val(),
		cusManager:$("#s_cusManager").val(),
		state:$("#s_state").combobox("getValue")
	});
}


$(function(){
	$("#dg").datagrid({
		rowStyler:function(index,rowData){
			if(rowData.state==0){
				return 'background-color:#F2F5A9';
			}
			if(rowData.state==1){
				return 'background-color:#FE9A2E';
			}
		}
	});
});


function formatterState(val){
	if(val==0){
		return "暂缓流失";
	}
	if(val==1){
		return "确认流失";
	}
}


function formatterOp(val,rowData){
	if(rowData.state==0){
		var href="javascript:openCustomerRepriDetailTab('客户流失暂缓措施管理',"+rowData.id+")";
		return "<a href="+href+">添加暂缓处理</a>";	
	}
	if(rowData.state==1){
        return "客户确认流失";
	}
}

function openCustomerRepriDetailTab(title,lossId){
	window.parent.openTab(title,ctx+"/customer_reprieve/index?lossId="+lossId,"icon-khlsgl");
}
