<%-- 
    Document   : admin_create
    Created on : 05-May-2022, 10:46:16 am
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
     <header>
        <jsp:include page="admin_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <h1>Welcome, Admin!!</h1>
        <h4>This is CREATE ACCOUNTS.</h4>
        <jsp:include page="register.jsp"/>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>