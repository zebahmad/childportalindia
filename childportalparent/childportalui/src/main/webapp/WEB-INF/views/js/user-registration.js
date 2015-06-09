/**
 * 
 */
/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_user', function() {
			//alert("School registration");
			$(".register_user").prop("disabled",true);
			var target = document.getElementById('abcd');
			var opts = {
					  lines: 13, // The number of lines to draw
					  length: 10, // The length of each line
					  width: 10, // The line thickness
					  radius: 30, // The radius of the inner circle
					  corners: 1, // Corner roundness (0..1)
					  rotate: 0, // The rotation offset
					  direction: 1, // 1: clockwise, -1: counterclockwise
					  color: '#000', // #rgb or #rrggbb or array of colors
					  speed: 1, // Rounds per second
					  trail: 60, // Afterglow percentage
					  shadow: false, // Whether to render a shadow
					  hwaccel: false, // Whether to use hardware acceleration
					  className: 'spinner', // The CSS class to assign to the spinner
					  zIndex: 2e9, // The z-index (defaults to 2000000000)
					  top: '50%', // Top position relative to parent
					  left: '50%' // Left position relative to parent
					};
			
	        var user_aadhar=document.getElementById("user_aadhar").value;
			var first_name=document.getElementById("first_name").value;
			var last_name=document.getElementById("last_name").value;
			var father_name=document.getElementById("father_name").value;
			var mother_name=document.getElementById("mother_name").value;
			var gender=document.getElementById("gender").value;
			var dob=document.getElementById("dob").value;
			var address=document.getElementById("address").value;
			var district=document.getElementById("district").value;
			var dobtype=document.getElementById("dobtype").value;
			var spinner = new Spinner(opts).spin(target);
			//alert(code+name+address+district+state);
			var call_url="/childportalservices/user";
			var data2='{"user":{"aadharNo":"'+user_aadhar+'","dob_type":"'+dobtype+'","name":"'+first_name+'","firstName":"'+first_name+'","lastName":"'+last_name+'","fatherName":"'+father_name+'","motherName":"'+mother_name+'","gender":"'+gender+'","dob":"'+dob+'","address":"'+address+'","district":"'+district+'"}}';
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
					$.gritter.add({
						
				        title: 'Status',
				        text: "User registered successfully!",
				        class_name: 'primary',
				        sticky: true
				      });
						$(".register_user").prop("disabled",false);
						spinner.stop();
					}
					else{
						alert("Response code"+data.status);
						$.gritter.add({
							
					        title: 'Status',
					        text: "User registration failed!",
					        class_name: 'danger',
					        sticky: true
					      });
							$(".register_user").prop("disabled",false);
							spinner.stop();
					}
				}
			});
		});
});