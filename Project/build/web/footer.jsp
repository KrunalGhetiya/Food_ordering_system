<%-- 
    Document   : footer
    Created on : 04-May-2022, 10:50:43 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .btn1{
                display: inline-block;background: #ff523b;
                color: #fff;
                padding: 8px 30px;
                margin: 30px 0;
                border-radius: 30px;
                border: none;
                margin-left: 300px;
            }
        </style>
    </head>
    <body style="background-color:#ffd6d6">
        <form action="logout.jsp" method="post">
            <button class="btn1">logout</button>
            <%--<input type="submit" name="logout" value="logout" class="btn1"/> --%>
        </form>
    </body>
</html>
