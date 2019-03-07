package com.ymksun.taskmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymksun.taskmgmt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
