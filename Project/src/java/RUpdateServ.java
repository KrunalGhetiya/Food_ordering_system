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
public class RUpdateServ extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext sc = request.getServletContext();
        String r_id = (String) sc.getAttribute("uid");
        
        //String r_id = request.getParameter("RESTAURANT_ID");
        String r_name = request.getParameter("RESTAURANT_NAME");
        String r_pno = request.getParameter("R_PHONE_NO");
        String r_addr = request.getParameter("RESTAURANT_ADDRESS");
              
        
        PrintWriter out = response.getWriter();
        
       
        if ( r_name == "" || r_pno == "" || r_addr == ""){
            RequestDispatcher rd = request.getRequestDispatcher("restaurant_update.jsp");
            out.println("<p>FILL ALL DETAILS!</p>");
            rd.include(request, response);
        }
        else{
            System.out.println(r_id + " " + r_name + " " + r_pno + " " + r_addr);
            
            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";

            Class.forName(driverclass);
            Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement r_st1 = con.createStatement();
            String r_query1 = "UPDATE APP.RESTAURANT SET RESTAURANT_NAME='"+r_name+"', RESTAURANT_ADDRESS='"+r_addr+"', PHONE_NO='"+r_pno+"' WHERE RESTAURANT_ID='"+r_id+"'";
            //PreparedStatement pt = con.prepareStatement("SELECT * FROM APP.LOGIN WHERE LOG_ID='?'");
            //pt.setString(1, id);
            //ResultSet rs = pt.executeQuery();
            int c = r_st1.executeUpdate(r_query1);
            
            if (c == 1){
                RequestDispatcher rd = request.getRequestDispatcher("restaurant_update.jsp");
                rd.include(request, response);
                out.println("<p>USER UPDATED!</p>");
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("restaurant_update.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(RUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(RUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RUpdateServ.class.getName()).log(Level.SEVERE, null, ex);
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
