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
public class RegisterServ extends HttpServlet {

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
        
        String c_id = request.getParameter("CUSTOMER_ID");
        String c_pass = request.getParameter("PASSWORD");
        String c_cpass = request.getParameter("CONFIRM_PASSWORD");
        String c_name = request.getParameter("CUSTOMER_NAME");
        String c_pno = request.getParameter("PHONE_NO");
        String c_email = request.getParameter("EMAIL");
        String c_addr = request.getParameter("CUSTOMER_ADDRESS");
        
        String r_id = request.getParameter("RESTAURANT_ID");
        String r_pass = request.getParameter("R_PASSWORD");
        String r_cpass = request.getParameter("R_CONFIRM_PASSWORD");
        String r_name = request.getParameter("RESTAURANT_NAME");
        String r_pno = request.getParameter("R_PHONE_NO");
        String r_addr = request.getParameter("RESTAURANT_ADDRESS");
                    
        PrintWriter out = response.getWriter();
        //System.out.println("THIS IS SERV"+type);
        // CUSTOMER REGISTRATION
        if (type.equals("C")){
            //System.out.println("IN C REGISTER\n");
            if ( c_id == "" || c_pass == "" || c_cpass == "" || c_name == "" || c_pno == "" || c_email == "" || c_addr == ""){
                RequestDispatcher rd = request.getRequestDispatcher("register_customer.jsp");
                out.println("<p>FILL ALL DETAILS!</p>");
                rd.include(request, response);
            }
            else{
                
               if (c_pass.equals(c_cpass)){
                   
                   // System.out.println("PASSWORD MATCH\n");
                   
                    String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
                    String driverclass = "org.apache.derby.jdbc.ClientDriver";
                    String db_user = "app";
                    String db_pass = "app";

                    Class.forName(driverclass);
                    Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
                    Statement st1 = con.createStatement();
                    String query1 = "SELECT * FROM APP.LOGIN WHERE LOG_ID='"+c_id+"'";
                    //PreparedStatement pt = con.prepareStatement("SELECT * FROM APP.LOGIN WHERE LOG_ID='?'");
                    //pt.setString(1, id);
                    //ResultSet rs = pt.executeQuery();
                    ResultSet rs = st1.executeQuery(query1);

                    boolean flag = rs.next();
                    //System.out.println(flag);

                    if (flag==false){
                        //System.out.println("NO USER MATCH SO REGISTER\n");
                        
                        Statement st2 = con.createStatement();
                        Statement st3 = con.createStatement();
                        String query2 = "INSERT INTO APP.LOGIN VALUES "+  
                                            "('"+c_id+"','"+c_pass+"','"+type+"')" ;
                        int c1 = st2.executeUpdate(query2);
                        
                        String query3 = "INSERT INTO APP.CUSTOMER VALUES ('"+ c_id +"','"+ c_name +"','"+ c_pno +"','"+ c_email +"','"+ c_addr +"')";
                        int c2 = st3.executeUpdate(query3);
                        
                        //System.out.println("REGISTERED\n");
                        
                        if (c1 == 0 || c2 == 0){
                            RequestDispatcher rd = request.getRequestDispatcher("register_customer.jsp");
                            out.println("<p>USER REGISTRATION FAILED! TRY AGAIN</p>");
                            rd.include(request, response);
                           
                        }
                        else{
                            //System.out.println("REGISTER SUCCESS\n");
                            RequestDispatcher rd = request.getRequestDispatcher("register_customer.jsp");
                            out.println("<p>USER REGISTRATION SUCCESSFUL!</p>");
                            rd.include(request, response);
                            
                            ServletContext sc = request.getServletContext();
                            String type_context = (String) sc.getAttribute("type");
                            //System.out.println(type);
                            
                            if (!type_context.equals("A"))
                            {
                                out.println("<p>CLICK HERE TO <a href='login.jsp'>LOGIN</a></p>");
                            }                            
                        }
                    }
                    else {
                        System.out.println("ALREADY REGISTERED\n");
                        
                        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                        out.println("<p>USER ALREADY REGISTERED!</p>");
                        rd.include(request, response);
                        out.println("<p>CLICK HERE TO <a href='login.jsp'>LOGIN</a></p>");
                    }
                    con.close();
                }
               
               else{
                   System.out.println("PASS NOT MATCH\n");
                   
                RequestDispatcher rd = request.getRequestDispatcher("register_customer.jsp");
                out.println("<p>CONFIRM PASSWORD SHOULD BE SAME AS PASSWORD!</p>");
                rd.include(request, response);
               }
            }
            
        }
        
        if (type.equals("R")){
            //System.out.println("IN C REGISTER\n");
            if ( r_id == "" || r_pass == "" || r_cpass == "" || r_name == "" || r_pno == "" || r_addr == ""){
                RequestDispatcher rd = request.getRequestDispatcher("register_restaurant.jsp");
                out.println("<p>FILL ALL DETAILS!</p>");
                rd.include(request, response);
            }
            else{
                
               if (r_pass.equals(r_cpass)){
                   
                   // System.out.println("PASSWORD MATCH\n");
                   
                    String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
                    String driverclass = "org.apache.derby.jdbc.ClientDriver";
                    String db_user = "app";
                    String db_pass = "app";

                    Class.forName(driverclass);
                    Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
                    Statement r_st1 = con.createStatement();
                    String r_query1 = "SELECT * FROM APP.LOGIN WHERE LOG_ID='"+r_id+"'";
                    //PreparedStatement pt = con.prepareStatement("SELECT * FROM APP.LOGIN WHERE LOG_ID='?'");
                    //pt.setString(1, id);
                    //ResultSet rs = pt.executeQuery();
                    ResultSet rs = r_st1.executeQuery(r_query1);

                    boolean flag = rs.next();
                    //System.out.println(flag);

                    if (flag==false){
                        //System.out.println("NO USER MATCH SO REGISTER\n");
                        
                        Statement r_st2 = con.createStatement();
                        Statement r_st3 = con.createStatement();
                        String query2 = "INSERT INTO APP.LOGIN VALUES "+  
                                            "('"+r_id+"','"+r_pass+"','"+type+"')" ;
                        int r1 = r_st2.executeUpdate(query2);
                        
                        String query3 = "INSERT INTO APP.RESTAURANT VALUES ('"+ r_id +"','"+ r_name +"','"+ r_addr +"','"+ r_pno +"')";
                        int r2 = r_st3.executeUpdate(query3);
                        
                        //System.out.println("REGISTERED\n");
                        
                        if (r1 == 0 || r2 == 0){
                            RequestDispatcher rd = request.getRequestDispatcher("register_restaurant.jsp");
                            rd.include(request, response);
                            out.println("<p>USER REGISTRATION FAILED! TRY AGAIN</p>");
                        }
                        else{
                            //System.out.println("REGISTER SUCCESS\n");
                            RequestDispatcher rd = request.getRequestDispatcher("register_restaurant.jsp");
                            out.println("<p>USER REGISTRATION SUCCESSFUL!</p>");
                            rd.include(request, response);
                            
                            ServletContext sc = request.getServletContext();
                            String type_context = (String) sc.getAttribute("type");
                            //System.out.println(type);
                            
                            if (!type_context.equals("A"))
                            {
                                out.println("<p>CLICK HERE TO <a href='login.jsp'>LOGIN</a></p>");
                            }  
                        }
                    }
                    else {
                        //System.out.println("ALREADY REGISTERED\n");
                        
                        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                        out.println("<p>USER ALREADY REGISTERED!</p>");
                        rd.include(request, response);
                        out.println("<p>CLICK HERE TO <a href='login.jsp'>LOGIN</a></p>");
                    }
                    con.close();
                }
               
               else{
                   //System.out.println("PASS NOT MATCH\n");
                   
                RequestDispatcher rd = request.getRequestDispatcher("register_restaurant.jsp");
                out.println("<p>CONFIRM PASSWORD SHOULD BE SAME AS PASSWORD!</p>");
                rd.include(request, response);
               }
            }
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
            Logger.getLogger(RegisterServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServ.class.getName()).log(Level.SEVERE, null, ex);
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
