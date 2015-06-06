/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_school', function() {
			//alert("School registration");
			$.gritter.add({
				
		        title: 'Status',
		        text: "School registered successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
		});
});