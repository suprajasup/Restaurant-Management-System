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
background-image: url(img/table3.jsp) top center repeat-y;
background-size: 100%; 
}
</style>
</head>
<body BACKGROUND="table3.jpg">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

${msg}<br>
<c:if test="${msg==''}">
<table border="5px" width="1000" height="500" >

<tr>
<th><font size="5" color=yellow font face="Comic Sans MS">Available Table List</th></font>
<th><font size="5" color=yellow font face="Comic Sans MS">No of seats</th></font>
<th><font size="5" color=yellow font face="Comic Sans MS">Click the Corresponding Button to Confirm Your Table </th></font>
</tr>
<c:forEach items="${TableList }" var="table">
<tr>
<td align="center"><font size="7" color=deeppink font face="Comic Sans MS">${table.seatno}</td></font>
<td align="center"><font size="7" color=deeppink font face="Comic Sans MS">${table.no_of_seats}</td></font>
<td align="center">
					<form action="confirm.do" method="post">
						<input type="hidden" name="tableSl" value="${table.slno}">		
						<input type="hidden" name="hotelSl" value="${table.hotelSl}">					
									
						<input type="submit" style="font-family: serif; color: deeppink; font-size:x-large; ;"  value="confirm">
					</form>
				</td>
</tr>
</c:forEach>
</table>
</c:if>
<br/><br/>


<a href="Customersup.jsp"><button type="button"><font size="5" color=deeppink font face="Comic Sans MS" >Click here to go Back</a></button></font>

</body>
</html>