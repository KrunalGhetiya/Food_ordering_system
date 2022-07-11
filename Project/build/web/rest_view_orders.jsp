<%-- 
    Document   : rest_view_orders
    Created on : 05-May-2022, 12:12:43 am
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIEW ORDERS</title>
    </head>
    <header>
        <jsp:include page="rest_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           //System.out.println("orders"+id);
           String query1 = "SELECT * FROM APP.ORDER_DETAIL WHERE RESTAURANT_ID='"+id+"'";
        %>
        <h1>Welcome, <%= id %>!!</h1>
        ORDERS
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/Food_Ordering_System" password="app" user="app" var="db"/>
        <sql:query sql='<%= query1 %>' var="rs" dataSource="${db}"/>
        
        <table border="2" width="100%">   
        <c:forEach var="t" items="${rs.rows}">
             <tr>
                <td><c:out value="ORDER_ID ->"/></td>
                <td><c:out value="${t.ORDER_ID}"/></td>
            </tr>
             <tr>
                <td><c:out value="CUSTOMER_ID ->"/></td>
                <td><c:out value="${t.CUSTOMER_ID}"/></td>
            </tr>
            <tr>
                <td><c:out value="ITEM_NAME ->"/></td>
                <td><c:out value="${t.ITEM_NAME}"/></td>
            </tr>    
            <tr>
                <td><c:out value="ITEM_COST ->"/></td>
                <td><c:out value="${t.ITEM_COST}"/></td>
            </tr>    
        </c:forEach>
        </table>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>