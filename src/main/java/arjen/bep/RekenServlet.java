package arjen.bep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static java.lang.Double.parseDouble;

@WebServlet(urlPatterns = "/rekenmachine")
public class RekenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> parameter = req.getParameterNames();
        if (parameter != null) {
            while (parameter.hasMoreElements()) {
                stringBuilder.append(req.getParameter(parameter.nextElement()) + " ");
            }
        }
        double num1 = parseDouble(stringBuilder.toString().split(" ")[0]);
        double num2 = parseDouble(stringBuilder.toString().split(" ")[1]);
        String operator = stringBuilder.toString().split(" ")[2];
        String afronden = stringBuilder.substring(Math.max(stringBuilder.length() - 3, 0));

        if (operator.equals("-")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(num1 - num2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, num1 - num2));
        } else if (operator.equals("+")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(num1 + num2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, num1 + num2));
        } else if (operator.equals("*")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(num1 * num2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, num1 * num2));
        } else if (operator.equals("/")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(num1 / num2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, num1 / num2));
        } else if (operator.equals("%")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(num1 % num2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, num1 % num2));
        } else if (operator.equals("^")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(Math.pow(num1, num2))));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.pow(num1, num2)));
        }
        else out.write("iets mis gegaan");
    }
}

