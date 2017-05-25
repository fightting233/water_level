/**
 * Created by Administrator on 2017/5/24 0024.
 */
   function show() {
    var myChart1 = echarts.init(document.getElementById('recentDay'));
    var data = [];
    var data1 = [];

    var option1 = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:[]
        },
        toolbox: {
            show: true,
            feature: {
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: data1
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '水位',
            type: 'line',
            smooth: true,
            data: data
        }]
    };

    $(function () {
        $.ajax({
            type: "post",
            url: "/web/getRecentDay",
            data:{},
            success: function (a) {
                var water = jQuery.parseJSON(a);
                $.each(water.level, function (idx, comment) {
                    data.push(comment);
                });
                $.each(water.time, function (idx, comment) {
                    data1.push(comment);
                });
                myChart1.setOption(option1);
            }
        });
    });


    var myChart2 = echarts.init(document.getElementById('recentWeek'));
    var data2 = [];
    var data3 = [];

    var option2 = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:[]
        },
        toolbox: {
            show: true,
            feature: {
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: data3
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '水位',
            type: 'line',
            smooth: true,
            data: data2
        }]
    };

    $(function () {
        $.ajax({
            type: "post",
            url: "/web/getRecentWeek",
            data:{},
            success: function (a) {
                var water = jQuery.parseJSON(a);
                $.each(water.level, function (idx, comment) {
                    data2.push(comment);
                });
                $.each(water.time, function (idx, comment) {
                    data3.push(comment);
                });
                myChart2.setOption(option2);
            }
        });
    });


    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "web/get",
                "type": "POST"
            },
            "columns": [
                { "data": "areaId" },
                { "data": "hardwareId" },
                { "data": "waterLevel" },
                { "data": "time" }
            ]
        } );
    } );


}
