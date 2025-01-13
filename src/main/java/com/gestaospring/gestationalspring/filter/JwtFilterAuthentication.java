package com.gestaospring.gestationalspring.filter;

import java.io.IOException;
import java.util.Objects;

import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.gestaospring.gestationalspring.interfaces.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtFilterAuthentication extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var bearerCookie = WebUtils.getCookie(request, "Bearer");

        if (Objects.nonNull(bearerCookie)) {
            try {
                Assert.isTrue(jwtService.isValid(bearerCookie.getValue()), "Token inválido");
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
