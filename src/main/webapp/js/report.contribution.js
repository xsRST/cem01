$(function () {
    var categories=[];
    var data=[];
    /*ajax同步请求从后台获取数据,包含客户等级,客户数量*/
    $.ajax({
        url:"find_contribution",
        type:"JSON",
        async:false, //同步请求
        success:function (result) {
            var result=result.result;
            for(var d in result){
                categories.push(result[d].level);
                data.push(result[d].count)
            }
        }

    })
    var chart = Highcharts.chart('container',{
        chart: {
            type: 'column'
        },
        title: {
            text: '客户构成分析'
        },
        xAxis: {
            categories: categories,
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '客户数量'
            }
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        series: [{
            name: '客户',
            data: data
        }]
    });
});