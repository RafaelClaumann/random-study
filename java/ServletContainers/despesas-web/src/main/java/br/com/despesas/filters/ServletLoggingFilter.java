package br.com.despesas.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter(filterName = "LoggingFilter", urlPatterns = "/*")
public class ServletLoggingFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(ServletLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String requestMethod = ((HttpServletRequest) servletRequest).getMethod();
        final String requestURL = ((HttpServletRequest) servletRequest).getRequestURL().toString();
        final String requestQuery = ((HttpServletRequest) servletRequest).getQueryString();
        final Boolean hasBody = servletRequest.getContentLength() > 0;

        LOGGER.log(Level.INFO, String.format("method: %s, URL: %s, query: %s, has body: %s", requestMethod, requestURL, requestQuery, hasBody));
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
