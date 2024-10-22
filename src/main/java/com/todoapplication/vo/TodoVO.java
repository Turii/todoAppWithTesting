package com.todoapplication.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
@Data
@AllArgsConstructor
public class TodoVO {
    private Long id;
    private String taskTitle;
    private String assignedTo;
    private String status;
    private Date dueDate;
}