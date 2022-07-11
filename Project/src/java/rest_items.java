/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hetshah
 */
public class rest_items extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext sc = request.getServletContext();
        String id = (String) sc.getAttribute("uid");
        
        String operation = request.getParameter("operation");
        //String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        
        String item_name = request.getParameter("item_name");
        String item_cost = request.getParameter("cost");
        
        String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
        String driverclass = "org.apache.derby.jdbc.ClientDriver";
        String db_user = "app";
        String db_pass = "app";

        Class.forName(driverclass);
        Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
        Statement st = con.createStatement(); 
        String query = "SELECT * FROM APP.MENU WHERE RESTAURANT_ID='"+id+"' AND ITEM_NAME='"+item_name+"'";
        ResultSet rs = st.executeQuery(query);
        boolean flag = rs.next();
        //System.out.println(flag);
        if (!flag && operation.equals("add")){
        
            Statement st2 = con.createStatement(); 
            String query2 = "INSERT INTO APP.MENU VALUES ('"+id+"','"+item_name+"','"+item_cost+"')";
            int c1 = st2.executeUpdate(query2);
            if (c1 == 1)
            {
                RequestDispatcher rd = request.getRequestDispatcher("rest_add_item.jsp");
                out.println("<p>Item Added</p>");
                rd.include(request, response);
            }
        }
        else if (operation.equals("add")){
            RequestDispatcher rd = request.getRequestDispatcher("rest_add_item.jsp");
            out.println("<p>Item Already present!</p>");
            rd.include(request, response);
        }
        
        if (flag && operation.equals("delete")){
        
            Statement st3 = con.createStatement(); 
            String query3 = "DELETE FROM APP.MENU WHERE RESTAURANT_ID='"+id+"' AND ITEM_NAME='"+item_name+"'";
            int c2 = st3.executeUpdate(query3);
            if (c2 == 1)
            {
                RequestDispatcher rd = request.getRequestDispatcher("rest_delete_item.jsp");
                out.println("<p>Item Deleted</p>");
                rd.include(request, response);
            }
        }
        else if (operation.equals("delete")){
            RequestDispatcher rd = request.getRequestDispatcher("rest_delete_item.jsp");
            out.println("<p>Item not present!</p>");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rest_items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(rest_items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rest_items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(rest_items.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
