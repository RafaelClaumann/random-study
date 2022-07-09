package br.com.despesas.servlets;

import br.com.despesas.datastore.Database;
import br.com.despesas.model.Despesa;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@WebServlet(name = "PrimeiraServlet", urlPatterns = {"/despesas", "/despesas/"})
public class DespesasServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DespesasServlet.class.getName());

    private final Database database = Database.getDatabaseSingletonInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String correlationId = UUID.randomUUID().toString().substring(0, 15);
        LOGGER.info(String.format("{ %s } - Recebendo Request: { %s }", correlationId, request.toString()));

        final String rawIndex = request.getParameter("index");
        if (Objects.isNull(rawIndex)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, String.format("{ %s } - A URI deve ter um index valido: /despesas-web/?index=<valor>", correlationId));
            throw new ServletException(String.format("{ %s } - A URI deve ter um index valido: /despesas-web/?index=<valor>", correlationId));
        }

        final int parsedIndex = Integer.parseInt(rawIndex);
        final Optional<Despesa> foundDespesa = this.database.findDespesa(parsedIndex);
        if (foundDespesa.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("{ %s } - Despesa nao encontrada no indice { %s }", correlationId, parsedIndex));
            throw new ServletException(String.format("{ %s } - Despesa nao encontrada no indice { %s }", correlationId, parsedIndex));
        }

        final String despesaJson = new Gson().toJson(foundDespesa.get(), Despesa.class);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(despesaJson);
        LOGGER.info(String.format("{ %s } - Retornando despesa para o cliente. [ indice { %s }, despesa: { %s }]", correlationId, parsedIndex, despesaJson));
    }

}
