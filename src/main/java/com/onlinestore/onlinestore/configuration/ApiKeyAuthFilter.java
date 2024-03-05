package com.onlinestore.onlinestore.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.secret}")
	private String apiSecret;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestApiKey = request.getHeader("X-API-KEY");
		String requestApiSecret = request.getHeader("X-API-SECRET");
		if(requestApiKey == null) {
			requestApiKey = "my-api-key";
		}
		if(requestApiSecret == null) {
			requestApiSecret = "my-secret";
		}
		if (apiKey.equals(requestApiKey) && apiSecret.equals(requestApiSecret)) {
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("Unauthorized");
		}
	}
}

