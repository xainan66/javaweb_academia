/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dao.CursoDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Curso;
import modelo.Usuario;

/**
 *
 * @author postal
 */
public class servlet_login extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        RequestDispatcher rd;
        UsuarioDao udao = new UsuarioDao();
        String nUsuario = (String)request.getParameter("usuario");
        String clave = (String)request.getParameter("clave");
        if(udao.validarUsuario(nUsuario, clave)) {
            Curso curso;
            Usuario login = udao.obtenerUno(nUsuario);
            CursoDao cdao = new CursoDao();
            List<Curso> listaCursos = cdao.obtenerTodos();
            for(int i=0;i<listaCursos.size();i++) {
                curso = listaCursos.get(i);
            }
            request.setAttribute("listaCursos",listaCursos);
            session.setAttribute("usuario", login);
            rd = request.getRequestDispatcher("acceder_usuario.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("msg", "Usuario o clave incorrectos");
            rd = request.getRequestDispatcher("error.jsp");
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
