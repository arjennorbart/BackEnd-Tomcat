package arjen.bep;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sayhello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <title>Dynamic Resource Example</title>");
        out.println("  <body>");
        out.println("    <h2>Hello " + name + "!</h2>");
        out.println("  </body>");
        out.println("</html>");
    }
}
