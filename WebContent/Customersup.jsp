<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

document.forms["form1"]["uname"]=	localStorage.getItem("uname",uname);

function validate() 
{
	var x=document.forms["form1"];
	
	var uname=x["uname"].value;
	if(uname.length()>5)
		{
			alert(" name is mandatory");
			return false;
		}
	localStorage.setItem("uname",uname);
	return false;
	
}

</script>
<style type="text/css">
body=
{
background-image: url(img/custf1.jsp) top center repeat-y;
background-size: 50%; 
}
</style>

</head>
<body BACKGROUND="custf1.png">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="Customerinitsup.jsp" name ="form1" onsubmit="validate()">
<b><font size="8" color=darkslateblue  font face="Times New Roman " style="font-weight: bolder; margin-left: 300px"></b><br/></font>
<b><font size="5" color=deeppink font face="Comic Sans MS" style="font-weight: bolder"; >Enter Your Name : </b><input type="text" name="uname" value="${custBean.uname}" required="true" /></font><br/><br/>
<b><font size="5" color=deeppink font face="Comic Sans MS" style="font-weight: bolder";>Enter Your Contact Number : </b><input name="number" value="${custBean.number}" maxlength="10" required="true"/></font><br/><br/>
<b><font size="5" color=deeppink font face="Comic Sans MS" style="font-weight: bolder";>Enter Your Address : </b><input type="text" width="100" height="200" name="address" value="${custBean.address}" required="true"/></font><br/><br/>
<b><font size="5" color=deeppink font face="Comic Sans MS" style="font-weight: bolder";>Select a Restaurant</font> </b></b><br/><br/><br/>

 <table border="5px"bordercolor="black" valign="top">
 
<tr><th><font size="5" color=yellow font face="Comic Sans MS">Select</font></th><th><font size="5" color=yellow font face="Comic Sans MS" style="font-weight: bolder";>Restaurant </font> </th><th><font size="5" color=yellow font face="Comic Sans MS" style="font-weight: bolder";> Rating</font></th></tr>
<c:forEach var="list" items="${HotelList}">
<tr><td><input type="radio" name="hotelSl" value="${list.slno}"></td><td><font size="4" color=blue font face="Comic Sans MS" style="font-weight: bolder";>${list.restaurant_name }</font></td><td><font size="4" color=blue font face="Comic Sans MS" style="font-weight: bolder";>${list.rating}</td></tr>
</c:forEach>

</table><br/>

<input type="submit" value="GO" name="SUCCESS"><br/>
</form>
${errormsg}
</body>
</html>