package br.com.despesas;


import br.com.despesas.model.Despesa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "PrimeiraServlet", urlPatterns = {"/despesas"})
public class PrimeiraServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(PrimeiraServlet.class.getName());

    private final List<Despesa> despesasList = new ArrayList<>();

    public PrimeiraServlet() {
        this.despesasList.add(new Despesa.DespesaBuilder()
                .descricao("uber")
                .valor(50.25D)
                .build()
        );

        this.despesasList.add(new Despesa.DespesaBuilder()
                .descricao("mercado")
                .valor(170.0D)
                .build()
        );
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info(String.format("Recebendo Request: { %s }", request.toString()));
        final PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1> Primeira Servlet </h1>");
        writer.println("</body>");
        writer.println("</html>");
    }

}
