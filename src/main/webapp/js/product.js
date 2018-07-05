/**
 * 打开添加弹出框
 */
function openAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle","添加产品");
    $("#fm").form("clear");
}

/**
 * 打开修改弹出框
 */
function openModifyDialog() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("修改数据","请选择需要更改的数据")
        return;
    }else if(rows.length>1){
        $.messager.alert("修改数据","只能选择一条数据进行更改")
        return;
    }
    $("#fm").form("load",rows[0]);// 填充数据到表单中
    $("#dlg").dialog("open").dialog("setTitle","修改产品数据");
}
function closeDialog() {
    $("#dlg").dialog("close");
}

/**
 * 添加或修改
 */
function saveOrUpdate() {
    var url = 'add';
    var id = $("#id").val();
    if (id != null && !isNaN(id)&&id.length>0) {
        url = 'update';
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
 * 删除
 */
function deleteRows() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length==0){
        $.messager.alert("提示","请选择待删除记录!","warning");
        return;
    }
    var ids = [];
    for(var i=0;i< rows.length;i++){
        ids.push(rows[i].id)
    }
    $.messager.confirm("提示","确定删除选择的"+rows.length+"条记录?",function (r) {
        if(r){
            $.ajax({
                type:"post",
                url:"delete",
                data: {ids: ids.join(',')},
                success:function (data) {
                    $.messager.alert("提示", data.msg);
                    if(data.code==200){
                        $("#dg").datagrid('load');
                    }
                }
            })
        }
    })
}

/**
 * 搜索
 */
function searchRows() {
    $("#dg").datagrid('load',{
        'dataDicName': $("#name").combobox('getValue'),
        'dataDicValue': $("#value").val()
    });
}