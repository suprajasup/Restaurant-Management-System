<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="con" class="com.uttara.hotel.CustomerBean" scope="request">
<jsp:setProperty name="con" property="*"/>
</jsp:useBean>


<jsp:forward page="getCustomerDetail.do"></jsp:forward>