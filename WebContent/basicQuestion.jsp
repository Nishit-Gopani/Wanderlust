<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./js/jquery-1.12.3.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/alertify.min.js"></script>
<link rel="stylesheet" href="./js/css/bootstrap.css">
<link rel="stylesheet" href="./js/css/alertify.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Question</title>
<style type="text/css">
#question {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('/WanderlustTravel/images/booking.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    opacity: 0.90;
    filter:alpha(opacity=80);
}
</style>
<script type="text/javascript">
function checkForBlacklistedUser(user_Id) {
	var Ques_1 = document.getElementById("Ques_1").value;
	var Ques_2 = document.getElementById("Ques_2").value;
	var Ques_3 = document.getElementById("Ques_3").value;
	var Ques_4 = document.getElementById("Ques_4").value;
	var Ques_5 = document.getElementById("Ques_5").value;
	var Ques_6 = document.getElementById("Ques_6").value;
	if(Ques_1==="" || Ques_2===""  || Ques_3===""  || Ques_4===""  || Ques_5===""  || Ques_6===""){
		alert("Filled Cannot be Blank");
	}
	else{
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.status==200 && xmlhttp.readyState==4){
			var response = JSON.parse(xmlhttp.responseText);
			if(response.isSuccess===1){
				var response = response.message;
				alert(JSON.stringify(response));
				window.location="AdditionalQuestion.jsp";
			}else if(response.isSuccess===2){
				window.location="payment.jsp";
			}else if(response.isSuccess){
				window.location="payment.jsp";
			}
			else{
				var response = response.message;
				alert(JSON.stringify(response));
				window.location="base?module=user&action=signout";
			}
		}
	};
	xmlhttp.open("get","base?module=blackuser&action=check&user_Id="+user_Id,true);
	xmlhttp.send(null);
}
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
 	<div id="question">
 <br><br><br>
		<h3 align="center">Basic Details</h3>
		<div class="container">
			<form name="basicQues">
			<div class = "form-group">
				<input type="hidden" name="user_Id" id="user_Id" value="${sessionScope.user_Id}" />
			</div>
				<div class="form-group">
					<label for="Question 1">Question 1 : What is your Passport
						Number?</label> <input type="Text" class="form-control" id="Ques_1"
						aria-describedby="Ques_1" placeholder="Answer to Question 1" required="">
				</div>
				<div class="form-group">
					<label for="Question 2">Question 2 : What is your Nationality?
						</label> <input type="Text" class="form-control" id="Ques_2"
						aria-describedby="Ques_2" placeholder="Answer to Question 2" required="">
				</div>
				<div class="form-group">
					<label for="Question 3">Question 3 : Do u have any Physical/Mental disability?
					</label> <input type="Text" class="form-control" id="Ques_3"
						aria-describedby="Ques_3" placeholder="Answer to Question 3" required="">
				</div>
				<div class="form-group">
					<label for="Question 4">Question 4 : Are u Asian/Hispaic/Latino?
					</label><input type="Text" class="form-control" id="Ques_4"
						aria-describedby="Ques_4" placeholder="Answer to Question 4" required="">
				</div>
				<div class="form-group">
					<label for="Question 5">Question 5 : Are u a veteran?</label> 
					<input type="Text" class="form-control" id="Ques_5"
						aria-describedby="Ques_5" placeholder="Answer to Question 5" required="">
				</div>
				
				<div class="form-group">
					<label for="Question 1">Question 6 : Are you carrying physical Cash/Gold with you?</label> 
					<input type="Text" class="form-control" id="Ques_6"
						aria-describedby="Ques_6" placeholder="Answer to Question 6"  required="">
				</div>
			</form>
			<button type="button" class="btn btn-primary" role="button" name="back" onclick="history.back()">BACK</button>
			<a href="#" class="btn btn-success" role="button" onclick="checkForBlacklistedUser(<%=session.getAttribute("userId")%>)">BOOK NOW</a>
		</div>
	</div>
</body>
</html>