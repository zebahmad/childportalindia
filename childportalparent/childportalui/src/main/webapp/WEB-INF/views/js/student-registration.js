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
		$(document).on('click', '.sdt_submit', function() {
			//alert("School registration");
			$.gritter.add({
				
		        title: 'Status',
		        text: "Student registered successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
		});
		$(document).on('click', '.sdt_authenticate', function() {
			//alert("School registration");
			$.gritter.add({
				
		        title: 'Status',
		        text: "Student authenticated successfully!",
		        class_name: 'primary',
		        sticky: true
		      });
		});
});