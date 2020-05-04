package arjen.servlets;

import arjen.models.Bank;
import arjen.models.Rekening;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/rekeninginfo")
public class RekeningServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        StringBuilder stringBuilder = new StringBuilder();
        PrintWriter out = new PrintWriter(resp.getWriter());

        Rekening rekening = Bank.getBank().getRekening(req.getParameter("nummer"));
        boolean logs = req.getParameterValues("logs") != null;
        if (logs) {
            stringBuilder.append(rekening.getNummer());
            for (String log : rekening.getLogs()) {
                stringBuilder.append(log).append("\r\n");
            }
        }
        else {
            stringBuilder.append(rekening.getNummer()).append("\r\n").append(String.format("%.2f", rekening.getSaldo())).append("\r\n").append(rekening.getKlant());
        }
        out.write(stringBuilder.toString());
    }
}
