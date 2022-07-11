<%-- 
    Document   : admin_update
    Created on : 05-May-2022, 10:45:05 am
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
        <style>
            .form-container{
            background: #fff;
            width: 300px;
            height: 450px;
            position: relative;
            text-align: center;
            padding: 20px 0;
            margin: auto;
            margin-top:40px;
            box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.1);
/*            overflow: hidden;*/
            }

            .form-btn{
                display: inline-block;
            }
            .form-container form{
                max-width: 300px;
                padding: 0 20px;
                position: absolute;
                top: 50px;
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
                width: 80%;
                border: none;
                cursor: pointer;
                margin: 10px 0;
            }
        </style>
    </head>
     <header>
        <jsp:include page="admin_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        
        <h1>Welcome, Admin!!</h1>
        <h4>This is UPDATE DETAILS.</h4>
        <div class="form-container">
       <form action="AUpdateServ" method="post">
         TYPE OF ACCOUNT   <input type="radio"  name="type" value="C"/> Customer
                <input type="radio"  name="type" value="R"/> Restaurant
                    <br/>
                    <input type="text" name="id" placeholder="ENTER ACCOUNT ID"/>
                    <input type="text" name="name"placeholder="NEW NAME"/>
                    <input type="text" name="pno" placeholder="NEW PHONE NO"/>
                    <input type="text" name="addr" placeholder="NEW ADDRESS"/>
         
         <input type="submit" name="submit" class="btn"/>
       </form>
        </div>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
