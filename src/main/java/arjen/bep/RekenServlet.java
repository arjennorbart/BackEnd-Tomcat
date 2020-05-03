package arjen.bep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
        String num1 = "";
        String num2 = "";
        double number1 = parseDouble(stringBuilder.toString().split(" ")[0]);
        if (number1 % 1 == 0)
             num1 = String.format("%.0f", number1);
        else num1 = String.format("%s", number1);

        double number2 = parseDouble(stringBuilder.toString().split(" ")[1]);
        if (number2 % 1 == 0)
            num2 = String.format("%.0f", number2);
        else num2 = String.format("%s", number2);

        String operator = stringBuilder.toString().split(" ")[2];
        String afronden = stringBuilder.substring(Math.max(stringBuilder.length() - 3, 0));

        if (operator.equals("-")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(number1 - number2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, number1 - number2));
        } else if (operator.equals("+")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(number1 + number2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, number1 + number2));
        } else if (operator.equals("*")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(number1 * number2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, number1 * number2));
        } else if (operator.equals("/")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(number1 / number2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, number1 / number2));
        } else if (operator.equals("%")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(number1 % number2)));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, number1 % number2));
        } else if (operator.equals("^")) {
            if (afronden.contains("ja"))
                out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.round(Math.pow(number1, number2))));
            else out.write(String.format("%s %s %s = %s", num1, operator, num2, Math.pow(number1, number2)));
        } else out.write("iets mis gegaan");
    }
}

