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
	<link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700' rel='stylesheet' type='text/css'>
  

    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
	    <link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />

  <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
  <link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
	<link rel="stylesheet" type="text/css" href="js/intro.js/introjs.css" />
	<link rel="stylesheet" type="text/css"
	href="js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
	
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />

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
          <li class="active"><a href="index">Home</a></li>
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
                  <li><a href="UserRegistration">User Registration</a></li>
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
          </div>
			</div>
		</div>
	
		<div class="container-fluid" id="pcont">
		  <div class="cl-mcont">
		  
			<div class="stats_bar">
				
				<div class="butpro butstyle sq1">
					<div class="sub"><h2>Registered Schools</h2><span>100</span></div>
					<div class="stat"><span class="spk2"></span></div>
				</div>
				<div class="butpro butstyle sq2">
					<div class="sub"><h2>Enrolled Students</h2><span>10000</span></div>
					<div class="stat"><span class="spk3"></span></div>
				</div>	
				<div class="butpro butstyle sq3">
					<div class="sub"><h2>Children out of school</h2><span>100</span></div>
					<div class="stat"><span class="spk2"></span></div>
				</div>
				<div class="butpro butstyle sq4">
					<div class="sub"><h2>Registered NGOs</h2><span>2000</span></div>
					<div class="stat"><span class="spk3"></span></div>
				</div>	

			</div>

			<div class="row dash-cols">
			
				<div class="col-md-12" id="enrolled">
					<div class="block">
						<div class="header no-border">
							<h2>ENROLLED STUDENTS</h2>
						</div>
						<div class="content"  data-step="3" data-intro="<strong>Unique Styled Plugins</strong> <br/> We put love in every detail to give a great user experience!.">
							<div id="enrolled_students" style="height:180px;"></div>
						</div>
						<div class="content">
							<div class="stat-data">
								<div class="stat-blue">
									<h2>1,254</h2>
									<span>Total admissions</span>
								</div>
							</div>
							<div class="stat-data">
								<div class="stat-number">
									<div><h2>83</h2></div>
									<div>registered students last month</div>
								</div>
								<div class="stat-number">
									<div><h2>57</h2></div>
									<div>registered students last year</div>
								</div>
							</div>
							<div class="clear"></div>
							 
						</div>
					</div>
					<div class="form-group">
				               <div class="col-sm-2">
			                <label class="control-label">State</label>
			                
			                  <input type="text" id="en_state" placeholder="Enter state" class="form-control">								
			                </div>
			                <div class="col-sm-2">
			                <label class="control-label">District</label>
			                
			                  <input type="text" id="en_district" placeholder="Enter district" class="form-control">								
			                </div>
			                <br>
			               <div class="col-sm-2">
			               <button id="refreshchart1" class="btn btn-primary refreshchart1">Load chart</button>
			                </div>
			               </div>
					      								
			        </div>
				</div>	
				
				<div class="col-md-12" id="dropouts">
					<div class="block">
						<div class="header no-border">
							<h2>CHILDREN OUT OF SCHOOL</h2>
						</div>
						<div class="content"  data-step="3" data-intro="<strong>Unique Styled Plugins</strong> <br/> We put love in every detail to give a great user experience!.">
							<div id="dropout_students" style="height:180px;"></div>
						</div>
						<div class="content">
							<div class="stat-data">
								<div class="stat-blue">
									<h2>1,254</h2>
									<span>Total children out of school</span>
								</div>
							</div>
							<div class="stat-data">
								<div class="stat-number">
									<div><h2>83</h2></div>
									<div>dropouts last month</div>
								</div>
								<div class="stat-number">
									<div><h2>57</h2></div>
									<div>dropouts last year</div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
							<div class="form-group">
				               <div class="col-sm-3">
			                <label class="control-label">State</label>
			                
			                  <input type="text" id="dr_state" placeholder="Enter state" class="form-control">								
			                </div>
			                <div class="col-sm-3">
			                <label class="control-label">District</label>
			                
			                  <input type="text" id="dr_district" placeholder="Enter district" class="form-control">								
			                </div>
			                <div class="col-sm-3">
			                <label class="control-label">Year</label>
			                
			                  <input type="text" id="dr_year" placeholder="Enter year" class="form-control">								
			                </div>
			                <br>
			               <div class="col-sm-3">
			               <button id="refreshchart2" class="btn btn-primary refreshchart2">Load chart and get details</button>
			                </div>
			               </div><br>
						<table id="chart2_details" cellpadding="0" cellspacing="0" border="0" class="table table-bordered"></table>
					</div>
					<div class="col-md-12" id="ngos">
						<div class="header no-border">
							<h2>Registered NGOs</h2>
						</div>
						<table id="ngos_table" cellpadding="0" cellspacing="0" border="0" class="table table-bordered"></table>
					</div>
					<div class="col-md-12" id="schools">
						<div class="header no-border">
							<h2>Registered Schools</h2>
						</div>
						<table id="school_table" cellpadding="0" cellspacing="0" border="0" class="table table-bordered"></table>
					</div>
			</div>
			
			
			
			
			
				
				</div>					
			</div>
		
		  </div>
		</div> 
		
	</div>

  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>

  <script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
  <script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
  <script src="js/skycons/skycons.js" type="text/javascript"></script>
  <script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
  <script type="text/javascript"
		src="js/jquery.datatables/jquery.datatables.min.js"></script>
	<script type="text/javascript"
		src="js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>
  <script src="js/intro.js/intro.js" type="text/javascript"></script>
  <script src="js/adhaar.js" type="text/javascript"></script>
  <script src="js/highcharts.js"></script>
<script src="js/exporting.js"></script>
<script src="js/hackathon_home.js"></script>


  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
      $(document).ready(function(){
        //initialize the javascript
        App.init();
        App.dashBoard();     
        App.charts();
        App.dataTables();
      });
    </script>
    <script src="js/behaviour/voice-commands.js"></script>
  <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
  </body>
</html>

