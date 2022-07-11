<%-- 
    Document   : login
    Created on : 04-May-2022, 2:33:23 pm
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body style="background-color:#ffd6d6">
    <center>
        <div style="margin-top: 300px">
        <form method="post" action="LoginServ">
            TYPE    <input type="radio"  name="type" value="A"/> Admin 
                    <input type="radio"  name="type" value="C"/> Customer
                    <input type="radio"  name="type" value="R"/> Restaurant
                    <br/>
                    <br>
                    <input type="text" name="id" placeholder="USER ID"><br/>
                    <br>
                    <input type="password" name="pass" placeholder="PASSWORD"><br/>
                    
                    <input type="submit" name="submit" style="display: inline-block;background: #ff523b;color: #fff;padding: 8px 30px;margin: 30px 0;border-radius: 30px;border: none;">
        </form>
        </div>
    </center>
    </body>
</html>
