package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author Alan DoubleEight4
 */
public class Servlet1 extends HttpServlet {
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

        getServletContext()
            .getRequestDispatcher("/Servlet2")
            .forward(request,response);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet1</title>");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<h1>Servlet1</h1>");
            
            out.println("<div>");
            out.println("<p>Lista de parámetros de contexto</p>");
            out.println("<ul>");
            
            Enumeration<String> ParameterNames = getServletContext().getInitParameterNames();
            while(ParameterNames.hasMoreElements()){
                String pName = ParameterNames.nextElement();
                out.println("<li>" +pName+" = " + getServletContext().getInitParameter(pName)+"</li>");
            }
            out.println("<p>Lista de parámetros iniciales del Servlet");
            
            Enumeration<String> initParamNames = getInitParameterNames();
            while(initParamNames.hasMoreElements()){
                String pName = initParamNames.nextElement();
                out.println("<li>"+pName+" = " + getInitParameter(pName) + "</li>");
            }
            out.println("</ul>");
            out.println("<div>");
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