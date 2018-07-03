$(document).ready(function() {
    $("#tt").edatagrid({
        url: 'list_contact',
        saveUrl: 'add',
        updateUrl: 'update',
        destroyUrl: 'delete'
    })
});

// 添加 -- js效果，没有跟后台交互
function addRow() {
    $("#tt").edatagrid('addRow');
}

// 保存 -- 与后台交互
function save() {
    $("#tt").edatagrid('saveRow');
}

// 删除行 -- 与后台交互
function deleteRow() {
    $("#tt").edatagrid('destroyRow')
}

// 撤销行 -- 效果
function cancelRow() {
    $("#tt").edatagrid('cancelRow');
}