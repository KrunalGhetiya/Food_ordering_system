<%-- 
    Document   : customer_update
    Created on : 05-May-2022, 9:40:16 am
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
        <title>Update</title>
    </head>
    <header>
        <jsp:include page="cust_header.html"/>
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
            String query = "SELECT * FROM APP.CUSTOMER WHERE CUSTOMER_ID='"+id+"'";
            ResultSet rs = st.executeQuery(query);
            boolean flag = rs.next();

            String ct_id = rs.getString("CUSTOMER_ID");
            String ct_name = rs.getString("CUSTOMER_NAME");
            String ct_pno = rs.getString("PHONE_NO");
            String ct_email = rs.getString("EMAIL");
            String ct_addr = rs.getString("CUSTOMER_ADDRESS");
            //System.out.println(ct_id+ct_name+ct_pno+ct_email+ct_addr);
            con.close();
        %>
        <h1>Welcome!!, <%= id %></h1>
        
        
        <table border="2" width="100%">   
             <tr>
                <td><c:out value="CUSTOMER_ID ->"/></td>
                <td><%= ct_id %></td>
            </tr>
             <tr>
                <td><c:out value="CUSTOMER_NAME ->"/></td>
                <td><%= ct_name %></td>
            </tr>  
            <tr>
                <td><c:out value="PHONE_NO ->"/></td>
                <td><%= ct_pno %></td>
            </tr>
             <tr>
                <td><c:out value="EMAIL ->"/></td>
                <td><%= ct_email %></td>
            </tr>  
            <tr>
                <td><c:out value="ADDRESS ->"/></td>
                <td><%= ct_addr %></td>
            </tr>  
        </table>
            
            <form action='CUpdateServ' method="post">
                
                CUSTOMER NAME <input type="text" name="CUSTOMER_NAME">
                PHONE NUMBER <input type="text" name="PHONE_NO">
                EMAIL <input type="text" name="EMAIL">
                CUSTOMER ADDRESS <input type="text" name="CUSTOMER_ADDRESS">
                <input type="submit" name="submit">
            </form> 
         
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
