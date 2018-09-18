package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.ufpr.tads.web2.dao.ClienteDAO.ClienteDAO;
import com.ufpr.tads.web2.beans.Cliente.Cliente;
import java.util.ArrayList;

public final class clientesListar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <title>Clientes </title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"Source code generated using layoutit.com\">\n");
      out.write("        <meta name=\"author\" content=\"LayoutIt!\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      com.ufpr.tads.web2.beans.Cliente.Cliente cliente = null;
      synchronized (session) {
        cliente = (com.ufpr.tads.web2.beans.Cliente.Cliente) _jspx_page_context.getAttribute("cliente", PageContext.SESSION_SCOPE);
        if (cliente == null){
          cliente = new com.ufpr.tads.web2.beans.Cliente.Cliente();
          _jspx_page_context.setAttribute("cliente", cliente, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");

            session = request.getSession(false);
            if (session == null) {
                RequestDispatcher rd = request.
                        getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário deve autenticar para acessar o sistema!");
                rd.forward(request, response);
            } else {
      out.write("\n");
      out.write("        <table class=\"table table-bordered table-sm\">\n");
      out.write("            <th>CPF</th>\n");
      out.write("            <th>Nome</th>\n");
      out.write("            <th>E-mail</th>");

                ClienteDAO clienteDAO = new ClienteDAO();
                List<Cliente> listClientes = new ArrayList<Cliente>();
                listClientes = clienteDAO.buscarClientes();
                for (int i = 0; i < listClientes.size(); i++) {
                    String cpf = listClientes.get(i).getCpfCliente();
                    String nome = listClientes.get(i).getNomeCliente();
                    String email = listClientes.get(i).getEmailCliente();
                
      out.write("<tr>\n");
      out.write("                    <td>");
      out.print(cpf );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(nome );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(email);
      out.write("</td>\n");
      out.write("                </tr>");

                    }
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/scripts.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
