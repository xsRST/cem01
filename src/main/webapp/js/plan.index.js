/**
 * 打开对应销售机会数据
 */
function openPlan(show,value) {
    //通过ID 打开面板
    window.parent.openTab("客户开发计划详情", ctx+"/cusDevPlan/"+value+"/index?show="+show, "icon-kukfjh");
}
/**
 * 更改开发显示状态
 * 0:未开发
 * 1:开发中
 * 2:开发成功
 * 3:开发失败
 */
function formatterDevResult(value) {
    switch (value) {
        case 0:return "未开发";break;
        case 1:return "开发中";break;
        case 2:return "开发成功";break;
        case 3:return "开发失败";break;
        default:break;
    }
}

/**
 * 更改操作 列 显示 开发还是查看详情
 */
function formatterControl(value,row) {
    if(row.devResult==0||row.devResult==1){
        return "<a href='javascript:openPlan(0,"+row.id+")'>开发</a>"
    }
    else{
        return "<a href='javascript:openPlan(1,"+row.id+")'>开发计划详情</a>"
    }
}

/**
 * 条件查询
 */
function querySaleChancesByParams() {
    $("#dg1").datagrid("load",{
        customerName:$("#customerName").val(),
        overview:$("#overview").val(),
        devResult:$("#devResult").combobox("getValue")
    })
}