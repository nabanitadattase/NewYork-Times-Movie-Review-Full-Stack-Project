/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import generate.DisplayMovieReview;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;

/**
 *
 * @author Nabanita
 */
public class AllReview extends HttpServlet {
//For changing Protocol Version
    static {
        System.setProperty("https.protocols", "TLSv1.2");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String[] status = new String[30];
        try {
//            Creating an object to display Movie Reviews
            DisplayMovieReview edl = new DisplayMovieReview();
            status = edl.searchMovie();
//            Create an arraylist to convert the array to ArrayList
            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(status));
//            session.setAttribute("status", status);
//            Set the arraylist Values in Request
           request.setAttribute("arrayList", arrayList);
//           Sending the Values to the JSP page
           request.getRequestDispatcher("MovieReview.jsp").forward(request, response);
        } 
        catch(Exception e){
                e.printStackTrace();
            }
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
