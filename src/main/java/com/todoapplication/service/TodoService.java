package com.todoapplication.service;

import com.todoapplication.vo.TodoVO;

import java.util.List;
public interface TodoService {
    TodoVO createTodo(TodoVO todo);
    TodoVO updateTodo(Long id, TodoVO todo);
    void deleteTodo(Long id);
    TodoVO getTodoById(Long id);
    List<TodoVO> getAllTodos();
}