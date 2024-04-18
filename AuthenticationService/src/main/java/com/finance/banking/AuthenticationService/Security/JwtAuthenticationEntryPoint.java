package com.finance.banking.AuthenticationService.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.banking.AuthenticationService.ReqResBodies.AuthErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        AuthErrorResponse error = AuthErrorResponse.builder()
                .errorMessage("Invalid Phone Number or Password")
                .status(HttpStatus.UNAUTHORIZED)
                .build();
        ResponseEntity<AuthErrorResponse> res = new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        objectMapper.writeValue(response.getWriter(), res.getBody());
    }
}
