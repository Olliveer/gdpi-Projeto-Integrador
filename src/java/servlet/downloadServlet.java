/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entidades.Documento;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DocumentoDAO;

/**
 *
 * @author joliv
 */
@WebServlet(name = "downloadServlet", urlPatterns = {"/downloadServlet"})
public class downloadServlet extends HttpServlet {

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
            out.println("<title>Servlet downloadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet downloadServlet at " + request.getContextPath() + "</h1>");
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
        
        Documento d = DocumentoDAO.download(Integer.valueOf(request.getParameter("id")));
        
        String filePath = d.getUrl()+"\\"+d.getNome();
        
        File file = new File(filePath);
        FileImageInputStream fi = new FileImageInputStream(file);
        String path = getServletContext().getRealPath("");
        System.out.println("Path: " + path);
        
        ServletContext context = getServletContext();
        String mimeType = context.getMimeType(path);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("Mime Type: " + mimeType);
        
        response.setContentType(mimeType);
        response.setContentLength((int) file.length());
        
        String key = "Content-Disposition";
        String value = String.format("attachment; filename=\"%s\"", file.getName());
        response.setHeader(key, value);
        
        OutputStream outStream = response.getOutputStream();
        
        byte[] buffer = new byte[4096];
        int byteRead = -1;
        
        while ((byteRead = fi.read(buffer)) != -1) {
            outStream.write(buffer, 0, byteRead);
            
        }
        
        fi.close();
        outStream.close();
        
                
                
        
        
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
        processRequest(request, response);
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
