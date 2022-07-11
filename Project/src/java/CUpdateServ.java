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
public class CUpdateServ extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext sc = request.getServletContext();
        String c_id = (String) sc.getAttribute("uid");
        //System.out.println("Home"+id);
        
        //String c_id = request.getParameter("CUSTOMER_ID");
        String c_name = request.getParameter("CUSTOMER_NAME");
        String c_email = request.getParameter("EMAIL");
        String c_pno = request.getParameter("PHONE_NO");
        String c_addr = request.getParameter("CUSTOMER_ADDRESS");
              
        
        PrintWriter out = response.getWriter();
        
       
        if ( c_name == "" || c_pno == "" || c_addr == "" || c_email ==""){
            RequestDispatcher rd = request.getRequestDispatcher("customer_update.jsp");
            out.println("<p>FILL ALL DETAILS!</p>");
            rd.include(request, response);
        }
        else{
            System.out.println(c_id + " " + c_name + " " + c_pno + " " + c_addr + " " + c_email);
            
            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";

            Class.forName(driverclass);
            Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement c_st1 = con.createStatement();
            String c_query1 = "UPDATE APP.CUSTOMER SET CUSTOMER_NAME='"+c_name+"', PHONE_NO='"+c_pno+"', EMAIL='"+c_email+"', CUSTOMER_ADDRESS='"+c_addr+"'  WHERE CUSTOMER_ID='"+c_id+"'";
            //PreparedStatement pt = con.prepareStatement("SELECT * FROM APP.LOGIN WHERE LOG_ID='?'");
            //pt.setString(1, id);
            //ResultSet rs = pt.executeQuery();
            int c = c_st1.executeUpdate(c_query1);
            
            if (c == 1){
                RequestDispatcher rd = request.getRequestDispatcher("customer_update.jsp");
                rd.include(request, response);
                out.println("<p>USER UPDATED!</p>");
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("customer_update.jsp");
                rd.include(request, response);
                out.println("<p>UPDATION FAILED!</p>");
            }
            con.close();              
   
            
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
            Logger.getLogger(CUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
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
