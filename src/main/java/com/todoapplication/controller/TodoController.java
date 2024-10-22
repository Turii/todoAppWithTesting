package com.todoapplication.controller;

import com.todoapplication.service.TodoService;
import com.todoapplication.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController@RequestMapping("/todos")public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoVO> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public TodoVO getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }
    @PostMapping
    public TodoVO createTodo(@RequestBody TodoVO todo) {
        return todoService.createTodo(todo);
    }
    @PutMapping("/{id}")
    public TodoVO updateTodo(@PathVariable Long id, @RequestBody TodoVO todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}