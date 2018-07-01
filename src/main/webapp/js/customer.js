/**
 * 关闭弹出框
 */
function closeDialog() {
    $("#dlg").dialog('close');
    $("#fm").form("clear");
}

/**
 * 打开添加弹出框
 */
function openAddCustomer() {

    $("#dlg").dialog('setTitle',"添加客户");

    $("#dlg").dialog('open').dialog("setTitle","创建客户");
}

/**
 * 打开修改弹出框
 */
function openUpdateCustomer() {
    var row = $("#dg").datagrid("getSelections");
    if(row.length<1){
        $.messager.alert("修改客户","请选择一个客户","warning")
        return;
    }else if(row.length>1){
        $.messager.alert("修改客户","只能选择一个客户修改","warning");
        return;
    }
    $("#fm").form("load",row[0]);
    $("#dlg").dialog("open").dialog("setTitle","修改客户")
}
/**
 * 添加或修改操作
 */
function saveOrUpdateCustomer() {
    var id=$("#id").val();
    var url=ctx+'/customer/update';
    if(isEmpty(id)){
        url=ctx+'/customer/add'
    }
    $("#fm").form("submit",{
        url:url,
        onSubmit:function (param) {

        },
        success:function (result) {
            var result=JSON.parse(result);
           if(result.code==200){ //操作成功
               $.messager.alert("来自crm",result.msg,"success")
               $("#fm").form("load");

           }else{
               $.messager.alert("来自crm",result.msg,"info")
           }
        }
    });
}

/**
 * 删除客户
 */
function deleteCustomer() {

    $.messager.confirm("删除客户","确认删除客户",function (flag) {

    })
}

/**
 *  搜索/重置当前表格
 */
function queryCustomerByParams() {
    $("#dg").datagrid("load",{
        khno:$("#khno").val(),
        name:$("#name").val()
    })
}

/**
 * 刷新当前页
 */
function reloadCustomer() {
    $("#dg").datagrid("reload",{
        khno:$("#khno").val(),
        name:$("#name").val()
    })
}