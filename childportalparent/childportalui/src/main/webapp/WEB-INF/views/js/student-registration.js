/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
$(document).ready(function() {
	$(".step2next").prop("disabled",true);
		$(document).on('click', '.sdt_submit', function() { 
			var aadharid=document.getElementById("sdt_aadhar").value;
			var name=document.getElementById("sdt_name").value;
			var localname=document.getElementById("sdt_localname").value;
			var phno=document.getElementById("sdt_phno").value;
			var age=document.getElementById("sdt_age").value;
			var gender=document.getElementById("sdt_gender").value;
			var email=document.getElementById("sdt_email").value;
			var dobtype=document.getElementById("sdt_dobtype").value;
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
			var schid=document.getElementById("sdt_schid").value;
			var std=document.getElementById("sdt_std").value;
			var currentstatus=document.getElementById("sdt_currentstatus").value;
			var schyear=document.getElementById("sdt_schyear").value;
			var createdby=document.getElementById("sdt_createdby").value;
			var comments=document.getElementById("sdt_comments").value;
			//alert("School registration");
			var data2='{"admission": {"aadharNo": "'+aadharid+'","schoolId": "'+schid'","admissionNo": "'+admnno+'","standard": '+std+',"currentStatus": "'+currentstatus+'","schoolingYear": "'+schyear+'","createdBy": "'+createdby+'","comments": "'+comments+'"}}';
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
					        text: "Student registered successfully!",
					        class_name: 'primary',
					        sticky: true
					      });
							$(".sdt_submit").prop("disabled",false);
					}
					else{
						$.gritter.add({
							
					        title: 'Status',
					        text: "Student registration failed!",
					        class_name: 'danger',
					        sticky: true
					      });
							$(".sdt_submit").prop("disabled",false);
					}
				}
			});
			var call_url="/childportalservices/user";
			var data2='{"user":{"aadharNo":"'+aadharid+'","firstName":"'+name+'","gender":"'+gender+'","dob":"'+dob+'","address":"'+address+'","district":"'+district+'"}}';
			$.ajax({
				type: "POST",
				contentType: "application/json",
				
				headers: {
					"Authorization" : "APP urn:ebay-marketplace-consumerid:95fc8531-0191-4509-a1d9-793d04b53749",
					"Accept" : "application/json"
				},
				data: data2,
				url: call_url,
				complete : function(data){
					if (data.status == 200){
					
					}
					else{
						alert("Response code"+data.status);
						
					}
				}
			});
		});
		$(document).on('click', '.sdt_authenticate', function() {
			var aadharid=document.getElementById("sdt_aadhar").value;
			var name=document.getElementById("sdt_name").value;
			var localname=document.getElementById("sdt_localname").value;
			var phno=document.getElementById("sdt_phno").value;
			var age=document.getElementById("sdt_age").value;
			var gender=document.getElementById("sdt_gender").value;
			var email=document.getElementById("sdt_email").value;
			var dobtype=document.getElementById("sdt_dobtype").value;
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
			$(".step2next").prop("disabled",true);
			//alert("School registration");
			if(check_authentication()>0){
			$.gritter.add({
				
		        title: 'Status',
		        text: "Student authenticated successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
			$(".step2next").prop("disabled",false);
			}
			else{
				$.gritter.add({
					
			        title: 'Status',
			        text: "Student authentication failed!",
			        class_name: 'danger',
			        sticky: true
			      });
				$(".step2next").prop("disabled",true);
			}
		});
		$(document).on('click', '.step2next', function() {
			$("#step11").removeClass("complete");
			$("#step12").removeClass("complete");
			$("#step13").addClass("active");
		});
});
function check_authentication(){
	return 1;
}