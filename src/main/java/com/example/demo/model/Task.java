package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long taskId;

    @Column(name="taskTitle")
    private String taskTitle;

    @Column(name="taskContent")
    private String taskContent;

    @Column(name="taskPosition")
    private Long taskPosition;

}
