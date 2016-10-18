package com.trabalho.ws.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String authorization = req.getHeader("Authorization");
		
		System.out.println(authorization);
		
		if(authorization.equals(null) || !authorization.startsWith("Bearer ")){
			throw new ServletException("TOKEN INVALIDO OU INEXISTENTE!");
		}
		
		String token = authorization.substring(7);
		try {
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		} catch (SignatureException e) {
			throw new ServletException("TOKEN INVALIDO!");
		}
		
		chain.doFilter(request, response);
		
	}

}
