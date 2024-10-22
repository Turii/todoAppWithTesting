package com.todoapplication.service.impl;

import com.todoapplication.dao.TodoDao;
import com.todoapplication.entity.Todo;
import com.todoapplication.exception.BadRequestException;
import com.todoapplication.exception.ResourceNotFoundException;
import com.todoapplication.service.TodoService;
import com.todoapplication.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import java.util.List;import java.util.stream.Collectors;
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoDao todoDao;
    @Override
    public TodoVO createTodo(TodoVO todo) {
        // Перевірка вхідних даних
        if (todo.getTaskTitle() == null || todo.getDueDate() == null) {
        throw new BadRequestException("All fields are mandatory");
    }
    // Конвертація до сутності
        Todo todoEntity = new Todo();
        todoEntity.setTaskTitle(todo.getTaskTitle());
        todoEntity.setAssignedTo(todo.getAssignedTo());
        todoEntity.setStatus(todo.getStatus());
        todoEntity.setDueDate(todo.getDueDate());
    // Збереження в базі        todoDao.save(todoEntity);
    // Повернення створеного об'єкту
        return todo;
}
@Override
public TodoVO updateTodo(Long id, TodoVO todo) {
    Todo todoEntity = todoDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
    todoEntity.setTaskTitle(todo.getTaskTitle());        todoEntity.setAssignedTo(todo.getAssignedTo());        todoEntity.setStatus(todo.getStatus());        todoEntity.setDueDate(todo.getDueDate());        todoDao.save(todoEntity);        return todo;
}
@Override
public void deleteTodo(Long id) {
    Todo todoEntity = todoDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
    todoDao.delete(todoEntity);
}
@Override
public TodoVO getTodoById(Long id) {
    Todo todoEntity = todoDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
    return new TodoVO(todoEntity.getId(), todoEntity.getTaskTitle(), todoEntity.getAssignedTo(), todoEntity.getStatus(), todoEntity.getDueDate());
}
@Override
public List<TodoVO> getAllTodos() {
    List<Todo> todos = todoDao.findAll();
    return todos.stream().map(todo -> new TodoVO(todo.getId(), todo.getTaskTitle(), todo.getAssignedTo(), todo.getStatus(), todo.getDueDate())).collect(Collectors.toList());
}
}
