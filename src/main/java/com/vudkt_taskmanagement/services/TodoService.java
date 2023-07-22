package com.vudkt_taskmanagement.services;

import com.vudkt_taskmanagement.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    List<Todo> search(String search);

    Todo getTodoById(Long id);

    List<Todo> filterByPriority(String priority);

    boolean updateCompleted(Long id);

    boolean createOrUpdate(Todo todo);

    boolean delete(Long id);
}
