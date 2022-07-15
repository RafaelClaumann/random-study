package br.com.despesas.servlets;

import br.com.despesas.datastore.Database;
import br.com.despesas.model.Despesa;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jakarta.servlet.http.HttpServletResponse.*;

@WebServlet(name = "PrimeiraServlet", urlPatterns = {"/despesas", "/despesas/"})
public class DespesasServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DespesasServlet.class.getName());

    private final Database database = Database.getDatabaseSingletonInstance();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String correlationId = UUID.randomUUID().toString().substring(0, 15);
        LOGGER.log(Level.INFO, String.format("{ %s } - Recebendo Request: { %s }", correlationId, request.toString()));

        final String rawIndex = request.getParameter("index");
        if (Objects.isNull(rawIndex)) {
            response.sendError(SC_BAD_REQUEST, String.format("{ %s } - A URI deve ter um index valido: /despesas-web/?index=<valor>", correlationId));
            throw new ServletException(String.format("{ %s } - A URI deve ter um index valido: /despesas-web/?index=<valor>", correlationId));
        }

        final int parsedIndex = Integer.parseInt(rawIndex);
        final Optional<Despesa> foundDespesa = this.database.findDespesa(parsedIndex);
        if (foundDespesa.isEmpty()) {
            response.sendError(SC_NOT_FOUND, String.format("{ %s } - Despesa nao encontrada no indice { %s }", correlationId, parsedIndex));
            throw new ServletException(String.format("{ %s } - Despesa nao encontrada no indice { %s }", correlationId, parsedIndex));
        }

        final String despesaJson = this.gson.toJson(foundDespesa.get(), Despesa.class);
        response.setStatus(SC_OK);
        response.getWriter().write(despesaJson);
        LOGGER.log(Level.INFO, String.format("{ %s } - Retornando despesa para o cliente. [ indice { %s }, despesa: { %s }]", correlationId, parsedIndex, despesaJson));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String correlationId = UUID.randomUUID().toString().substring(0, 15);

        if (Objects.isNull(request.getHeader("Content-Type"))) {
            response.sendError(SC_BAD_REQUEST, String.format("{ %s } - Request deve possuir header: Content-Type = application/json e um body json", correlationId));
            LOGGER.log(Level.WARNING, String.format("{ %s } - Request deve possuir header: Content-Type = application/json e um body json", correlationId));
            return;
        }

        final String requestHeaderValue = request.getHeader("Content-Type");
        if (requestHeaderValue.equalsIgnoreCase("application/json")) {
            Despesa responseBody = this.gson.fromJson(new JsonReader(request.getReader()), Despesa.class);
            LOGGER.log(Level.INFO, responseBody.toString());
            response.setStatus(SC_OK);
        } else {
            response.sendError(SC_BAD_REQUEST, String.format("{ %s } - Header: Content-Type nao possui valor adequado(application/json)", correlationId));
            LOGGER.log(Level.WARNING, String.format("{ %s } - Header: Content-Type nao possui valor adequado(application/json)", correlationId));
        }
    }

}
