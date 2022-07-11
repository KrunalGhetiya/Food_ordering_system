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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hetshah
 */
public class ADeleteServ extends HttpServlet {

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
        
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        
        String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
        String driverclass = "org.apache.derby.jdbc.ClientDriver";
        String db_user = "app";
        String db_pass = "app";

        Class.forName(driverclass);
        Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
        Statement st1 = con.createStatement();
        String query1 = "SELECT * FROM APP.LOGIN WHERE LOG_ID='"+id+"'";
        ResultSet rs = st1.executeQuery(query1);

        boolean flag = rs.next();
        //System.out.println(flag);

        if (flag==true){
            int c2 = 0, c3 = 0;
            if (type.equals("C")){
                Statement st2 = con.createStatement();
                String query2 = "DELETE FROM APP.CUSTOMER WHERE CUSTOMER_ID='"+id+"'";
                c2 = st2.executeUpdate(query2);
            }

            else if (type.equals("R")){
                Statement st3 = con.createStatement();
                String query3 = "DELETE FROM APP.RESTAURANT WHERE RESTAURANT_ID='"+id+"'";
                c3 = st3.executeUpdate(query3);
                
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("admin_delete.jsp");
            out.println("<p>USER DELETION SUCCESSFUL!</p>");
            rd.include(request, response);
            
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("admin_delete.jsp");
            out.println("<p>USER NOT FOUND!</p>");
            rd.include(request, response);
        }
        con.close();
        
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
            Logger.getLogger(ADeleteServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADeleteServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ADeleteServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADeleteServ.class.getName()).log(Level.SEVERE, null, ex);
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
