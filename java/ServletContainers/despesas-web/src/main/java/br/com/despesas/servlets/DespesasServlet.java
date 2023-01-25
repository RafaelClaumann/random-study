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
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

        final String rawIndex = request.getParameter("index");
        if (Objects.isNull(rawIndex)) {
            final String despesasListAsString = this.gson.toJson(this.database.listAll(), List.class);
            response.setStatus(SC_OK);
            response.getWriter().write(despesasListAsString);
            LOGGER.log(Level.INFO, String.format("Retornando despesas para o cliente. %s", despesasListAsString));
            return;
        }

        final int parsedIndex = Integer.parseInt(rawIndex);
        final Optional<Despesa> foundDespesa = this.database.findDespesa(parsedIndex);
        if (foundDespesa.isEmpty()) {
            response.setStatus(SC_NOT_FOUND);
            LOGGER.log(Level.WARNING, String.format("Despesa nao encontrada no indice { %s }", parsedIndex));
            return;
        }

        final String despesaJson = this.gson.toJson(foundDespesa.get(), Despesa.class);
        response.setStatus(SC_OK);
        response.getWriter().write(despesaJson);
        LOGGER.log(Level.INFO, String.format("Retornando despesa para o cliente. [ indice { %s }, despesa: { %s }]", parsedIndex, despesaJson));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.isNull(request.getHeader("Content-Type"))) {
            response.sendError(SC_BAD_REQUEST);
            LOGGER.log(Level.WARNING, "Request deve possuir header: Content-Type = application/json e um body json");
            return;
        }

        final String requestHeaderValue = request.getHeader("Content-Type");
        if (requestHeaderValue.equals("application/json")) {
            Despesa despesa = this.gson.fromJson(new JsonReader(request.getReader()), Despesa.class);
            this.database.addDespesa(despesa);

            LOGGER.log(Level.INFO, String.format("despesa adicionada ao BD: { %s }", despesa.toString()));
            response.setStatus(SC_OK);
            response.setContentType("application/json");
            response.getWriter().print(this.gson.toJson(despesa));
        } else {
            response.sendError(SC_BAD_REQUEST, "Header: Content-Type nao possui valor adequado(application/json)");
            LOGGER.log(Level.WARNING, "Header: Content-Type nao possui valor adequado(application/json)");
        }
    }

}
