    $("#dg").edatagrid({
        url: 'list_plan', // 使用相对路径
        saveUrl: 'add',
        updateUrl: 'update',
        destroyUrl: 'delete'
    });

/**
 * 添加计划
 */
function addPlan() {
    $('#dg').edatagrid('addRow');
}

/**
 * 删除计划
 */
function deletePlan() {
    $('#dg').edatagrid('destroyRow');
}

/**
 * 保存计划
 */
function savePlan() {
    $('#dg').edatagrid('saveRow');
}
function cancelPlan() {
    $('#dg').edatagrid('cancelRow');
}
/**
 * 更改开发状态
 * @param value
 */
function updateSaleChanceDevResult(value) {
    $.get("update_dev_result",{"devResult":value},function (result) {
        $.messager.alert("提示",result.msg,"info",function () {
            if(result.code==200){
                var url=ctx + '/saleChance/cusDevPlanIndex';
                window.parent.openTab('客户开发计划',url,'icon-khkfjh')
            }
        })
    })
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
