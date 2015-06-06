/**
 * 
 */
$(document).ready(function(){
var oTable1=$('#ngos_table').dataTable( {
        
    	"aaSorting": [[1, 'asc']],
         "aoColumns": [
     	              {"sTitle":"NGO Code"},{"sTitle":"Name"},{"sTitle":"Address"},{"sTitle":"Phone"},{"sTitle":"Website"}
     	            ],
     	 "oLanguage": {
     	              "sEmptyTable": "No data available"
     	            }
     });
var oTable1=$('#chart2_details').dataTable( {
    
	"aaSorting": [[1, 'asc']],
     "aoColumns": [
 	              {"sTitle":"Aadhar Number"},{"sTitle":"Name"},{"sTitle":"Gender"},{"sTitle":"Address"},{"sTitle":"District"},{"sTitle":"State"},{"sTitle":"Schooling History"}
 	            ],
 	 "oLanguage": {
 	              "sEmptyTable": "No data available"
 	            }
 });
	load_enrolled_students();
	$(document).on('click', '.sq3', function() {
		document.getElementById("dropouts").style.display = "block";
		load_dropouts();
	});
	$(document).on('click', '.sq2', function() {
		document.getElementById("enrolled").style.display = "block";
		load_enrolled_students();
	});
	$(document).on('click', '.sq4', function() {
		document.getElementById("ngos").style.display = "block";
		load_ngos();
	});
});
function load_enrolled_students(){
	document.getElementById("dropouts").style.display = "none";
	document.getElementById("enrolled").style.display = "block";
	document.getElementById("ngos").style.display = "none";
	var chart = new Highcharts.Chart({
        chart: {
			renderTo: "enrolled_students"
                },
        title: {
            text: 'Enrolled students on a monthly basis',
        },
        subtitle: {
        	
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Count'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Students',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    });
}
function load_ngos(){
	document.getElementById("enrolled").style.display = "none";
	document.getElementById("dropouts").style.display = "none";
	document.getElementById("ngos").style.display = "block";
	
}
function load_dropouts(){
	document.getElementById("enrolled").style.display = "none";
	document.getElementById("dropouts").style.display = "block";
	document.getElementById("ngos").style.display = "none";
	var chart = new Highcharts.Chart({
        chart: {
			renderTo: "dropout_students"
                },
        title: {
            text: 'Dropouts on a monthly basis',
        },
        subtitle: {
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Count'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
        	name: 'Students',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    });
}