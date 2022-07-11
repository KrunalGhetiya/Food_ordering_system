/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hetshah
 */
public class LoginServ extends HttpServlet {

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
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
        
        if (type == "" || id == "" || pass == ""){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request, response);
            out.println("<p>FILL ALL DETAILS!</p>");
        }
        else {
        
            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";
            
            Class.forName(driverclass);
            Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement st = con.createStatement();
            String query = "SELECT * FROM APP.LOGIN WHERE LOG_ID='"+id+"'";
            //PreparedStatement pt = con.prepareStatement("SELECT * FROM APP.LOGIN WHERE LOG_ID='?'");
            //pt.setString(1, id);
            //ResultSet rs = pt.executeQuery();
            ResultSet rs = st.executeQuery(query);
            
            boolean flag = rs.next();
            //System.out.println(flag);
            
            if (flag==false){
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
                out.println("<p>NO SUCH USER FOUND</p>");
                out.println("<p>CLICK HERE TO <a href='register.jsp'>REGISTER</a></p>");
            }
            else{
                String validate_type = rs.getString("TYPE");
                String validate_pass = rs.getString("PASSWORD");
                
                if (validate_pass.equals(pass) && validate_type.equals(type))
                {
                    ServletContext sc = request.getServletContext();
                    sc.setAttribute(pass, out);
                    sc.setAttribute("uid", id);
                    sc.setAttribute("type", type);
                    sc.setAttribute("LoggedIn", true);
                    
                    if (type.equals("A"))
                    {
                        RequestDispatcher req = request.getRequestDispatcher("admin_dashboard.jsp");
			req.forward(request, response);
                    }
			
                    else if (type.equals("C"))
                    {
                        RequestDispatcher req = request.getRequestDispatcher("customer_dashboard.jsp");
			req.forward(request, response);
                    }
                    
                    else if (type.equals("R"))
                    {
                        RequestDispatcher req = request.getRequestDispatcher("restaurant_dashboard.jsp");
			req.forward(request, response);
                    }
                    
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.include(request, response);
                    out.println("<p>INCORRECT PASSWORD OR TYPE... TRY AGAIN</p>");
                }
            con.close();
                //System.out.println("IN HERE SUCESS");
                //RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                //rd.include(request, response);
                //out.println("<p>"+rs.getString("LOG_ID")+"</p>");
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
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
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
