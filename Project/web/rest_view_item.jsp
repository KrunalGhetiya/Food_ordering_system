<%-- 
    Document   : rest_view_item
    Created on : 05-May-2022, 12:09:05 am
    Author     : hetshah
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIEW MENU</title>
    </head>
    <header>
        <jsp:include page="rest_header.html"/>
    </header>
    <body style="background-color:#ffd6d6">
        <% 
           ServletContext sc = request.getServletContext();
           String id = (String) sc.getAttribute("uid");
           //System.out.println("view"+id);
           String query1 = "SELECT * FROM APP.MENU WHERE RESTAURANT_ID='"+id+"'";
        %>
        <h1>Welcome, <%= id %>!!</h1>
        MENU
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/Food_Ordering_System" password="app" user="app" var="db"/>
        <sql:query sql='<%= query1 %>' var="rs" dataSource="${db}"/>
        <br/><br/><br/>
        <table border="2" width="100%">   
        <c:forEach var="t" items="${rs.rows}">
             <tr>
                <td><c:out value="ITEM NAME ->"/></td>
                <td><c:out value="${t.ITEM_NAME}"/></td>
            </tr>
             <tr>
                <td><c:out value="COST ->"/></td>
                <td><c:out value="${t.ITEM_COST}"/></td>
            </tr>  
            
        </c:forEach>
        </table>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>