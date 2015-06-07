/**
 * 
 */
$(document).ready(function() {
		$(document).on('click', '.register_school', function() {
			//alert("School registration");
			$(".register_school").prop("disabled",true);
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
			var spinner = new Spinner(opts).spin(target);
			var code=document.getElementById("sch_code").value;
			var name=document.getElementById("sch_name").value;
			var address=document.getElementById("sch_address").value;
			var district=document.getElementById("sch_district").value;
			var state=document.getElementById("sch_state").value;
			var call_url="/childportalservices/org";
			var data2='{"org":{"orgType":"SCHOOL","orgCode":"'+code+'","orgName":"'+name+'","state":"'+state+'","address":"'+address+'","district":"'+district+'"}}';
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
				        text: "School registered successfully!",
				        class_name: 'primary',
				        sticky: true
				      });
						$(".register_school").prop("disabled",false);
						spinner.stop();
					}
					else{
						alert("Response code"+data.status);
						$.gritter.add({
							
					        title: 'Status',
					        text: "School registration failed!",
					        class_name: 'danger',
					        sticky: true
					      });
							$(".register_school").prop("disabled",false);
							spinner.stop();
					}
				}
			});
		});
});