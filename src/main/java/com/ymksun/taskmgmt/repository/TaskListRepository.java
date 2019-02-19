package com.ymksun.taskmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymksun.taskmgmt.model.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {

}
