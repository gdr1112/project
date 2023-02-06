package com.human.seoulroad.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long>{
	Optional<SiteUser> findByEmail(String email);
	
	Optional<SiteUser> findByName(String name); // 사용자 조회
	
	
	Optional<SiteUser> findById(Long id);
}
