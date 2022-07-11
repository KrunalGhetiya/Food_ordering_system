<%-- 
    Document   : customer_dashboard
    Created on : 04-May-2022, 9:44:56 pm
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
        <jsp:include page="cust_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
         <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           System.out.println("Home"+id);
        %>
        <h1>Welcome!!, <%= id %></h1>
        <h4> You have operations to add items, delete items, view items and orders </h4>
        
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
