package com.example.lab12;

import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "employee_task",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<ProjectTask> tasks = new HashSet<>();  // Updated to ProjectTask

    // Constructors
    public Employee() {}
    public Employee(String name) { this.name = name; }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<ProjectTask> getTasks() { return tasks; }
    public void setTasks(Set<ProjectTask> tasks) { this.tasks = tasks; }

    // Helper methods
    public void addTask(ProjectTask task) {
        tasks.add(task);
        task.getEmployees().add(this);
    }
}
