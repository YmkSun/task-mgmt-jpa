package com.ymksun.taskmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymksun.taskmgmt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.userId = :id and u.password = :pwd")
	User login(@Param("id") String id, @Param("pwd") String pwd);
	
}
