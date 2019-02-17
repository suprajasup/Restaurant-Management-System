<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body=
{
background-image: url(img/newrate.jsp) top center repeat-y;
background-size: 100%; 
}
</style>

</head>
<body BACKGROUND="newrate.jpg">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="submitFeedback.do" method="post">


<b><font size="5" color=deeppink font face="Comic Sans MS">Total Price is</b>&nbsp${totalPrice}<br/><br/><br/></font>




<b><font size="5" color=deeppink font face="Comic Sans MS" style="margin-left: 300px">Rate Between 1-5</b></font>
<input type="number" name="rating" min='0'; max='5'; step=".01" required="true";>
<button type="submit"  ><font size="3" color=deeppink font face="Comic Sans MS" >Click</font></button>
</form>
</body>
</html>