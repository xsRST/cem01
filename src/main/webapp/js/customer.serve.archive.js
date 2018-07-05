/**
 * 根据条件搜索
 */
function searchCustomerService() {
    $("#dg").datagrid("load",{
        customer:$("#s_customer").val(),
        overview:$("#s_overview").val(),
        createDateFrom:$("#s_createDateFrom").datebox("getValue"),
        createDateTo:$("#s_createDateTo").datebox("getValue")

    })
}