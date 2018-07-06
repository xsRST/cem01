/**
 * 打开添加框
 */
function openAddDialog() {
    $("#fm").form("clear");
    $("#dlg").dialog("open").dialog("setTitle","添加角色")
}

/**
 * 打开修改框
 */
function openModifyDialog() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("修改数据","请选择一条数据")
    }
    if(rows.length>1){
        $.messager.alert("修改数据","只能选择一条数据")
    }
    $("#fm").form("load",rows[0]);
    $("#dlg").dialog("open").dialog("setTitle","修改角色");

}

/**
 * 添加或修改
 */
function saveOrUpdate() {
    var id=$("#id").val();
    var url="add";
    if(!isNull(id) && !isNaN(id)&& id.trim().length>0){
        url="update";
    }
    $.post(url,$("#fm").serialize(),function (result) {
        $.messager.alert("更新数据",result.msg,"info",function () {
            if(result.code==200){
                closeDialog();
                $("#dg").datagrid("load");
            }
        });
    });


}
/**
 * 关闭弹出框
 */
function closeDialog() {
    $("#dlg").dialog("close");
    $("#fm").form("clear");
}

/**
 * 删除
 */
function deleteRows() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length<1){
        $.messager.alert("删除数据","请选择数据")
    }
    $.messager.confirm("删除数据","是否确认删除"+rows.length+"条数据",function (flag) {
        if(flag){
            var ids=[];
            for(var d in rows){
                ids.push(rows[d].id)
            }
            $.post("delete",{ids:ids.join(",")},function (result) {
                $.messager.alert("删除数据数据",result.msg,"info");
                if(result.code==200){
                    $("#dg").datagrid("load");
                }
            });
        }
    });

}


/**
 * 打开关联权限 role/{id}/
 */
function openRelate() {

}