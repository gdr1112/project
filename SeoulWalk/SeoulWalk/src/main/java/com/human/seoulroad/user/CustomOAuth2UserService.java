package com.human.seoulroad.user;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.human.seoulroad.DataNotFoundException;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
		
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		
		OAuth2User oAuth2User = delegate.loadUser(oAuth2UserRequest);
		
		
		
		String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		SiteUser siteuser = saveOrUpdate(attributes);
		
		httpSession.setAttribute("user", new SessionUserDTO(siteuser));

		
		System.out.println(attributes.getAttributes());
		return new DefaultOAuth2User(
				Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
				, attributes.getAttributes()
				, attributes.getNameAttributeKey());
	}
	

	private SiteUser saveOrUpdate(OAuthAttributes attributes) {
		SiteUser siteuser = userRepository.findByEmail(attributes.getEmail())
				.map(entity -> entity.update(attributes.getName()))
				.orElse(attributes.toEntity());
		
		return userRepository.save(siteuser);
	}
	
	
	// httpsession get
	public SessionUserDTO getSession() {
		
		SessionUserDTO user = (SessionUserDTO) httpSession.getAttribute("user");
		
		return user;
	}
	
	
	// 사용자 조회 메서드 - 이메일
    public SiteUser getUser(String email) {
    	
    	// UserRepository - findByusername
        Optional<SiteUser> siteUser = this.userRepository.findByEmail(email);
        if (siteUser.isPresent()) {
        	System.out.println("조회 성공");
            return siteUser.get();
        }

        // 조회 실패
        else {
            throw new DataNotFoundException("siteuser not found");
        }
    }


}