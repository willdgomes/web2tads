package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ufpr.tads.web2.beans.LoginBean.LoginBean;

public final class portal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <title>Portal </title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"Source code generated using layoutit.com\">\n");
      out.write("        <meta name=\"author\" content=\"LayoutIt!\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"portal.jsp\">WEB II</a>\n");
      out.write("        <div class=\"navbar navbar-dark bg-dark\" id=\"navbarNav\">\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"ServletCliente\">Cadastro de Clientes <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"LogoutServlet\">Sair</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

        String t = null;
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = request.
                    getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "Usuário deve autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
      out.write("\n");
      out.write("\n");
      out.write("    ");
      com.ufpr.tads.web2.beans.LoginBean.LoginBean u = null;
      synchronized (session) {
        u = (com.ufpr.tads.web2.beans.LoginBean.LoginBean) _jspx_page_context.getAttribute("u", PageContext.SESSION_SCOPE);
        if (u == null){
          u = new com.ufpr.tads.web2.beans.LoginBean.LoginBean();
          _jspx_page_context.setAttribute("u", u, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.ufpr.tads.web2.beans.LoginBean.LoginBean)_jspx_page_context.findAttribute("u")).getNomeUsuario())));
      out.write("\n");
      out.write("    ");
}
      out.write("\n");
      out.write("\n");
      out.write("    %>\n");
      out.write("    <h3>nome: ");
      out.print(t);
      out.write("</h3>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/scripts.js\"></script>\n");
      out.write("</body>\n");
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
