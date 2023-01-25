package br.com.despesas.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilterXmlRegistered implements Filter {

    private static final Logger LOGGER = Logger.getLogger(FilterXmlRegistered.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.log(Level.INFO, "passando no FilterXmlRegistered!");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
