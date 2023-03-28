package com.tfm.aseguradora.backend.middle.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.*;
import com.tfm.aseguradora.backend.middle.users.dto.SessionInfoClientDto;
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

    @Value("${rest.client.core.users.host}")
    private String baseUsersHost;

    @Autowired
    @Qualifier("restTemplateWithoutInterceptor")
    private RestTemplate restTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", request.getHeader("Authorization"));
            HttpEntity entity = new HttpEntity(headers);
            var sessionInfoDto =  restTemplate.exchange(baseUsersHost + "/security/token/validation",
                    HttpMethod.GET, entity, SessionInfoClientDto.class).getBody();

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