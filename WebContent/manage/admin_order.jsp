<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="admin_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<c:forEach var="c" items="${clist }">
                        	<tr>
                        		<td>${c.cart_id}</td>
                        		
                        			${c.cart_p_name}
                        		
                        		</td>
                        		<td>
                        			
                        			
                        		</td>
                        	</tr>
	                    </c:forEach>
</body>
</html>