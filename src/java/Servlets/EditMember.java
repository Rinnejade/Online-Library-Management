/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Book;
import Data.Member;
import DataAccess.BookAccess;
import DataAccess.MemberAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinod-pt1457
 */
public class EditMember extends HttpServlet {

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
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");

            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notyf.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notifications.js'></script>");

            out.println("</head>");
            out.println("<body>");

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = (request.getParameter("dob"));
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");

            //notification
            out.println("<script language='JavaScript'>");
            out.println("success('Member Data Updated!')");
            out.println("</script>");

            Member member = new Member(id, name, password, gender, dob, address, contact);
            int status = MemberAccess.update(member);
            request.getRequestDispatcher("ViewMember").include(request, response);

//            response.sendRedirect("ViewMember");
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
