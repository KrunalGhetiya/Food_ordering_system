<%-- 
    Document   : cust_delete_item
    Created on : 05-May-2022, 10:15:47 am
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete item</title>
    </head>
    <header>
        <jsp:include page="cust_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           //System.out.println("delete"+id);
        %>
        <h1>Welcome, <%= id %>!!</h1>
        
        <form action="cust_items" method="post">
            <input type="hidden" name="operation" value="delete"/>
            ENTER ITEM NAME TO DELETE FROM CART <input type="text" name="item_name"/>
            <input type="submit" name="submit"/>
        </form>
    </body>
     <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>

