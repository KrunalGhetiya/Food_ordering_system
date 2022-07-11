<%-- 
    Document   : rest_add_item
    Created on : 04-May-2022, 11:32:51 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add item</title>
        <style>
            .form-container{
            background: #fff;
            width: 300px;
            height: 250px;
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
    </head>
    <header>
        <jsp:include page="rest_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           System.out.println(id);
        %>
        <h1>Welcome, <%= id %>!!</h1>
        <div class="form-container">
            <h2>TO ADD TO MENU</h2>
            <hr id="indicator">
        <form action="rest_items" method="post">
            <input type="hidden" name="operation" value="add"/>
            <input type="text" name="item_name" placeholder="ITEM NAME"/>
            <input type="text" name="cost" placeholder=""/>
            <input type="submit" name="submit" class="btn"/>
        </form>
        </div>
    </body>
     <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
