/**
 * 
 */
$(document).ready(function(){
var oTable1=$('#ngos_table').dataTable( {
        
    	"aaSorting": [[1, 'asc']],
         "aoColumns": [
     	              {"sTitle":"NGO Code"},{"sTitle":"Name"},{"sTitle":"Address"},{"sTitle":"District"},{"sTitle":"State"}
     	            ],
     	 "oLanguage": {
     	              "sEmptyTable": "No data available"
     	            }
     });
var oTable1=$('#school_table').dataTable( {
    
	"aaSorting": [[1, 'asc']],
     "aoColumns": [
 	              {"sTitle":"School Code"},{"sTitle":"Name"},{"sTitle":"Address"},{"sTitle":"District"},{"sTitle":"State"}
 	            ],
 	 "oLanguage": {
 	              "sEmptyTable": "No data available"
 	            }
 });
var oTable1=$('#chart2_details').dataTable( {
    
	"aaSorting": [[1, 'asc']],
     "aoColumns": [
 	              {"sTitle":"Aadhar Number"},{"sTitle":"Name"},{"sTitle":"Gender"},{"sTitle":"Address"},{"sTitle":"District"},{"sTitle":"Mobile"},{"sTitle":"Email"}
 	            ],
 	 "oLanguage": {
 	              "sEmptyTable": "No data available"
 	            }
 });
	load_enrolled_students();
	$(document).on('click', '.sq1', function() {
		document.getElementById("schools").style.display = "block";
		load_schools();
	});
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
	$(document).on('click', '.refreshchart1', function() {
		load_enrolled_students();
	});
	$(document).on('click', '.refreshchart2', function() {
		load_dropouts();
	});
});
function load_enrolled_students(){
	
	document.getElementById("schools").style.display = "none";
	document.getElementById("dropouts").style.display = "none";
	document.getElementById("enrolled").style.display = "block";
	document.getElementById("ngos").style.display = "none";
	var state=document.getElementById("en_state").value;
	var district=document.getElementById("en_district").value;
	var call_url="";
	//alert(state);alert(district);
	if((state!="") && (district=="")){
		call_url="/childportalservices/admission/stats/state/"+state+"/enrolledBy/any/count";
	}else if(district!=""){
		call_url="/childportalservices/admission/stats/state/"+state+"/district/"+district+"/enrolledBy/any/count";
	}else{
		call_url="/childportalservices/admission/stats/enrolledBy/any/count";
	}
	$.ajax({
		type: "GET",
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj1 = $.parseJSON(data.responseText);
				//alert("object length"+obj.length);
				var obj=obj1.statistic.statPoints;
				var datax=[];var i=0;var categoriesx=[];
				for(var h=0;h<obj.length;h++)
				{
					datax[i]=obj[h].count;
					categoriesx[i]=obj[h].month+"-"+obj[h].year;
					i++;
				}
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
		            categories: categoriesx
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
		            data: datax
		        }]
		    });
			}
		}
	});
}
function load_ngos(){
	document.getElementById("schools").style.display = "none";
	document.getElementById("enrolled").style.display = "none";
	document.getElementById("dropouts").style.display = "none";
	document.getElementById("ngos").style.display = "block";
	var call_url="/childportalservices/org/search";
	var data2='{"org": {"orgType": "NGO"}}';
	$.ajax({
		type: "PUT",
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		data: data2,
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj = $.parseJSON(data.responseText);
				//alert("object length"+obj.length);
				for(var h=0;h<obj.length;h++)
				{
					var eobj=obj[h];
				$('#ngos_table').dataTable().fnAddData([eobj.orgCode,eobj.orgName,eobj.address,
				                                        eobj.district,eobj.state
					                                       ]);
				 $('#ngos_table').dataTable().fnDraw();
				}
			}
			else{
				
			}
		}
	});
	
}
function load_schools(){
	document.getElementById("schools").style.display = "block";
	document.getElementById("enrolled").style.display = "none";
	document.getElementById("dropouts").style.display = "none";
	document.getElementById("ngos").style.display = "none";
	var call_url="/childportalservices/org/search";
	var data2='{"org": {"orgType": "school"}}';
	$.ajax({
		type: "PUT",
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		data: data2,
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj = $.parseJSON(data.responseText);
				//alert("object length"+obj.length);
				for(var h=0;h<obj.length;h++)
				{
					var eobj=obj[h];
				$('#school_table').dataTable().fnAddData([eobj.orgCode,eobj.orgName,eobj.address,
				                                        eobj.district,eobj.state
					                                       ]);
				 $('#school_table').dataTable().fnDraw();
				}
			}
			else{
				
			}
		}
	});
}
function load_dropout_details(){
	var state=document.getElementById("dr_state").value;
	var district=document.getElementById("dr_district").value;
	var year=document.getElementById("dr_year").value;
	var call_url="";
	var type1="";
	//alert(state);alert(district);
	if((state!="") && (district=="")){
		call_url="/childportalservices/dropouts/list/"+year+"/state/"+state;
		type1="GET";
	}else if(district!=""){
		call_url="/childportalservices/dropouts/list/"+year+"/district/"+district;
		type1="PUT";
	}
	$.ajax({
		type: type1,
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj1 = $.parseJSON(data.responseText);
				for(var h=0;h<obj.length;h++)
				{
					var eobj=obj[h];
					$('#chart2_details').dataTable().fnAddData([eobj.aadharNo,eobj.firstName+" "+eobj.lastName,eobj.gender,
					                                        eobj.address,eobj.district,eobj.mobile,eobj.email
						                                       ]);
					 $('#chart2_details').dataTable().fnDraw();
				}
			}
		}
	});
}
function load_dropouts(){
	
	document.getElementById("schools").style.display = "none";
	document.getElementById("enrolled").style.display = "none";
	document.getElementById("dropouts").style.display = "block";
	document.getElementById("ngos").style.display = "none";
	var state=document.getElementById("dr_state").value;
	var district=document.getElementById("dr_district").value;
	var call_url="";
	//alert(state);alert(district);
	if((state!="") && (district=="")){
		call_url="/childportalservices/dropouts/stats/state/"+state+"/count";
		load_dropout_details();
	}else if(district!=""){
		call_url="/childportalservices/dropouts/stats/state/"+state+"/district/"+district+"/count";
		load_dropout_details();
	}else{
		call_url="/childportalservices/dropouts/stats/count";
	}
	$.ajax({
		type: "GET",
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj1 = $.parseJSON(data.responseText);
				//alert("object length"+obj.length);
				var obj=obj1.statistic.statPoints;
				var datax=[];var i=0;var categoriesx=[];
				for(var h=0;h<obj.length;h++)
				{
					datax[i]=obj[h].count;
					categoriesx[i]=obj[h].month+"-"+obj[h].year;
					i++;
				}
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
			            categories: categoriesx
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
			            data: datax
			        }]
			    });
			}
		}
	});
}