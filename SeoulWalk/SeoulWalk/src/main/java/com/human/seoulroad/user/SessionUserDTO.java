package com.human.seoulroad.user;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUserDTO implements Serializable{
	private String name;
	private String email;
	private String nickname;
	private String role;
	
	public SessionUserDTO(SiteUser siteuser) {
		this.name = siteuser.getName();
		this.email = siteuser.getEmail();
		this.nickname = siteuser.getNickname();
		this.role = siteuser.getRole();
	}

}