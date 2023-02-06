package com.human.seoulroad.user;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    private final RequestCache requestCache = new HttpSessionRequestCache();
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();	
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
    	
    	clearSession(request);
    	SavedRequest savedRequest = requestCache.getRequest(request, response);
    	String prevPage = (String) request.getSession().getAttribute("prevPage");
    	String uri = "";
    	
    	if(savedRequest != null) {
    		uri = savedRequest.getRedirectUrl();
    	}else {
    		uri = prevPage;
    	}
    	
    	redirectStrategy.sendRedirect(request, response, uri);
    	

    }
    
    
    protected void clearSession(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    	}
    }
}
