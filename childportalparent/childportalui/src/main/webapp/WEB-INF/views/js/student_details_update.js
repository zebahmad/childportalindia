/**
 * 
 */
$(document).ready(function() {
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
			var schid=document.getElementById("sdt_schid").value;
			var std=document.getElementById("sdt_std").value;
			var currentstatus=document.getElementById("sdt_currentstatus").value;
			var schyear=document.getElementById("sdt_schyear").value;
			var createdby=document.getElementById("sdt_createdby").value;
			var comments=document.getElementById("sdt_comments").value;
			var socialcomments=document.getElementById("sdt_socialcomments").value;
			$.gritter.add({
				
		        title: 'Status',
		        text: "Student details updated successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
			$(".sdt_submit").prop("disabled",false);
		});
		

});