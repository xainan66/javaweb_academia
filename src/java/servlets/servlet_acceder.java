/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dao.CursoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Curso;

/**
 *
 * @author postal
 */
public class servlet_acceder extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        HttpSession htSession = request.getSession();
        Curso curso;
        CursoDao cdao = new CursoDao();
        if(htSession.getAttribute("usuario") != null) {
            List<Curso> listaCursos = cdao.obtenerTodos();
            for(int i=0;i<listaCursos.size();i++) {
                curso = listaCursos.get(i);
            }
            request.setAttribute("listaCursos",listaCursos);
            RequestDispatcher rd = request.getRequestDispatcher("acceder_usuario.jsp");
            rd.forward(request, response);
        } else {
            List<Curso> listaCursos = cdao.obtenerTodosPublicos();
            for(int i=0;i<listaCursos.size();i++) {
                curso = listaCursos.get(i);
            }
            request.setAttribute("listaCursos",listaCursos);
            RequestDispatcher rd = request.getRequestDispatcher("acceder_invitado.jsp");
            rd.forward(request, response);
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
