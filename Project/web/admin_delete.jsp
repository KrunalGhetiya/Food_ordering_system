<%-- 
    Document   : admin_delete
    Created on : 05-May-2022, 10:46:39 am
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
        <style>
            .btn{
                display: inline-block;
                background: #ff523b;
                color: #fff;
                padding: 8px 30px;
                margin: 30px 0;
                border-radius: 30px;
                border: none;
            }
        </style>
    </header>
    <body style="background-color:#ffd6d6">
        <h1>Welcome, Admin!!</h1>
        <h4>This is DELETE ACCOUNTS.</h4>
        <form action="ADeleteServ" method="post">
         TYPE OF ACCOUNT   <input type="radio"  name="type" value="C"/> Customer
                <input type="radio"  name="type" value="R"/> Restaurant
                    <br/>
         ENTER ACCOUNT ID <input type="text" name="id"/>
         <input type="submit" name="submit" class="btn"/>
            
        </form>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
