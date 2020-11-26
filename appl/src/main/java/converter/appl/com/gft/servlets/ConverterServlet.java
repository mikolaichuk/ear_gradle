/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gft.beans.*;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.LocalHome;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author MMikolaychuk
 */
public class ConverterServlet extends HttpServlet {
    @EJB
    NumberConversionClientBeanLocal clientBean;    
   
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HolaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HolaServlet at " + request.getContextPath() + "</h1>");
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
            
      try (PrintWriter out = response.getWriter()) {                                            
            String number = request.getParameter("number");                                
           try{
                Context context = new InitialContext();                          
                NumberConverterLocalHome localHome = (NumberConverterLocalHome)context.lookup("java:comp/env/MyConverter");                   
                NumberConverterLocal local = localHome.create();                                
                if (Objects.isNull(number)) {
                    out.println("Please provide 'number' variable in the url");
                } else {
                    out.printf("EJB 2.0 output: %s </br>", local.getString( Integer.parseInt(number)));
                    out.printf("EJB 3.1 output: %s </br>", clientBean.getString( Integer.parseInt(number)));
                }                
                
            } catch (Exception e) {
              out.println(e.getMessage());              
            }
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
