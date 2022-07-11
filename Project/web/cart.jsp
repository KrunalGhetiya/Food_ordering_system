<%-- 
    Document   : cart.jsp
    Created on : 05-May-2022, 10:33:05 am
    Author     : hetshah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
           //System.out.println("orders"+id);
           String query1="SELECT * FROM APP.ORDER_DETAIL WHERE CUSTOMER_ID='"+id+"'";
           //System.out.println(query1);
           Integer.parseInt("2");
           
        %>
        <h1>Welcome, <%= id %>!!</h1>
        
        <h3>YOUR ORDERS:-</h3>
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/Food_Ordering_System" password="app" user="app" var="db"/>
        <sql:query sql='<%= query1 %>' var="rs" dataSource="${db}"/>
        
        <c:set var="total_cost" value="${0}" />
        
        <c:forEach var="t" items="${rs.rows}">
            <table border="2" width="100%">  
             <tr>
                <td><c:out value="ORDER_ID ->"/></td>
                <td><c:out value="${t.ORDER_ID}"/></td>
            </tr>
             <tr>
                <td><c:out value="RESTAURANT_ID ->"/></td>
                <td><c:out value="${t.RESTAURANT_ID}"/></td>
            </tr>  
            <tr>
                <td><c:out value="ITEM NAME ->"/></td>
                <td><c:out value="${t.ITEM_NAME}"/></td>
            </tr>  
            <tr>
                <td><c:out value="ITEM COST ->"/></td>
                <td><c:out value="${t.ITEM_COST}"/></td>
                <fmt:parseNumber var = "x" type = "number" value = "${t.ITEM_COST}" />
                <c:set var="total_cost" value="${total_cost + x}" />
            </tr> 
            </table>
            <br/>
        </c:forEach>
        TOTAL COST => <c:out value="${total_cost}"/>
        
    </body>
     <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>