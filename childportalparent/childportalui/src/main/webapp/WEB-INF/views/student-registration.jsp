<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/favicon.png">

    <title>Clean Zone</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'>

    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
    <link href="js/fuelux/css/fuelux.css" rel="stylesheet">
    <link href="js/fuelux/css/fuelux-responsive.min.css" rel="stylesheet">
    <link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/pygments.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
    <link rel="stylesheet" type="text/css"
	href="js/jquery.gritter/css/jquery.gritter.css" />
   <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />

  </head>

<body>


<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="fa fa-gear"></span>
      </button>
      <a class="navbar-brand" href="#"><span>Clean Zone</span></a>
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
                  <li class="active"><a href="StudentRegistration">Student Registration</a></li>
                  <li><a href="NGORegistration">NGO Registration</a></li>
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
      <h2>Student Registration</h2>
    </div>
    <div class="cl-mcont">		
    <div class="row wizard-row">
      <div class="col-md-12 fuelux">
        <div class="block-wizard">
          <div id="wizard1" class="wizard wizard-ux">
            <ul class="steps">
              <li data-target="#step1" class="active">Step 1<span class="chevron"></span></li>
              <li data-target="#step2">Step 2<span class="chevron"></span></li>
              <li data-target="#step3">Step 3<span class="chevron"></span></li>
            </ul>
            <!--  <div class="actions">
              <button type="button" class="btn btn-xs btn-prev btn-default"> <i class="icon-arrow-left"></i>Prev</button>
              <button type="button" class="btn btn-xs btn-next btn-default" data-last="Finish">Next<i class="icon-arrow-right"></i></button>
            </div>-->
          </div>
          <div class="step-content">
            <form class="form-horizontal group-border-dashed" action="#" data-parsley-namespace="data-parsley-" data-parsley-validate novalidate> 
              <div class="step-pane active" id="step1">
                <div class="form-group no-padding">
                  <div class="col-sm-7">
                    <h3 class="hthin">Personal Identity</h3>
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-3">
	                  <label class="control-label">Aadhar ID</label>
	                  <input type="text" class="form-control" id="sdt_aadhar" placeholder="Enter your Aadhar Id">
	              </div>
                  <div class="col-sm-3">
	                  <label class="control-label">Name</label>
	                  <input type="text" class="form-control" id="sdt_name" placeholder="Enter your Name">
                  </div>
                  <div class="col-sm-3">
	                 <label class="control-label">Local Name</label>
	                 <input type="text" class="form-control" id="sdt_localname" placeholder="Enter your local Name">
                  </div>
                </div>	
               <div class="form-group">
	               <div class="col-sm-3">
	                	<label class="control-label">Match Strategy</label>
	                <br><br>
	                  <input type="radio" name="match" id="sdt_match" class="icheck" style="display:inline;"> Exact match 
	                  <input type="radio" name="match" id="sdt_match" class="icheck" style="display:inline;"> Partial match 
	                  <input type="radio" name="match" id="sdt_match" class="icheck" style="display:inline;"> fuzzy match
	                	
	                </div>
	              <div class="col-sm-3">
	                  <label class="control-label">Phone Number</label>
	                    <input type="text" class="form-control" id="sdt_phno" placeholder="Enter your phone number">
                  </div>
                  <div class="col-sm-3">
                  <label class="control-label">Email</label><br>
                  
                    <input type="email" class="form-control" id="sdt_email" placeholder="Enter your email id">
                 </div>
                </div>
                <div class="form-group">
                 <div class="col-sm-3">
                <label class="control-label">Gender</label><br><br>
                 <input type="radio" name="gender" class="icheck" id="sdt_gender" style="display:inline;"> Male</label> 
                 <input type="radio" name="gender" class="icheck" id="sdt_gender" style="display:inline;"> Female </label> 
                </div>
             	<div class="col-sm-3">
                <label class="control-label">DOB Type</label>
                
                  <select class="form-control" id="sdt_dobtype">
                    <option value="A">A</option>
                    <option value="V">V</option>
                    <option value="D">D</option>
                  </select>									
                </div>
                <div class="col-sm-3">
                <label class="control-label"> Date Of Birth </label>
                
                  <div class="input-group date datetime col-md-5 col-xs-7" data-min-view="2" data-date-format="yyyy-mm-dd">
                    <input class="form-control" size="25" id="sdt_dob" required type="text" value="">
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>					
                </div>
              	</div>
                <div class="form-group">
                <div class="col-sm-3">
                  <label class="control-label">Age</label>
                  
                    <input type="text" class="form-control" id="sdt_age" placeholder="Enter your age">
                  </div>
                </div>	
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <button data-wizard="#wizard1" id="sdt_step1next" class="btn btn-primary wizard-next">Next Step <i class="fa fa-caret-right"></i></button>
                  </div>
                </div>									
              </div>
              <div class="step-pane" id="step2">
               <div class="form-group no-padding">
                  <div class="col-sm-7">
                    <h3 class="hthin">Personal Address</h3>
                  </div>
                </div>
                <div class="form-group">
                <div class="col-sm-3">
                  <label class="control-label">Care Of</label>
                  
                    <input type="text" class="form-control" id="sdt_careof" placeholder="">
                  </div>
                  <div class="col-sm-3">
                  <label class="control-label">Land Mark</label>
                  
                    <input type="text" class="form-control" id="sdt_landmark" placeholder="">
                  </div>
                  <div class="col-sm-3">
                  <label class="control-label">Locality</label>
             
                    <input type="text" class="form-control" id="sdt_locality" placeholder="">
                  </div>
                </div>	
               
                <div class="form-group">
                <div class="col-sm-3">
                  <label class="control-label">Village/Town/City Name</label>
                  
                    <input type="text" class="form-control" id="sdt_cityname" placeholder="">
                  </div>
                  <div class="col-sm-3">
                  <label class="control-label">District</label>
                  
                    <input type="text" class="form-control" id="sdt_district" placeholder="">
                  </div>
                  <div class="col-sm-3">
                <label class="control-label">Building</label>
                
                    <input type="text" class="form-control" id="sdt_building" placeholder="">
                  </div>
              </div>
               <div class="form-group">
               <div class="col-sm-3">
                <label class="control-label">Street</label>
                
                    <input type="text" class="form-control" id="sdt_street" placeholder="">
                  </div>
                  <div class="col-sm-3">
                <label class="control-label">PO</label>
                
                    <input type="text" class="form-control" id="sdt_po" placeholder="">
                  </div>
                   <div class="col-sm-3">
                <label class="control-label">State</label>
               
                    <input type="text" class="form-control" id="sdt_state" placeholder="">
                  </div>
              </div>
              <div class="form-group">
               <div class="col-sm-3">
                <label class="control-label">Pin Code</label>
               
                    <input type="text" class="form-control" id="sdt_pincode" placeholder="">
                  </div>
              </div>
              <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                   <button data-wizard="#wizard1" class="btn btn-default wizard-previous"><i class="fa fa-caret-left"></i> Previous</button>
                    <button class="btn btn-primary sdt_authenticate" id="sdt_authenticate">Authenticate</button>
                    <button data-wizard="#wizard1" id="sdt_step2next" class="btn btn-primary wizard-next">Next Step <i class="fa fa-caret-right"></i></button>
                  </div>
                </div>
                </div>  
                
              <div class="step-pane" id="step3">
                <div class="form-group no-padding">
                  <div class="col-sm-7">
                    <h3 class="hthin">Personal Identity</h3>
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-3">
	                  <label class="control-label">Admission Number</label>
	                  <input type="text" class="form-control" id="sdt_admno" placeholder="Enter your admission number">
	              </div>
                  <div class="col-sm-3">
	                <label class="control-label">School ID</label>
	                
	                  <select class="form-control" id="sdt_schid">
	                    <option value="1">1</option>
	                    <option value="2">2</option>
	                    <option value="3">3</option>
	                  </select>									
	                </div>
                  <div class="col-sm-3">
	                <label class="control-label">Standard</label>
	                
	                  <select class="form-control" id="sdt_std">
	                    <option value="1">1</option>
	                    <option value="2">2</option>
	                    <option value="3">3</option>
	                    <option value="4">4</option>
	                    <option value="5">5</option>
	                    <option value="6">6</option>
	                    <option value="7">7</option>
	                    <option value="8">8</option>
	                    <option value="9">9</option>
	                    <option value="10">10</option>
	                    <option value="11">11</option>
	                    <option value="12">12</option>
	                  </select>									
	                </div>
                </div>	
               <div class="form-group">
	               <div class="col-sm-3">
	                  <label class="control-label">Current Status</label>
	                    <input type="text" class="form-control" id="sdt_currentstatus" placeholder="">
                  </div>
	              <div class="col-sm-3">
	                  <label class="control-label">Schooling Year</label>
	                    <input type="text" class="form-control" id="sdt_schyear" placeholder="Enter the schooling year">
                  </div>
                  <div class="col-sm-3">
                <label class="control-label"> Created On </label>
                
                    <input class="form-control" size="25" id="sdt_createdon" readonly="readonly" required type="text" value="">
                </div>
                </div>
                
                <div class="form-group">
                <div class="col-sm-3">
                <label class="control-label">Created By</label>
                  
                    <input type="text" class="form-control" id="sdt_createdby" readonly="readonly" placeholder="">
                 </div>
                 <div class="col-sm-3">
                  <label class="control-label">Age</label>
                  
                    <input type="text" class="form-control" id="sdt_age" placeholder="Enter your age">
                  </div>
                  <div class="col-sm-3">
                  <label class="control-label">Comments</label>
                  <textarea rows="4" cols="50" id="sdt_comments">
				</textarea></div>
              	</div>
                
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <button id="sdt_submit" class="btn btn-primary sdt_submit">Submit</button>
                  </div>
                </div>	
                </div>
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
  <script type="text/javascript" src="js/fuelux/loader.min.js"></script>	
  <script src="js/modernizr.js" type="text/javascript"></script>
  <script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
  <script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
  <script src="js/student-registration.js" type="text/javascript"></script>
  <script type="text/javascript"
		src="js/jquery.gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript">
    $("#credit_slider").slider().on("slide",function(e){
      $("#credits").html("$" + e.value);
    });
    $("#rate_slider").slider().on("slide",function(e){
      $("#rate").html(e.value + "%");
    });
  </script>
  
  <script type="text/javascript">
    $(document).ready(function(){
      //initialize the javascript
      App.init();
      App.wizard();
    });
  </script>
    <script src="js/behaviour/voice-commands.js"></script>

  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
