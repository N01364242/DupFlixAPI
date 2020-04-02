/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.soap.SOAPFaultException;
import service.AdminDatabaseService;
import service.AdminDatabaseService_Service;
import service.Dupflix;

/**
 *
 * @author Niya
 */
@WebServlet(urlPatterns = {"/AdminUpdateServlet"})
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 100,  // 1 MB
        maxFileSize         = 1024 * 1024 * 100, // 10 MB
        maxRequestSize      = 1024 * 1024 * 150 // 15 MB
        
)
public class AdminUpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminUpdateServlet at " + request.getContextPath() + "</h1>");
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
        Dupflix flix = new Dupflix();
        int postId = Integer.parseInt(request.getParameter("post_id"));
         AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
            flix = port.getDupFlixData(postId);
            request.setAttribute("dupFlix", flix);
            request.getRequestDispatcher("AdminUpdateIndex.jsp").forward(request, response); 
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
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
          
         
       try {
           
           
            
            AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
            
           
            Dupflix flix = new Dupflix();
            flix.setDupflixId(Integer.parseInt(request.getParameter("post_id")));
            flix.setMovieName(request.getParameter("title"));
            flix.setMovieSubtitle(request.getParameter("subtitle"));
            flix.setCategoryType(request.getParameter("category"));
            flix.setMovieDescription(request.getParameter("description"));
            flix.setDirector(request.getParameter("director"));
            flix.setProducer(request.getParameter("producer"));
           flix.setThumbnail( Base64.getDecoder().decode(request.getParameter("thumbnail")));
            System.out.println(request.getParameter("title"));
           
            flix.setIstrending("Y");
            
          int success = port.editDupFlixData(flix);
           if(success == 1){
              
               out.println("<script type='text/javascript'>");
             out.println("alert('Uploaded Successfully');");
                  out.println("</script>");
                  
           }
        } catch(SOAPFaultException ex){
            
            out.println("<script type='text/javascript'>");
             out.println("alert('Disney is prohibited in movies');");
               out.println("</script>");  
        }
       catch (Exception ex) {
             out.println("<script type='text/javascript'>");
             out.println("alert('Error in Uploading. Please try after sometime');");
            out.println("</script>"); 
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       RequestDispatcher rd = request.getRequestDispatcher("ManageIndex.jsp");
rd.forward(request,response);
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
