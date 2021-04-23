package com.ICF.assignment.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ICF.assignment.Exception.HeaderException;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
			String key=request.getHeader("X-Request-Key");
			
			if(!key.equals("SecureHeader")) {
				throw  new HeaderException("Invalid Request");
			}
		
	      return true;
	   }
}
