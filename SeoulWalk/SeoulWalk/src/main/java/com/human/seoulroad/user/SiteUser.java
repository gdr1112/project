package com.human.seoulroad.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class SiteUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false)
    private String name;
	
    @Column(unique = true)
    private String email;
    
    @Column
    private String nickname;
    
    @Column(nullable = false)
    private String role = "ROLE_USER";
	
	
	@Builder
	public SiteUser(String name, String email, String nickname, String role){
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.role = role;
	}
	
	public SiteUser update(String name) {
		this.name = name;
		
		return this;
	}	

}