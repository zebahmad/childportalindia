<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/favicon.png">

    <title>Child Portal</title>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'>

    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.min.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.gritter/css/jquery.gritter.css" />
	<!-- Select2 -->
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
	
	
	<!-- Slider -->
	<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
  
  <!-- DateRange -->
	<link rel="stylesheet" type="text/css" href="js/bootstrap.daterangepicker/daterangepicker-bs3.css" />
  
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />

	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/pygments.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
  <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
  <link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->
<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="fa fa-gear"></span>
      </button>
      <a class="navbar-brand" href="#"><span>Child Portal</span></a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="index">Home</a></li>
        <li><a href="#about">About</a></li>
      </ul>
   <ul class="nav navbar-nav navbar-right user-nav">
      <a href="login" style="margin-top: 5px;" class="btn btn-primary">Login</a>
    </ul>	

      </div><!--/.nav-collapse animate-collapse -->
    </div>
  </div>

  		<div id="cl-wrapper" class="fixed-menu">
		<div class="cl-sidebar" data-position="right" data-step="1" data-intro="<strong>Fixed Sidebar</strong> <br/> It adjust to your needs." >
			<div class="cl-toggle"><i class="fa fa-bars"></i></div>
			<div class="cl-navblock">
        <div class="menu-space">
          <div class="content">
            
            <ul class="cl-vnavigation">
              <li><a href="#"><i class="fa fa-list-alt"></i><span>Registration</span></a>
                <ul class="sub-menu">
					<li><a href="SchoolRegistration">School Registration</a></li>
                  <li><a href="StudentRegistration">Student Registration</a></li>
                  <li><a href="NGORegistration">NGO Registration</a></li>
                  <li class="active"><a href="UserRegistration">User Registration</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-list-alt"></i><span>Updation</span></a>
                <ul class="sub-menu">
					<li><a href="StudentDetailsUpdate">Student Details Update</a></li>
                </ul>
              </li>
             
            </ul>
          </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
          <input type="text" class="form-control search" placeholder="Search..." />
          <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
        </div>
			</div>
		</div>
 
  <div class="container-fluid" id="pcont">
    <div class="page-head">
      <h2>User Registration</h2>
    </div>
    <div class="cl-mcont">
    <div class="row">
      <div class="col-sm-6 col-md-6">
        <div class="block-flat">
          <div class="header">							
            <h3>Register a user</h3>
          </div>
          <div class="content">
          <div id="abcd">

          <form role="form"> 
            <div class="form-group"> 
              <label>Aadhar ID</label> <input type="text" id="user_aadhar" placeholder="Enter Aadhar ID" class="form-control">
            </div> 
			<div class="form-group"> 
              <label>First Name</label> <input type="text" id="first_name" placeholder="Enter first name" class="form-control">
            </div> 
			<div class="form-group"> 
              <label>Last Name</label> <input type="text" id="last_name" placeholder="Enter last name" class="form-control">
            </div> 
			<div class="form-group"> 
              <label>Father's Name</label> <input type="text" id="father_name" placeholder="Enter Father's name" class="form-control">
            </div>
            <div class="form-group"> 
              <label>Mother's Name</label> <input type="text" id="mother_name" placeholder="Enter Mother's name" class="form-control">
            </div>
           
            
            <div class="form-group">
            	<label class="control-label">Gender</label><br><br>
                 <input type="radio" name="gender" value="male" class="icheck" id="gender" style="display:inline;"> Male</label> 
                 <input type="radio" name="gender" value="female" class="icheck" id="gender" style="display:inline;"> Female </label> 
             </div>  
             <div class="form-group">
                <label class="control-label"> Date Of Birth </label>
                
                  <div class="input-group date datetime col-md-5 col-xs-7" data-min-view="2" data-date-format="yyyy-mm-dd">
                    <input class="form-control" size="25" id="dob" type="text" value="">
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>					
             </div> 
			<div class="form-group"> 
              <label>Address</label> <input type="text" id="address" placeholder="Enter address" class="form-control">
            </div> 
            <div class="form-group"> 
              <label>District</label> <input type="text" id="district" placeholder="Enter district" class="form-control">
            </div>
                <button type="button" class="btn btn-primary register_user">Register</button>
             
            </form>
          </div>
          </div>
        </div>				
      </div>
      
     
    
    </div>
  </div> 
</div>
    
  <script src="js/jquery.js"></script>
  <script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
  <script src="js/jquery.parsley/dist/parsley.js" type="text/javascript"></script>
  <script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
  <script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="js/user-registration.js"></script>
  <script type="text/javascript"
		src="js/jquery.gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      //initialize the javascript
      App.init();
      
      $('#reservation').daterangepicker();
      $('#reservationtime').daterangepicker({
        timePicker: true,
        timePickerIncrement: 30,
        format: 'MM/DD/YYYY h:mm A'
      });
      var cb = function(start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + "]");
      }

      var optionSet1 = {
        startDate: moment().subtract('days', 29),
        endDate: moment(),
        minDate: '01/01/2012',
        maxDate: '12/31/2014',
        dateLimit: { days: 60 },
        showDropdowns: true,
        showWeekNumbers: true,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: true,
        ranges: {
           'Today': [moment(), moment()],
           'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
           'Last 7 Days': [moment().subtract('days', 6), moment()],
           'Last 30 Days': [moment().subtract('days', 29), moment()],
           'This Month': [moment().startOf('month'), moment().endOf('month')],
           'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
        },
        opens: 'left',
        buttonClasses: ['btn'],
        applyClass: 'btn-small btn-primary',
        cancelClass: 'btn-small',
        format: 'MM/DD/YYYY',
        separator: ' to ',
        locale: {
            applyLabel: 'Submit',
            cancelLabel: 'Clear',
            fromLabel: 'From',
            toLabel: 'To',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
            monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            firstDay: 1
        }
      };

      var optionSet2 = {
        startDate: moment().subtract('days', 7),
        endDate: moment(),
        opens: 'left',
        ranges: {
           'Today': [moment(), moment()],
           'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
           'Last 7 Days': [moment().subtract('days', 6), moment()],
           'Last 30 Days': [moment().subtract('days', 29), moment()],
           'This Month': [moment().startOf('month'), moment().endOf('month')],
           'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
        }
      };

      $('#reportrange span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));

      $('#reportrange').daterangepicker(optionSet1, cb);

    });
  </script>
  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/behaviour/voice-commands.js"></script>
  <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
