package com.human.seoulroad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.human.seoulroad.user.CustomAuthSuccessHandler;
import com.human.seoulroad.user.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	
	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable();
		
		
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll()
        
        		.and()
    				.csrf().ignoringRequestMatchers(
    						new AntPathRequestMatcher("/h2-console/**"))
	            .and()
                	.headers()
                	.addHeaderWriter(new XFrameOptionsHeaderWriter(
                			XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                	
                .and()
                	.logout()
                	.logoutUrl("/user/logout")
                	.logoutSuccessUrl("/")
                	.invalidateHttpSession(true)
        		.and()
        			.oauth2Login()
        			.successHandler(new CustomAuthSuccessHandler())
        			.userInfoEndpoint()
        			.userService(customOAuth2UserService)
                ;
        return http.build();
    }

}
