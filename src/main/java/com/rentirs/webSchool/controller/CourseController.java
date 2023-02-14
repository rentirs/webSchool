package com.rentirs.webSchool.controller;

import com.rentirs.webSchool.model.Course;
import com.rentirs.webSchool.model.User;
import com.rentirs.webSchool.repository.CourseRepository;
import com.rentirs.webSchool.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.UUID;

@Data
@AllArgsConstructor
@Controller
public class CourseController {

    private final CourseRepository repository;
    private final UserRepository userRepository;

    @GetMapping("/")
    public String indexPage(Model model, Principal principal) {
        model.addAttribute("courses", repository.findByUserUsername(principal.getName()));
        model.addAttribute("course", new Course());
        return "index";
    }

    @PostMapping("/")
    public String newCourse(Course course, Principal principal) {
        User user =userRepository.findByUsername(principal.getName()).get();
        course.setUser(user);
        repository.save(course);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") UUID id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
