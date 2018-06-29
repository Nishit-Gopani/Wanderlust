<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight status</title>

<script src="./js/jquery-1.12.3.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./js/css/bootstrap.css">
<style>
#background {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('/WanderlustTravel/images/Flight_Search.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    opacity: 0.70;
    filter:alpha(opacity=80);
}
#noFlight {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('/WanderlustTravel/images/Nofilght.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    opacity:0.50;
    filter:alpha(opacity=80);
   
}
th, td , tr {
	 color: #ffffff;
	}
#flightDetails_table
{
   	 border: 2px solid black;

}
h4{
 color: red;
} body.modal-open {
    overflow: auto;
}
body.modal-open[style] {
    padding-right: 0px !important;
}

.modal::-webkit-scrollbar {
    width: 0 !important; 
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#myPage">Wanderlust Airways</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${sessionScope.currentUser != null}">
				<li><a href="Login.jsp">HOME</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="Home.jsp">HOME</a></li>
				</c:otherwise>
			</c:choose>
				<li><a href="base?module=home&action=view#managebooking">MANAGE
						BOOKING</a></li>
				<li><a href="./Login.jsp#contact">CONTACT US</a></li>
				<li><a href="./Login.jsp#aboutus">ABOUT US</a></li>
				<c:choose>
					<c:when test="${sessionScope.currentUser != null}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><span
								class="glyphicon glyphicon-user"></span> <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">
										<%
											if (session.getAttribute("currentUser") != null) {
														out.println(session.getAttribute("currentUser"));
													}
										%>
								</a></li>
								<li><a href="#" data-toggle="modal"
									data-target="#editprofile">Edit Profile</a></li>
								<li><a href="base?module=user&action=signout"><span
										class="glyphicon glyphicon-log-out"></span> Sign out</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li><a href="#" data-toggle="modal" data-target="#myModal">SIGN
								UP</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</div>
	</nav>
 
<c:choose>
<c:when test="${fn:length(list)>0}">
<div id="background"><br>
 <br><br>
<h2 align="center">Flight Details</h2>
<div class ="container">
    <table class="table table-bordered table-hover" id="flightDetails_table">
    <thead>
    <tr>
		<th>FLIGHT NAME</th>
		<th>FROM</th>
		<th>TO </th>
		<th>FLIGHT DATE</th>
		<th>FLIGHT DEPATURE TIME</th>
		<th>FLIGHT ARRIVAL TIME</th>
		<th>Status</th>
	</tr> 
    </thead>
        <c:forEach items="${list}" var="lists">
            <tr>
            	<td style="padding-left: 25px"><input type="radio" name="optradio" id="selectFlight" value='${ lists.flightId }'></td>
            	<td>${ lists.flightno }</td>
                <td>${ lists.originCode }</td>
                <td>${ lists.destinationCode }</td>
                <td>${ lists.flightDate }</td>
                <td>${ lists.depatureTime }</td>
                <td>${ lists.arrivalTime }</td>
                <td>${ lists.status}</td>
              </tr>
        </c:forEach>
    </table>
       <button type="button" class="btn btn-primary" role="button" onclick="history.back()">BACK</button>
       <c:choose>
   			<c:when test="${sessionScope.currentUser != null}">
				<a href="#" class="btn btn-primary" role="button" onclick="javascript:flightSelection();">NEXT</a>		
			</c:when>
	 <c:otherwise>
	 		<input type="submit" class="btn btn-primary" value="NEXT" id="submit" onclick="javascript:checkForRegisteredUser();"> 
	 </c:otherwise>
</c:choose>
       
    </div>
</div> 
</c:when>
   <c:otherwise>
 <div id="noFlight">
	<div class ="container"><br><br><br>
   		<h4 align="center">THERE IS NO FLIGHT ON THIS DATE</h4>
   		<c:choose>
   			<c:when test="${sessionScope.currentUser != null}">
			<a href="Login.jsp" class="btn btn-primary" role="button" style="margin-top:1px;margin-right:100px;">BACK</a>
		</c:when>
	 <c:otherwise>
		<a href="Home.jsp" class="btn btn-primary" role="button" style="margin-top:1px;margin-right:100px;">BACK</a>
	 </c:otherwise>
</c:choose>
	 </div>
 </div>
  </c:otherwise>
 </c:choose>
 <div class="modal fade" id="myModal" role="dialog"
		style="display: none; padding-left: 0px; padding-top: 35px;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#register"
							aria-controls="register" role="tab" data-toggle="tab">Register</a></li>
						<li role="presentation"><a href="#login"
							aria-controls="login" role="tab" data-toggle="tab">Login</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="register">
							<br>

							<form class="form-horizontal" id="register-form"
								name="registerfrm" action="base?module=user&action=registration"
								method="post">
								<div class="form-group">
									<input type="hidden" id="user_id" value="" />
								</div>
								<!-- First Name input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">First
										Name</label>
									<div class="col-md-6">
										<input id="fname" name="fname" type="text"
											placeholder="Enter your First name"
											class="form-control input-md" required="">
									</div>
								</div>

								<!-- Last Name input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="lname">Last
										Name</label>
									<div class="col-md-6">
										<input id="lname" name="lname" type="text"
											placeholder="Enter your Last name"
											class="form-control input-md" required="">
									</div>
								</div>
								<!-- Passport No input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="passportno">Passport
										No</label>
									<div class="col-md-6">
										<input id="passportno" name="passportno" type="text"
											placeholder="Enter your Passport Number"
											class="form-control input-md" required="">
									</div>
								</div>
								<!-- Address input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="address">Address</label>
									<div class="col-md-6">
										<textarea name="address" id="address" class="form-control"
											rows="3" required=""></textarea>
									</div>
								</div>

								<!-- Email Id input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="emailid">Email
										Id</label>
									<div class="col-md-6">
										<input id="emailid" name="emailid" type="text"
											placeholder="Enter your email id"
											class="form-control input-md" required="">
									</div>
								</div>

								<!-- ContactNo input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="contact">Contact
										no.</label>
									<div class="col-md-4">
										<input id="contactno" name="contactno" type="text"
											placeholder="Enter your contact no."
											class="form-control input-md" required="">
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-3 col-md-offset-3">
											<input type="submit" name="register-submit"
												id="register-submit" value="Register"
												class="form-control btn btn-success">
										</div>
										<div class="col-sm-2 col-md-3">
											<input type="reset" value="Cancel"
												class="form-control btn btn-primary" />
										</div>
									</div>
								</div>
							</form>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="login">
							<br>
							<form class="form-horizontal" id="register-form"
								action="base?module=user&action=signup" method="post">

								<!-- Email-Id input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="email">Email
										Id</label>
									<div class="col-md-6">
										<input id="email" name="email" type="text"
											placeholder="Enter your Email Id"
											class="form-control input-md" required="">
									</div>
								</div>

								<!-- Password input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="password">Password</label>
									<div class="col-md-6">
										<input id="password" name="password" type="password"
											placeholder="Enter your Password"
											class="form-control input-md" required="">
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-3 col-md-offset-3">
											<input type="submit" name="login-submit" id="login-submit"
												value="Login" class="form-control btn btn-success">
										</div>
										<div class="col-sm-2 col-md-3">
											<input type="reset" value="Cancel"
												class="form-control btn btn-primary" />
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>