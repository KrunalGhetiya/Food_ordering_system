<%-- 
    Document   : admin_view
    Created on : 05-May-2022, 10:46:25 am
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
    </header>
    <body style="background-color:#ffd6d6">
        <h1>Welcome, Admin!!</h1>
        <h4>This is VIEW ACCOUNTS.</h4>
        
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/Food_Ordering_System" password="app" user="app" var="db"/>
        <sql:query sql="SELECT * FROM APP.CUSTOMER" var="rs" dataSource="${db}"/>
        CUSTOMERS
          
        <c:forEach var="t" items="${rs.rows}">
            <table border="2" width="100%"> 
             <tr>
                <td><c:out value="CUSTOMER_ID ->"/></td>
                <td><c:out value="${t.CUSTOMER_ID}"/></td>
            </tr>
             <tr>
                <td><c:out value="CUSTOMER_NAME ->"/></td>
                <td><c:out value="${t.CUSTOMER_NAME}"/></td>
            </tr>  
            <tr>
                <td><c:out value="CUSTOMER PHONE NO ->"/></td>
                <td><c:out value="${t.PHONE_NO}"/></td>
            </tr>  
            <tr>
                <td><c:out value="CUSTOMER EMAIL ->"/></td>
                <td><c:out value="${t.EMAIL}"/></td>
            </tr>  
            <tr>
                <td><c:out value="CUSTOMER ADDRESS ->"/></td>
                <td><c:out value="${t.CUSTOMER_ADDRESS}"/></td>
            </tr>  
            </table>
            <br/>
        </c:forEach>
        <br/>
        <br/>
        <br/>
        RESTAURANTS
        <sql:query sql="SELECT * FROM APP.RESTAURANT" var="rs2" dataSource="${db}"/>
        <c:forEach var="rt" items="${rs2.rows}">
            <table border="2" width="100%"> 
             <tr>
                <td><c:out value="RESTAURANT_ID ->"/></td>
                <td><c:out value="${rt.RESTAURANT_ID}"/></td>
            </tr>
             <tr>
                <td><c:out value="RESTAURANT_NAME ->"/></td>
                <td><c:out value="${rt.RESTAURANT_NAME}"/></td>
            </tr>  
            <tr>
                <td><c:out value="RESTAURANT PHONE NO ->"/></td>
                <td><c:out value="${rt.PHONE_NO}"/></td>
            </tr>   
            <tr>
                <td><c:out value="CRESTAURANT ADDRESS ->"/></td>
                <td><c:out value="${rt.RESTAURANT_ADDRESS}"/></td>
            </tr>  
            </table>
            <br/>
        </c:forEach>
       
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
