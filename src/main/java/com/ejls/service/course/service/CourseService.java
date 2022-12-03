package com.ejls.service.course.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ejls.service.course.dto.request.CourseRequest;

@Service
public interface CourseService {
    public ResponseEntity<?> createCourse(CourseRequest request);
    public ResponseEntity<?> updateCourse(CourseRequest request);
    public ResponseEntity<?> deleteCourse(CourseRequest request);
    public ResponseEntity<?> getCourse(CourseRequest request);
    public ResponseEntity<?> getCourses();
}
