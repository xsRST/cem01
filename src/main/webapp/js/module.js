$(document).ready(function () {
    var grade=$("#grade").combobox({onChange:function () {
            //选择层级获取模板名称
            var grade=$("#grade").combobox("getValue");

            if(grade==0){
                $("#parentIdDiv").hide();
            }else {
                $('#parentId').combobox({
                    url:'findNameByGrade?grade='+grade,
                    valueField:'id',
                    textField:'moduleName'
                });
                $("#parentIdDiv").show();
            }
        }})
});
/**
 * 打开添加弹出框
 */
function openAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle","添加模块");
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
    var grade=rows[0].grade;
    if(grade>0){
        $('#parentId').combobox({
            url:'findNameByGrade?grade='+grade+1,
            valueField:'id',
            textField:'moduleName',
            value:rows[0].parentName
        });
    }

    $("#dlg").dialog("open").dialog("setTitle","修改模块数据");
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
    var fm=$("#fm").serialize();
    $.post(url,fm , function(resp) {
        $.messager.alert('提示', resp.msg, 'info', function () {
            if (resp.code == 200) {
                $("#dg").datagrid('load');
                closeDialog();
            }
        })

    })
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
function formatterLevel(value) {
    switch (value) {
        case 0:return "根级";break;
        case 1:return "第一级";break;
        case 2:return "第二级";break;
        case 3:return "第三级";break;
        default:break;
    }
}