<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Info</title>
<style type="text/css">
#payment {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('/WanderlustTravel/images/Payment.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    opacity: 0.90;
    filter:alpha(opacity=80);
}
label{
color:#b70e0e;
}

</style>
<script type="text/javascript">
function paymentdetails(user_Id,flight_Id){
	var btnValue=document.getElementById("selection").value;
	var requestUrl="base?module=payment&action=payment";
	var cardholder = document.getElementById("cardholder").value;
	var cardno = document.getElementById("cardno").value;
	var cardtype = document.getElementById("cardtype").value;
	var Cvv = document.getElementById("Cvv").value;
	var doe = document.getElementById("doe").value;
	
	if(cardholder==="" || cardno===""  || cardtype===""  || Cvv===""  || doe===""){
		alert("Filled Cannot be Blank");
	}
	else{
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.status==200 && xmlhttp.readyState==4){
			var response = JSON.parse(xmlhttp.responseText);
			if(response.isSuccess){
				var response = response.message;
				alert(JSON.stringify(response));
				document.forms["payment-form"].reset();
			}else{
				var response = response.message;
				alert(JSON.stringify(response));
			}
		}
	};
	xmlhttp.open("post",requestUrl,true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("user_Id="+ user_Id +"&flight_Id=" + flight_Id + "&cardholder=" + cardholder + "&cardType=" +cardtype);
}
}

</script>
<script src="./js/jquery-1.12.3.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/alertify.min.js"></script>
<link rel="stylesheet" href="./js/css/bootstrap.css">
<link rel="stylesheet" href="./js/css/alertify.min.css">
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
				<c:if test="${sessionScope.currentUser != null}">
					<li><a href="Login.jsp">HOME</a></li>
				</c:if>
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
	<div id="payment">
	<br><br><br>
		<h3 align="center" style="color:#b70e0e;">Payment Details</h3>
		<div class="container">
				<form class="form-horizontal" id="payment-form" method="post" action="payment">

								<!-- Card Holder -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="CardHolder">Card Holder Name:</label>
									<div class="col-md-4">
										<input id="cardholder" name="cardholder" type="text"
											placeholder="Enter your name on Card"
											class="form-control input-md" required="">
									</div>
								</div>

								<!-- Card Number-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Card Number">Card Number:</label>
									<div class="col-md-4">
										<input id="cardno" name="cardno" type="text"
											placeholder="Enter your Card Number"
											class="form-control input-md" required="">
									</div>
								</div>
								
								<!-- Card Type-->
								<div class="form-group">
									<label class="col-md-4 control-label" for=Cardtype>Card Type:</label>
									<div class="col-md-4">
										<input id="cardtype" name="cardtype" type="text"
											placeholder="Card Type Visa/Mastercard"
											class="form-control input-md" required="">
									</div>
								</div>
								
								<!-- CVV -->
								<div class="form-group">
									<label class="col-md-4 control-label" for=Cvv >CVV:</label>
									<div class="col-md-1">
										<input id="Cvv" name="Cvv" type="password"
											placeholder="Cvv"
											class="form-control input-md" required="">
									</div>
								</div>
								<!-- Date  -->
								<div class="form-group">
								<label class="col-md-4 control-label" for=date >Date Of Expiry</label>
									<div class="col-md-2">
										<input id="doe" name="doe" type="text"
											placeholder="Date Of Expiry"
											class="form-control input-md" required="">
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-2 col-md-offset-4">
											<input type="button" id="selection" class="btn btn-primary" value="save" class="form-control btn btn-success" onclick="javascript:paymentdetails(<%=session.getAttribute("userId")%>,<%=session.getAttribute("flight_Id")%>);">
										</div>
										<div class="col-sm-1 col-md-1">
											<input type="reset" value="Cancel"
												class="form-control btn btn-primary" />
										</div>
									</div>
								</div>
							</form>	
		
		</div>
	</div>
</body>
</html>