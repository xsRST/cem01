$(function () {
    var data=[];
    $.ajax({
        url:ctx+"/report/find_server_analysis",
        async:false,//同步请求
        type:"JSON",
        success:function (result) {
            var result=result.result;
            for(var d in result){
                var obj={};
                obj.name=result[d].serveType;
                obj.y=result[d].amount;
                data.push(obj);
            }
        }
    })
    var chart = Highcharts.chart('container', {
        title: {
            text: '客户服务分析'
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,  // 可以被选择
                cursor: 'pointer',       // 鼠标样式
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: '浏览器访问量占比',
            data: data
        }]
    });
})