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
background-image: url(img/newmenu.jsp) top center repeat-y;
background-size: 100%; 
}
</style>
</head>
<body BACKGROUND="newmenu.jpg">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="orderFoodItems.do" method="get">
<table align="right" border="5px" width="500" height="50">
 <caption></caption>
 
 
 <tr>
  <th><font size="3" color=blue font face="Comic Sans MS">Vegeterian </th></font>
  <th><font size="3" color=blue font face="Comic Sans MS">Mexican</th></font>
  <th><font size="3" color=blue font face="Comic Sans MS">Chinese</th></font>
  
  
 </tr>
 <tr>
  	<c:forEach items="${list }" var="inner">
 
	 <td>
 		<table>
 		 	<c:forEach items="${inner }" var="food">
 		 	<tr>
 		 	<td> 		 
 		 		<input type="checkbox" value="${food.fslno }" name="foodSl">
 		 	</td>
 		 	<td><font size="3" color=blue font face="Comic Sans MS">${food.foodname}</td></font>&nbsp
 		 	<td><font size="3" color=blue font face="Comic Sans MS">&nbsp${food.foodprice}</td></font>
 		 	</tr>
 		 	
 		
 			</c:forEach>
 		
 		</table>
 	</td>
 	
 	<br>
 	 	</c:forEach>
 	
 	
 </tr>
</table>

<button type="submit" style="margin-bottom: 100px ;margin-left: 1200px"><font size="3" color=blue font face="Comic Sans MS" >Order</button>
</form>
	

</body>
</html>