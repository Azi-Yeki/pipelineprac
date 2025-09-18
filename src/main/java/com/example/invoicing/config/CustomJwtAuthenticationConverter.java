package com.example.invoicing.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

//    @Override
//    public AbstractAuthenticationToken convert(Jwt jwt) {
//        JwtAuthenticationConverter delegate = new JwtAuthenticationConverter();
//
//        // Custom authority extraction logic
//        delegate.setJwtGrantedAuthoritiesConverter(jwtToken -> {
//            Collection<GrantedAuthority> defaultAuthorities = new JwtGrantedAuthoritiesConverter().convert(jwtToken);
//            List<String> roles = jwtToken.getClaimAsStringList("roles"); // or "groups", "scp", etc.
//
//            List<GrantedAuthority> mappedAuthorities = roles != null
//                    ? roles.stream().map(role -> (GrantedAuthority) () -> "ROLE_" + role).collect(Collectors.toList())
//                    : List.of();
//
//            return mappedAuthorities;
//        });
//
//        return delegate.convert(jwt);
//    }
}
