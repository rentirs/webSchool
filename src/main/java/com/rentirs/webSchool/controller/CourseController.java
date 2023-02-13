package com.rentirs.webSchool.controller;

import com.rentirs.webSchool.model.Course;
import com.rentirs.webSchool.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
@Data
@AllArgsConstructor
public class CourseController {

    private CourseRepository repository;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("courses", repository.findAll());
        model.addAttribute("course", new Course());
        return "index";
    }

    @PostMapping("/")
    public String newCourse(Course course) {
        repository.save(course);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") UUID id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
