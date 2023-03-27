package com.tfm.aseguradora.backend.middle.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.*;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private com.tfm.aseguradora.backend.middle.users.client.SecurityApi usersApi;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {
            var sessionInfoDto = usersApi.validateToken(request.getHeader("Authorization"));

            var grantRoles = sessionInfoDto.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());

            var dataSecurityContext = new CustomAuthenticationToken(request.getHeader("Authorization"), grantRoles);
            dataSecurityContext.setAuthenticated(true);

            SecurityContextHolder.getContext().setAuthentication(dataSecurityContext);

            chain.doFilter(request, response);
        } catch (RestClientException ex) {
            logger.warn("Illegal access attempt: " + ex.getMessage());
            throw ex;
        }
    }

}