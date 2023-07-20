package com.vudkt_taskmanagement.services;

import com.vudkt_taskmanagement.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();


    Todo getTodoById(Long id);

    boolean updateCompleted(Long id);

    boolean createOrUpdate(Todo todo);

    boolean delete(Long id);
}
