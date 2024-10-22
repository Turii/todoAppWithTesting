package com.todoapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;
    private String taskTitle;
    private String assignedTo;
    private String status;
    private Date dueDate;
}
