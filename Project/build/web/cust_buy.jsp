<%-- 
    Document   : cust_buy
    Created on : 05-May-2022, 9:56:58 am
    Author     : hetshah
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy item</title>
    </head>
    <header>
        <jsp:include page="cust_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
            String id = (String) sc.getAttribute("uid");
            //System.out.println("Home"+id);
        %>
        <h1>Welcome, <%= id %>!!</h1>
        MENU ITEMS AVAILABLE
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/Food_Ordering_System" password="app" user="app" var="db"/>
        <sql:query var='rs' dataSource='${db}'>
            SELECT * FROM APP.MENU
        </sql:query>
        
        
        <c:forEach var="t" items="${rs.rows}">
            <table border="2" width="100%">   
            <tr>
                <td><c:out value="RESTAURANT_ID ->"/></td>
                <td><c:out value="${t.RESTAURANT_ID}"/></td>
            </tr>
             <tr>
                <td><c:out value="ITEM_NAME ->"/></td>
                <td><c:out value="${t.ITEM_NAME}"/></td>
            </tr>
             <tr>
                <td><c:out value="ITEM_COST ->"/></td>
                <td><c:out value="${t.ITEM_COST}"/></td>
            </tr>  
            </table>
            <br/>
        </c:forEach>
        
            
        <br/>
        
        <form action="cust_items" method="post">
            <input type="hidden" name="operation" value="add"/>
            ENTER ITEM NAME TO BUY <input type="text" name="item_name"/>
            <input type="submit" name="submit"/>
        </form>
    </body>
     <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>