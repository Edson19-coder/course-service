package com.ejls.service.course.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejls.service.course.dto.request.CourseRequest;

@Repository
public interface CourseRepository {
    Boolean createCourse(CourseRequest request);
    Boolean updateCourse(CourseRequest request);
    Boolean deleteCourse(CourseRequest request);
    List<?> getCourse(CourseRequest request);
    List<?> getCourses();
}
