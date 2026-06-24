package com.javarush.lesson18.controller.http;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@ControllerAdvice
public class CsrfControllerAdvice {
    @ModelAttribute("_csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (token == null) {
            log.error("CSRF token is null!");
        } else {
            log.info("CSRF token is {}", token.getToken());
        }
        return token;
    }
}