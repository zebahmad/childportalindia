/**
 * 
 */
$(document).ready(function() {
	$(document).on('click', '.sdt_search', function() {
		var aadharid=document.getElementById("sdt_aadharid").value;
	var call_url="/childportalservices/admission/"+aadharid;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		
		headers: {
			"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
			"Accept" : "application/json"
		},
		data: data2,
		url: call_url,
		complete : function(data){
			if (data.status == 200){
				var obj1 = $.parseJSON(data.responseText);
				document.getElementById("sdt_admno").value=obj1.admissionNo;
				document.getElementById("sdt_std").value=obj1.standard;
				document.getElementById("sdt_currentstatus").value=obj1.currentStatus;
				document.getElementById("sdt_schyear").value=obj1.schoolingYear;
				document.getElementById("sdt_createdby").value=obj1.createdBy;
				document.getElementById("sdt_comments").value=obj1.comments;
				document.getElementById("sdt_socialcomments").value=obj1.auditComments;
			}
			else{
				alert("Some error occurred");
			}
		}
	});
	});
		$(document).on('click', '.sdt_submit', function() {
			$(".sdt_submit").prop("disabled",true);
			var aadharid=document.getElementById("sdt_aadhar").value;
			var name=document.getElementById("sdt_name").value;
			var localname=document.getElementById("sdt_localname").value;
			var phno=document.getElementById("sdt_phno").value;
			var age=document.getElementById("sdt_age").value;
			var gender=document.getElementById("sdt_gender").value;
			var email=document.getElementById("sdt_email").value;
			var dob=document.getElementById("sdt_dob").value;
			var careof=document.getElementById("sdt_careof").value;
			var landmark=document.getElementById("sdt_landmark").value;
			var locality=document.getElementById("sdt_locality").value;
			var cityname=document.getElementById("sdt_cityname").value;
			var district=document.getElementById("sdt_district").value;
			var building=document.getElementById("sdt_building").value;
			var street=document.getElementById("sdt_street").value;
			var po=document.getElementById("sdt_po").value;
			var state=document.getElementById("sdt_state").value;
			var pincode=document.getElementById("sdt_pincode").value;
			var admno=document.getElementById("sdt_admno").value;
			var schid=document.getElementById("sdt_schid").value;
			var std=document.getElementById("sdt_std").value;
			var currentstatus=document.getElementById("sdt_currentstatus").value;
			var schyear=document.getElementById("sdt_schyear").value;
			var createdby=document.getElementById("sdt_createdby").value;
			var comments=document.getElementById("sdt_comments").value;
			var socialcomments=document.getElementById("sdt_socialcomments").value;
			var data2='{"admission": {"aadharNo": "'+aadharid+'","schoolId": "'+schid'","admissionNo": "'+admnno+'","standard": '+std+',"currentStatus": "'+currentstatus+'","schoolingYear": "'+schyear+'","createdBy": "'+createdby+'","comments": "'+comments+'","auditComments": "'+socialcomments+'"}}';
			var call_url="/childportalservices/childportalservices/admission";
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
						$.gritter.add({
							
					        title: 'Status',
					        text: "Student details updated successfully!",
					        class_name: 'primary',
					        sticky: true
					      });
							$(".sdt_submit").prop("disabled",false);
					}
					else{
						$.gritter.add({
							
					        title: 'Status',
					        text: "Student details update failed!",
					        class_name: 'danger',
					        sticky: true
					      });
							$(".sdt_submit").prop("disabled",false);
					}
				}
			});
		});
		

});