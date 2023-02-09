package com.security.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomEntrypoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        /**
         * It’s a little bit ambiguous that the name of the AuthenticationEntryPoint interface doesn’t reflect its usage upon authentication failure.
         * In the Spring Security architecture, this is used directly by a component called ExceptionTranslationManager.
         * The ExceptionTranslationManager handles any AccessDeniedException and AuthenticationException thrown within the filter chain.
         *
         * BadCredentialsException  - Quando as credenciais estão incorretas, é de tipo incorreto ou o cliente nao possui Role/Authority necessaria.
         * InsufficientAuthenticationException - Quando as credenciais não são informadas.
         */
        final String exceptionClass = authException.getClass().getSimpleName();
        response.setHeader("exception-header", exceptionClass);
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exceptionClass);
    }

}
