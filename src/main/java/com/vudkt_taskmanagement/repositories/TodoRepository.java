package com.vudkt_taskmanagement.repositories;

import com.vudkt_taskmanagement.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByPriority(String priority);

    List<Todo> findByTitle(String search);

    List<Todo> findByContent(String search);

}
