$(document).ready(function () {
    $("#dg").edatagrid({
        url: 'list_linkman', // 使用相对路径
        saveUrl: 'add',
        updateUrl: 'update',
        destroyUrl: 'delete'
    });
})


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
