package com.vudkt_taskmanagement.services.impl;

import com.vudkt_taskmanagement.models.Todo;
import com.vudkt_taskmanagement.repositories.TodoRepository;
import com.vudkt_taskmanagement.services.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }


    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();

    }

    @Override
    public boolean updateCompleted(Long id) {
        Todo todo = getTodoById(id);
        todo.setComplete(!todo.isComplete());
        return createOrUpdate(todo);
    }

    @Override
    public boolean createOrUpdate(Todo todo) {
        Todo objectTodo = todoRepository.save(todo);
        return getTodoById(objectTodo.getId()) != null;
    }

    @Override
    public boolean delete(Long id) {
        todoRepository.deleteById(id);
        return todoRepository.findById(id).isEmpty();
    }
}
