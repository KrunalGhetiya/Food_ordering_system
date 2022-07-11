<%-- 
    Document   : logout
    Created on : 04-May-2022, 10:53:15 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body style="background-color:#ffd6d6">
        
        <% 
            ServletContext sc = request.getServletContext();
            sc.setAttribute("uid", null);
            sc.setAttribute("type", null);
            sc.setAttribute("LoggedIn", false);
           
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
