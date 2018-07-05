function saveCustomerService(){
	$("#fm").form("submit",{
		url:ctx+"/customer_serve/insert",
		onSubmit:function(params){
			// params.createPeople=$.cookie("trueName");
            params.state="1";
			return $("#fm").form("validate"); //  表单校验 
		},
		success:function(data){ // 提交成成功后回调
			data=JSON.parse(data);
			if(data.code==200){
				$.messager.alert("来自crm",data.msg,"info");
				$("#serveType").combobox("clear");
				$("#customer").val("");
				$("#overview").val("");
				$("#serviceRequest").val("");
			}else{
				$.messager.alert("来自crm",data.msg,"info");
			}
		}
	});
}
function resetValue() {
    $("#fm").form("clear");
}