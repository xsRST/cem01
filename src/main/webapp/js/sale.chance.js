/**
 * 根据开发状态每行显示不同颜色
 *  开发失败:红 3
 *  开发完成:绿 2
 *  开发中:黄 1
 */
$(function () {
    $('#dg').datagrid({
        rowStyler: function(index,row){
            if (row.devResult==1||row.devResult==0){
                return 'background-color:#F3B35E';
            }if (row.devResult==2){
                return 'background-color:#B4F8AB';
            }if (row.devResult==3){
                return 'background-color:#F38471';
            }
        }
    });
})

/**
 * 打开添加框
 */
function openAddSaleChanceDialog() {
    clearFormData();
    $("#dlg").dialog("open")
}

/**
 * 清除框中数值
 */
function  clearFormData() {
    //$("#fm").form("clear");// 可能会出现红色信息提示
    $("input[name='customerName']").val("");
    $("input[name='chanceSource']").val("");
    $("input[name='cgjl']").val("");
    $("input[name='overview']").val("");
    $("input[name='linkMan']").val("");
    $("input[name='linkPhone']").val("");
    $("input[name='description']").val("");
    $("#cc").combobox("setValue","");// 通过name 定位节点存在问题?
}

/**
 * 关闭添加修改框
 */
function closeDialog() {
    $("#dlg").dialog("close")
}

/**
 * 打开修改框
 */
function openUpdateSaleChanceDialog() {
    /*
        判断选择的记录数是否合法
     */
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length==0){
        $.messager.alert("来自crm","请选择需要更新的记录","info");
        return;
    }
    if(rows.length>1){
        $.messager.alert("来自crm","只能选择一条记录","info");
        return;
    }
    $("#fm").form("load",rows[0]);// 填充数据到表单中
    $("#dlg").dialog("open").dialog("setTitle","修改机会记录")

}
/**
 * 添加或修改操作
 */
function saveAndUpdateSaleChance() {
    //判断是添加还是修改操作
    var url=ctx+"/saleChance/update"
    if(isEmpty($("#sid").val())){ //客户id为空,添加操作
        url=ctx+"/saleChance/save"
    }
    $("#fm").form("submit",{
        url:url,
        onSubmit:function (param) {
            param.createMan=$.cookie("trueName");
            return $(this).form("validate");
        },
        success:function (data) {
            data=JSON.parse(data);
            if(data.code==200){
                /**
                 * 操作成功
                 * 关闭对话框
                 * 刷新列表
                 */
                $.messager.alert("来自crm","操作成功","success");
                closeDialog();
                flushList();
            }else{
                /**
                 * 失败 显示提示框
                 */
                $.messager.alert("来自crm",data.msg,"warning");
            }
        }
    })
}

/**
 * 删除机会记录
 */
function deleteSaleChanceDialog() {
    var rows=$("#dg").datagrid("getSelections");
    if(rows.length==0){
        $.messager.alert("来自crm","至少选择一条删除记录","info");
        return;
    }
    $.messager.confirm("来自crm","确定删除吗?",function (flag) {
        if(flag){ //确定删除
            //获取选中id
            var ids="ids=";
            for(var i=0;i<rows.length;i++){
                if(i !=rows.length-1){
                    ids=ids+rows[i].id+"&ids=";
                }else{
                    ids=ids+rows[i].id;
                }
            }
            //执行删除操作
            $.ajax({
                url:ctx+"/saleChance/delete",
                data: ids,
                dataType:"json",
                success:function (data) {
                    if(data.code==200){ //删除成功
                        /*
                            提示 并刷新
                         */
                        $.messager.alert("来自crm",data.msg,"success");
                        flushList();
                    }
                    else{
                        $.messager.alert("来自crm",data.msg,"warning");
                    }
                }
            })
        }
    })
}

/**
 * 刷新当前页
 */
function flushList() {
    $('#dg').datagrid("reload",{
        customerName:$("#customerName").val(),
        createMan:$("#createMan").val(),
        state:$("#state").combobox("getValue")
    })
}

/**
 * 搜索:
 */
function querySaleChancesByParams() {
    $('#dg').datagrid("load",{
        customerName:$("#customerName").val(),
        createMan:$("#createMan").val(),
        state:$("#state").combobox("getValue")
    })
}

/**
 * 分配状态
 * @param value
 * @returns {string}
 */
function  formatterState(value) {
    switch (value){
        case 0:return "未分配";
        break;
        case 1: return "已分配";
            break;
        default :return "未定义"
        break;

    }
}
/**
 * 客户开发状态
 * @param value
 * @returns {string}
 */
function  formatterDevResult(value) {
    /*
         0:未开发
     *   1:开发中
     *   2:开发成功
     *   3:开发失败
     */
    switch (value){
        case 0:return "未开发";
            break;
        case 1: return "开发中";
            break;
        case 2: return "开发成功";
            break;
        case 3: return "开发失败";
            break;
        default :
            break;
    }
}