/**
 * 
 */
/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_ngo', function() {
			$(".register_ngo").prop("disabled",true);
			//alert("School registration");
			var code=document.getElementById("ngo_code").value;
			var name=document.getElementById("ngo_name").value;
			var address=document.getElementById("ngo_address").value;
			var district=document.getElementById("ngo_district").value;
			var state=document.getElementById("ngo_state").value;
			alert(code+name+address+district+state);
			$.gritter.add({
				
		        title: 'Status',
		        text: "NGO registered successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
			$(".register_ngo").prop("disabled",false);
		});
});