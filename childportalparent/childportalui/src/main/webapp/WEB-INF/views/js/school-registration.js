/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_school', function() {
			//alert("School registration");
			$(".register_school").prop("disabled",true);
			var code=document.getElementById("sch_code").value;
			var name=document.getElementById("sch_name").value;
			var address=document.getElementById("sch_address").value;
			var district=document.getElementById("sch_district").value;
			var state=document.getElementById("sch_state").value;
			alert(code+name+address+district+state);
			$.gritter.add({
				
		        title: 'Status',
		        text: "School registered successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
			$(".register_school").prop("disabled",false);
		});
});