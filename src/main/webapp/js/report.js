function formatAmount(value) {
    if (value == null) {
        return 0
    } else {
        return value;
    }
}

function searchKhgxfx() {
    $("#dg").datagrid('load', {
        'name': $("#s_customerName").val()
    })
}

function searchCustomerLoss() {
    $("#dg").datagrid('load', {
        'cusName': $("#s_cusName").val(),
        'cusManager': $("#s_cusManager").val()
    })
}