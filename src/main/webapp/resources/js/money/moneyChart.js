  function drawChart(rows) {

    var data = new google.visualization.DataTable();
    data.addColumn('number', 'Day');
    data.addColumn('number', '매출');
    data.addColumn('number', '비용');
    data.addColumn('number', '순이익');
    
    data.addRows(rows);

//    data.addRows([
//      [1,  37.8, 80.8, 41.8],   
//      [2,  30.9, 69.5, 32.4],
//      [3,  25.4,   57, 25.7],
//      [4,  11.7, 18.8, 10.5],
//      [5,  11.9, 17.6, 10.4],
//      [6,   8.8, 13.6,  7.7],
//      [7,   7.6, 12.3,  9.6]  
//    ]);

    var options = {
      chart: {
        title:'',
        subtitle:''
      },
      width: 900,
      height: 500
    };

    var chart = new google.charts.Line(document.getElementById('linechart_material'));

    chart.draw(data, google.charts.Line.convertOptions(options));
  }

$(document).ready(function() {
	function getData() {
		$.ajax({
			url: "getMoneyData.jy",
			data: {
				startDate: $("#startDate").val(),
				endDate: $("#endDate").val()
			}
		}).done(function(res) {
			var rows = [];
			var d, i, len;
			
			for(i=0, len=res.data.length; i<len; i++) {
				d = res.data[i];
				rows.push([i+1, d.sales, d.cost, d.profit]);
			}
			
			drawChart(rows);
		});
	}
	
	// 일자 초기화
	$("#startDate").val( moment().add(-7, 'days').format("YYYY-MM-DD") );
	$("#endDate").val( moment().format("YYYY-MM-DD") );
	
	$("#btn-view").on("click", getData);
	
	google.charts.load('current', {'packages':['line']});
	//google.charts.setOnLoadCallback(drawChart);	
});