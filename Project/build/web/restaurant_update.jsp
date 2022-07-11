<%-- 
    Document   : restaurant_update
    Created on : 05-May-2022, 9:02:45 am
    Author     : hetshah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <header>
        <jsp:include page="rest_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
            ServletContext sc = request.getServletContext();
            String id = (String) sc.getAttribute("uid");
            System.out.println("Home"+id);

            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";

            Class.forName(driverclass);
            Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement st = con.createStatement();
            String query = "SELECT * FROM APP.RESTAURANT WHERE RESTAURANT_ID='"+id+"'";
            ResultSet rs = st.executeQuery(query);
            boolean flag = rs.next();
            
            String rt_id = rs.getString("RESTAURANT_ID");
            String rt_name = rs.getString("RESTAURANT_NAME");
            String rt_pno = rs.getString("PHONE_NO");
            String rt_addr = rs.getString("RESTAURANT_ADDRESS");
            
            con.close();
        %>
        <h1>Welcome!!, <%= id %></h1>
     
        <table border="2" width="100%">   
             <tr>
                <td><c:out value="RESTAURANT_ID ->"/></td>
                <td><%= rt_id %></td>
            </tr>
             <tr>
                <td><c:out value="RESTAURANT_NAME ->"/></td>
                <td><%= rt_name %></td>
            </tr>  
            <tr>
                <td><c:out value="PHONE_NO ->"/></td>
                <td><%= rt_pno %></td>
            </tr>  
            <tr>
                <td><c:out value="ADDRESS ->"/></td>
                <td><%= rt_addr %></td>
            </tr>  
        </table>
            <br/>
            <form action='RUpdateServ' method="post">
                RESTAURANT NAME <input type="text" name="RESTAURANT_NAME">
                PHONE NUMBER <input type="text" name="R_PHONE_NO">
                RESTAURANT ADDRESS <input type="text" name="RESTAURANT_ADDRESS">
                <input type="submit" name="submit">
            </form>
              
                
        
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>