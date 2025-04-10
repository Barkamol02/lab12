package com.example.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired

    private ProjectRepository repository;
    @GetMapping("/search")
    public List<Project> searchProjects(@RequestParam String keyword) {
        return repository.findByDescriptionContainingIgnoreCase(keyword);
    }
}
