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
import javax.validation.ConstraintViolationException;
import javax.xml.ws.soap.SOAPFaultException;
import service.AdminDatabaseService;
import service.AdminDatabaseService_Service;
import service.Dupflix;

/**
 *
 * @author Niya
 */
@WebServlet(urlPatterns = {"/AdminServlet"})
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 100,  // 1 MB
        maxFileSize         = 1024 * 1024 * 100, // 10 MB
        maxRequestSize      = 1024 * 1024 * 150 // 15 MB
        
)
public class AdminServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
            
            
            Part thumbfilePart = request.getPart("thumbnail");
            
            File directory = new File("C:\\dupflix");
            boolean dirCreated = directory.mkdir();
           
            //get thumbnail
	   InputStream thumbnailInputStream = thumbfilePart.getInputStream();
            File thumbnailToSave = new File("C:\\dupflix\\" + thumbfilePart.getSubmittedFileName());
	    Files.copy(thumbnailInputStream, thumbnailToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String thumbnailUrl = "C:\\dupflix\\" + thumbfilePart.getSubmittedFileName();
            
            Dupflix flix = new Dupflix();
            flix.setMovieName(request.getParameter("title"));
            flix.setMovieSubtitle(request.getParameter("subtitle"));
            flix.setCategoryType(request.getParameter("category"));
            flix.setMovieDescription(request.getParameter("description"));
            flix.setDirector(request.getParameter("director"));
            flix.setProducer(request.getParameter("producer"));
           
            File file1 = new File(thumbnailUrl);
            System.out.println(request.getParameter("title"));
            
            byte[] image = Files.readAllBytes(file1.toPath());
            flix.setIstrending("Y");
            flix.setThumbnail(image);
           int success =  port.upload(flix);
            thumbnailToSave.delete();
           if(success == 1){
              
              
               out.println("<script type=\"text/javascript\">");
   out.println("alert('Uploaded Successfully');");
   out.println("location='index.jsp';");
   out.println("</script>");
              
           }else{
              out.println("<script type=\"text/javascript\">");
   out.println("alert('Error in Uploading. Please try after sometime');");
   out.println("location='index.jsp';");
   out.println("</script>"); 
           }
        } catch(SOAPFaultException ex){
             out.println("<script type=\"text/javascript\">");
   out.println("alert('Disney is prohibited in movies');");
   out.println("location='index.jsp';");
   out.println("</script>");
             
        }
       catch (IOException | ConstraintViolationException | ServletException ex) {
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Error in Uploading. Please try after sometime');");
   out.println("location='index.jsp';");
   out.println("</script>");
             
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
