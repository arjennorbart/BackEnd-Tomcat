package arjen.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;



@WebServlet(urlPatterns = "/requestinfo")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Method: " + req.getMethod() + "\r\n");
        stringBuilder.append("URL: " + req.getRequestURL() + "\r\n");
        stringBuilder.append("Path: " + req.getRequestURI() + "\r\n");
        stringBuilder.append("Server: " + req.getServerName() + "\r\n");
        stringBuilder.append("Port: " + req.getServerPort() + "\r\n\r\n");

        Enumeration<String> parameter = req.getParameterNames();
        if (parameter != null) {
            while (parameter.hasMoreElements()) {
                stringBuilder.append("[Param] " + req.getParameter(parameter.nextElement()) + "\r\n");
            } stringBuilder.append("\r\n");
        }

        Enumeration<String> headerNames = req.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                stringBuilder.append("[Header] " + req.getHeader(headerNames.nextElement()) + "\r\n");
            }
        }
        System.out.println(stringBuilder);
        out.write(stringBuilder.toString());
    }
}

