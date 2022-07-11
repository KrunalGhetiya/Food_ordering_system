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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class cust_items extends HttpServlet {

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
        //tring id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        
        String item_name = request.getParameter("item_name");
        
        
        //System.out.println(flag);
        if (operation.equals("add")){
            
            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";

            Class.forName(driverclass);
            Connection con = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement st = con.createStatement(); 
            String query = "SELECT * FROM APP.MENU WHERE ITEM_NAME='"+item_name+"'";
            ResultSet rs = st.executeQuery(query);
            boolean flag = rs.next();
            
            if (flag){
                Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String o_id = dateFormat.format(date);  

                String r_id = rs.getString("RESTAURANT_ID");
                String item_cost = rs.getString("ITEM_COST");

                Statement st2 = con.createStatement(); 
                String query2 = "INSERT INTO APP.ORDER_DETAIL VALUES ('"+o_id+"','"+r_id +"','"+ id +"','"+item_name+"','"+item_cost+"')";
                int c1 = st2.executeUpdate(query2);

                if (c1 == 1)
                {
                    RequestDispatcher rd = request.getRequestDispatcher("cust_buy.jsp");
                    out.println("<p>Item Added to Cart!</p>");
                    rd.include(request, response);
                }
            }
            else{
                 RequestDispatcher rd = request.getRequestDispatcher("cust_buy.jsp");
                out.println("<p>No such Item present!</p>");
                rd.include(request, response);
            }
            con.close();  
        }
        
        
        
        if (operation.equals("delete")){
            
            String jdbcurl = "jdbc:derby://localhost:1527/Food_Ordering_System";
            String driverclass = "org.apache.derby.jdbc.ClientDriver";
            String db_user = "app";
            String db_pass = "app";
            
            Class.forName(driverclass);
            Connection con2 = DriverManager.getConnection(jdbcurl, db_user, db_pass);
            Statement st_1 = con2.createStatement(); 
            String query_1 = "SELECT * FROM APP.ORDER_DETAIL WHERE ITEM_NAME='"+item_name+"' AND CUSTOMER_ID='"+id+"'";
            ResultSet rs_1 = st_1.executeQuery(query_1);
            boolean flag_1 = rs_1.next();
            System.out.println("delete flag2 ->"+flag_1);
                    
            if (flag_1){
            Statement st3 = con2.createStatement(); 
            String query3 = "DELETE FROM APP.ORDER_DETAIL WHERE CUSTOMER_ID='"+id+"' AND ITEM_NAME='"+item_name+"'";
            int c2 = st3.executeUpdate(query3);
                System.out.println("delete -> value "+c2);
            if (c2 > 0)
            {
                RequestDispatcher rd = request.getRequestDispatcher("cust_delete_item.jsp");
                out.println("<p>Item Deleted from cart!</p>");
                rd.include(request, response);
            }
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("cust_delete_item.jsp");
                out.println("<p>Item not present in cart!</p>");
                rd.include(request, response);
            }
            con2.close();
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
            Logger.getLogger(cust_items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cust_items.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cust_items.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cust_items.class.getName()).log(Level.SEVERE, null, ex);
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
