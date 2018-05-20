package com.silvershield.ssc.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {

        Optional username = Optional.ofNullable(request.getHeader("X-Auth-Username"));
        Optional password = Optional.ofNullable(request.getHeader("X-Auth-Password"));
        Optional token = Optional.ofNullable(request.getHeader("X-Auth-Token"));

        // TODO validate token
        _logger.info("Token [{}]", token);
        request.setAttribute("clientId", 123);
        return token.isPresent();
    }
}
