<%-- 
    Document   : rest_delete_item
    Created on : 04-May-2022, 11:54:44 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete item</title>
    </head>
    <header>
        <jsp:include page="rest_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           System.out.println("delete"+id);
        %>
        <h1>Welcome, <%= id %>!!</h1>
        TO DELETE FROM MENU
        <form action="rest_items" method="post">
            <input type="hidden" name="operation" value="delete"/>
            <input type="hidden" name="id" value="${id}"/>
            ITEM NAME <input type="text" name="item_name"/>
            <input type="submit" name="submit"/>
        </form>
    </body>
     <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>

