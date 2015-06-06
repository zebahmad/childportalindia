/**
 * 
 */
/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_ngo', function() {
			//alert("School registration");
			$.gritter.add({
				
		        title: 'Status',
		        text: "NGO registered successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
		});
});