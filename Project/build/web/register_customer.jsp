<%-- 
    Document   : register_customer
    Created on : 04-May-2022, 8:15:49 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Registration</title>
    </head>
    <% 
        ServletContext sc = request.getServletContext();
        String type = (String) sc.getAttribute("type");
        System.out.println(type);
    %>
    <c:if test="${type.equals('A')}">
        <style>
            .form-container{
            background: #fff;
            width: 300px;
            height: 450px;
            position: relative;
            text-align: center;
            padding: 20px 0;
            margin: auto;
            margin-top:50px;
            box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.1);
            }

            .form-btn{
                display: inline-block;
            }
            .form-container form{
                max-width: 300px;
                padding: 0 20px;
                position: absolute;
                top: 100px;
                transition: transform 1s;
            }
            form input{
                width: 80%;
                height: 25px;
                margin: 10px 0;
                padding: 0 10px;
                border: 1px solid #ccc;
            }
            .btn{
                display: inline-block;
                background: #ff523b;
                color: #fff;
                padding: 8px 30px;
                margin: 30px 0;
                border-radius: 30px;
            }
            form .btn{
                width: 100%;
                border: none;
                cursor: pointer;
                margin: 10px 0;
            }

            #indicator{
            width: 150px;
            border: none;
            background: #ff523b;
            height: 3px;
            margin-top: 5px;
            }
        </style>
        <header>
        <jsp:include page="admin_header.html"/>
        </header>
    </c:if>
    <body style="background-color:#ffd6d6">
        <div class ="form-container">
        <h2>Customer Registration</h2>
        <hr id="indicator">
        <form method="post" action="RegisterServ">
            <input type="hidden" name="type" value="C">
            <input type="text" name="CUSTOMER_ID" placeholder="CUSTOMER ID">
            <input type="password" name="PASSWORD" placeholder="PASSWORD">
            <input type="password" name="CONFIRM_PASSWORD" placeholder="CONFIRM PASSWORD">
            <input type="text" name="CUSTOMER_NAME" placeholder="CUSTOMER NAME">
            <input type="text" name="PHONE_NO" placeholder="PHONE NUMBER">
            <input type="text" name="EMAIL" placeholder="EMAIL">
            <input type="text" name="CUSTOMER_ADDRESS" placeholder="CUSTOMER ADDRESS">
            <input class = "btn"type="submit" name="submit">
        </form>
        </div>
    </body>
</html>
