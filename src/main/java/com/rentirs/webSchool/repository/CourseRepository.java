package com.rentirs.webSchool.repository;

import com.rentirs.webSchool.model.Course;
import com.rentirs.webSchool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<User> findCourseByUsername(String username);
}
