package com.todoapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
//import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "todo")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskTitle;
    private String assignedTo;
    private String status;
    private Date dueDate;
}
