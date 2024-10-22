package com.todoapplication.dao;

import com.todoapplication.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoDao extends JpaRepository<Todo, Long> {
}
