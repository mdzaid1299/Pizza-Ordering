package com.question.UserProductService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authheader = request.getHeader("authorization");
        if (authheader == null || !authheader.startsWith("Bearer")){
            throw new ServletException("Missing or invalid token");
        }
        String jwttoken = authheader.substring(7);
        Claims claims = Jwts.parser().setSigningKey("mykey").parseClaimsJws(jwttoken).getBody();
        System.out.println("claims = " + claims);
        request.setAttribute("claims",claims);
        filterChain.doFilter(request,response);
    }
}
