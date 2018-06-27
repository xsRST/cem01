$(function () {
    $('#dg').datagrid({
        rowStyler: function (index, row) {
            if (row.devResult == 1 || row.devResult == 0) {
                return 'background-color:#F3B35E';
            }
            if (row.devResult == 2) {
                return 'background-color:#B4F8AB';
            }
            if (row.devResult == 3) {
                return 'background-color:#F38471';
            }
        }
    });

    $("#edg").edatagrid({
        url: ctx+"/cusDevPlan/queryByParams",
        saveUrl: ctx+"/cusDevPlan/queryByParams",
        updateUrl: ctx+"/cusDevPlan/queryByParams",
        destroyUrl: ctx+"/cusDevPlan/queryByParams"
    })
});


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