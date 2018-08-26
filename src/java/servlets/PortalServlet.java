/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Beans.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gomes
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

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
        
        
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = request.
                    getRequestDispatcher("ErroServlet");
            request.setAttribute("msg", "Sessao expirou");
            request.setAttribute("page", "index.html");
            rd.forward(request, response);
        } else {
                    response.setContentType("text/html;charset=UTF-8");
        
        List<Usuario> listUsuarios = new ArrayList<Usuario>();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            listUsuarios = usuarioDAO.buscarTodosUsuarios();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");  
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"    <link href=\"css/style.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastrar Usuario</h1>");
            out.println("<form action=\"CadastrarUsuarioServlet\" method=\"POST\">");
            out.println("Nome: <input type='text' name='nome' value=''/><br/><br/>");
            out.println("Login: <input type='text' name='login' value=''/><br/><br/>");
            out.println("Senha: <input type='password' name='senha' value=''/><br/><br/>");
            out.println("<input type='submit' value='Salvar'><br/>");
            out.println("<table class=\"table table-bordered table-sm\">");
            out.println("<th>Nome</th>");
            out.println("<th>Login</th>");
            for (int i = 0; i < listUsuarios.size(); i++) {
                out.println("<tr>");
                out.println("<td>"+listUsuarios.get(i).getNome()+"</td>");
                out.println("<td>"+listUsuarios.get(i).getLogin()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>"); 
            out.println("</form>");
            out.println("<a href=\"LogoutServlet\">Logout</a>");
            out.println("</body>");
            out.println("<script src=\"js/jquery.min.js\"></script>\n" +
"    <script src=\"js/bootstrap.min.js\"></script>\n" +
"    <script src=\"js/scripts.js\"></script>");
            out.println("</html>");
        }
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
