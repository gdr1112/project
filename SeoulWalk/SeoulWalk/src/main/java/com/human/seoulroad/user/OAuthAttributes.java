package com.human.seoulroad.user;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
    	this.attributes = attributes;
    	this.nameAttributeKey = nameAttributeKey;
    	this.name = name;
    	this.email = email;
    }
    
    public OAuthAttributes() {
    }
    
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
    	if(registrationId.equals("kakao")) {
    		return ofKakao(userNameAttributeName, attributes);
    	} else if(registrationId.equals("naver")) {
    		return ofNaver(userNameAttributeName, attributes);
    	}
    	return ofGoogle(userNameAttributeName, attributes);
    }
    
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
    	Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
    	System.out.println(kakao_account);
    	Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");
    	
    	return new OAuthAttributes(attributes,
    			userNameAttributeName,
    			(String) profile.get("nickname"),
    			(String) kakao_account.get("email"));
    }
    
    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    	Map<String, Object> response = (Map<String, Object>) attributes.get("response");
    	
    	return new OAuthAttributes(attributes,
    			userNameAttributeName,
    			(String) response.get("name"),
    			(String) response.get("email"));
    }
    
    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
    	return new OAuthAttributes(
    			attributes,
    			userNameAttributeName,
    			(String) attributes.get("name"),
    			(String) attributes.get("email"));
    }
    
    
    // 닉네임 설정 메서드
    public SiteUser toEntity() {
    	int idx = email.indexOf("@");
    	String nickname = email.substring(0,idx-4) + "****" + email.substring(idx+1, email.length()-4);
    	
    	return new SiteUser(name, email, nickname, "ROLE_USER");
    }
    
//    public SiteUser toEntity() {
//    	return SiteUser.builder()
//    			.name(name)
//    			.email(email)
//    			.build();
//    }

}