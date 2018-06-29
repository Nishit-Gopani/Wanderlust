<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./js/jquery-1.12.3.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/alertify.min.js"></script>
<link rel="stylesheet" href="./js/css/bootstrap.css">
<link rel="stylesheet" href="./js/css/alertify.min.css">
<title>Additional Details</title>
<style type="text/css">
#Addquestion {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('/WanderlustTravel/images/Additional.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    opacity: 0.90;
    filter:alpha(opacity=80);
}
label {
color:white;
font-style: italic;
font-size: 17px;
}

</style>
<script type="text/javascript">
function paymentDetails(user_Id) {
	alert("Redirecting to Payment Information");
	window.location="payment.jsp";
}
</script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#myPage">Wanderlust Airways</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${sessionScope.currentUser != null}">
				<li><a href="Login.jsp">HOME</a></li>
				</c:if>
        <li><a href="base?module=home&action=view#managebooking">MANAGE BOOKING</a></li>
        <li><a href="./Login.jsp#contact">CONTACT US</a></li>
        <li><a href="./Login.jsp#aboutus">ABOUT US</a></li>
        <c:choose>
   			<c:when test="${sessionScope.currentUser != null}">
	<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li>
          <a href="#"><%
      	if(session.getAttribute("currentUser")!=null){
    	  out.println(session.getAttribute("currentUser"));
    	  }
    	%></a>
    	</li>
		<li><a href="#" data-toggle="modal" data-target="#editprofile">Edit Profile</a></li>
		<li><a href="base?module=user&action=signout"><span class="glyphicon glyphicon-log-out"></span> Sign out</a></li>          
	    </ul>
      </li>		
      </c:when>
	 <c:otherwise>
<li><a href="#" data-toggle="modal" data-target="#myModal">SIGN
						UP</a></li>	 </c:otherwise>
	</c:choose>
        
  </ul>
		</div>
      </div>
 </nav>
	<div id="Addquestion">
		<div class="container">
		<h3 align="center">Additional Details</h3><br>
			<form name="Additional" id="additionalQues" style="margin-left:45px">
				 <div class="form-group">
				 	<label>Question 1: Have you ever been convicted of a felony?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio" id="que_1y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio" id="que_1n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 2: Have you ever been arrested for any crime, even though subject of a pardon, amnesty?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio1" id="que_2y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio1" id="que_2n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 3: Have you ever travel outside the states?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio2" id="que_3y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio2" id="que_3n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 4: Have you ever been refused a visa for other country?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio3" id="que_4y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio3" id="que_4n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 5: Are you member or representative of terrorist organization</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio4" id="que_5y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio4" id="que_5n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 6: Have you ever or do you provide financial assistance to any terrorist organization?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio5" id="que_6y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio5" id="que_6n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 7: Are you or have you ever been a drug user or addict?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio6" id="que_7y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio6" id="que_7n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 8: Have you ever been involved in, or do you seek to engage in money laundering?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio7" id="que_8y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio7" id="que_8n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 9: Have you ever assisted or committed genocide?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio8" id="que_9y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio8" id="que_9n">NO</label>
				 </div>	
				 <div class="form-group">
				 	<label>Question 10: Do you have communicable disease of public health significance such as tuberculosis?</label>&nbsp;&nbsp;
				 	<label class="radio-inline"><input type="radio" name="optradio9" id="que_10y">YES</label>
				 	<label class="radio-inline"><input type="radio" name="optradio9" id="que_10n">NO</label>
				 </div>					
			</form>
			<button type="button" class="btn btn-primary" role="button" name="back" onclick="history.back()" style="margin-left:40px;">BACK</button>
			<a href="#" class="btn btn-success" role="button" onclick="javascript:paymentDetails(<%=session.getAttribute("userId")%>);">BOOK NOW</a>
		</div>
	</div>
</body>
</html>