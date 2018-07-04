$(document).ready(function () {
    $("#dg").edatagrid({
        url: 'list_linkman', // 使用相对路径
        saveUrl: 'add',
        updateUrl: 'update',
        destroyUrl: 'delete'
    });
})


/**
 * 添加联系人
 */
function addPlan() {
    $('#dg').edatagrid('addRow');
}

/**
 * 删除联系人
 */
function deletePlan() {
    $('#dg').edatagrid('destroyRow');
}

/**
 * 保存联系人
 */
function savePlan() {
    $('#dg').edatagrid('saveRow');
    $("#dg").edatagrid("load");
}

/**
 * 撤销
 */
function cancelPlan() {
    $('#dg').edatagrid('cancelRow');
}
