package com.ymksun.taskmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymksun.taskmgmt.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
