/**
 * 联系人管理
 */
function openCustomerLinkMan() {

    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("系统消息","请选择想要查看的联系人","info");
        return
    }else if(rows.length>1){
        $.messager.alert("系统消息","只能选择一条记录","info");
    }
    var id=rows[0].id;
    window.parent.openTab("联系人管理",ctx+"/linkman/"+id+"/index","icon-lxr");
}

/**
 * 交往记录
 */
function openCustomerContact() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("系统消息","请选择客户","info");
        return
    }else if(rows.length>1){
        $.messager.alert("系统消息","只能选择一条记录","info");
    }
    var id=rows[0].id;
    window.parent.openTab("交往记录",ctx+"/contact/"+id+"/index","icon-lxr");
}

/**
 * 历史订单查看
 */
function openCustomerOrder() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("系统消息","请选择想要查看的记录");
        return;
    }if(rows.length>1){
        $.messager.alert("系统消息","只能选择一条记录查看");
        return;
    }
    var id=rows[0].id;
    window.parent.openTab("查看历史订单",ctx+"/order/"+id+"/index","icon-lsdd")
}
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
               $("#dg").datagrid("load");
               $("#dlg").dialog("close")
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
    var row = $("#dg").datagrid("getSelections");
    if(row.length<1){
        $.messager.alert("修改客户","请选择需要删除的客户","warning")
        return;
    }
    var ids=[];
    for(var i=0;i<row.length;i++){
        ids.push(row[i].id);
    }
    var url=ctx+'/customer/delete'
    $.messager.confirm("删除客户","确认删除"+row.length+"条客户记录吗?",function (flag) {
        if(flag){
            $.post(url,{ids:ids.join(",")},function (result) {
                //删除成功
                if(result.code==200){
                    $.messager.alert('提示', result.msg, 'info', function() {
                        $("#dg").datagrid('load'); // 重新加载
                    })
                }
                else {
                    $.messager.alert('提示', result.msg, 'info')
                }
            });
        }
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