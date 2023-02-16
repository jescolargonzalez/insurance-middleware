package com.tfm.aseguradora.backend.middle.config;

import org.springframework.security.authentication.*;
import org.springframework.security.core.*;

import java.util.*;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private String credential;

    public CustomAuthenticationToken(String mail, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.credential = mail;
    }

    @Override
    public Object getCredentials() {
        return this.credential;
    }

    @Override
    public Object getPrincipal() {
        return this.credential;
    }
}