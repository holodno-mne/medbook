package com.exp.self.medbook.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomInternalSecretFilter implements Filter {

    private final CustomInternalSecretProperty secretProperty;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (!matchInternalSecret(request)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    protected boolean matchUrls(HttpServletRequest request) {
        return new AntPathRequestMatcher("/role/v1/permissions/**", HttpMethod.GET).matches(request);
    }

    protected boolean matchInternalSecret(HttpServletRequest request) {
        if (matchUrls(request)) {
            return new RequestHeaderRequestMatcher(secretProperty.getKey(), secretProperty.getValue()).matches(request);
        } else {
            return true;
        }
    }
}
