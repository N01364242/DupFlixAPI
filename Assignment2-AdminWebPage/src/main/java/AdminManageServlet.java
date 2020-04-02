/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminDatabaseService;
import service.AdminDatabaseService_Service;
import service.Dupflix;

/**
 *
 * @author Niya
 */
@WebServlet(urlPatterns = {"/AdminManageServlet"})
public class AdminManageServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminManageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
         AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
            List<Dupflix> dupFlixList = new ArrayList<Dupflix>();
            dupFlixList = port.getAllDupFlixData();
            request.setAttribute("dupFlixList", dupFlixList);
            request.getRequestDispatcher("ManageIndex.jsp").forward(request, response); 
            
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
        PrintWriter out = response.getWriter();
        int postId = Integer.parseInt(request.getParameter("post_id"));
         AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
         if (request.getParameter("DELETE") != null) {
        
            int success = port.deleteDupFlixData(postId);
            if(success==1){
             out.println("<script type=\"text/javascript\">");
             out.println("alert('Deleted Successfully');");
                  out.println("</script>"); 
              request.getRequestDispatcher("ManageIndex.jsp").forward(request, response); 
            }else{
                out.println("<script type=\"text/javascript\">");
             out.println("alert('Some error occured. Please try after sometime.');");
                  out.println("</script>");  
                   request.getRequestDispatcher("ManageIndex.jsp").forward(request, response); 
            }
         }else if (request.getParameter("UPDATE") != null) {
               Dupflix flix = new Dupflix();
      
            flix = port.getDupFlixData(postId);
           
          
            request.setAttribute("dupFlix", flix);
            
            request.getRequestDispatcher("AdminUpdateIndex.jsp").forward(request, response); 
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
