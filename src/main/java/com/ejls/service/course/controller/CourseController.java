package com.ejls.service.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejls.service.course.dto.request.CourseRequest;
import com.ejls.service.course.service.CourseService;
import com.ejls.service.course.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CourseController extends SuperController {
    
    @Autowired
    CourseService courseService;

    @PostMapping(value = Constants.CREATE_COURSE)
    public @ResponseBody ResponseEntity<?> createCourse(@RequestBody CourseRequest request) {
        executingMethodLog(log, Constants.CREATE_COURSE, request);
        return courseService.createCourse(request);
    }

    @PostMapping(value = Constants.UPDATE_COURSE)
    public @ResponseBody ResponseEntity<?> updateCourse(@RequestBody CourseRequest request) {
        executingMethodLog(log, Constants.UPDATE_COURSE, request);
        return courseService.updateCourse(request);
    }

    @PostMapping(value = Constants.DELETE_COURSE)
    public @ResponseBody ResponseEntity<?> deleteCourse(@RequestBody CourseRequest request) {
        executingMethodLog(log, Constants.DELETE_COURSE, request);
        return courseService.deleteCourse(request);
    }

    @PostMapping(value = Constants.GET_COURSE)
    public @ResponseBody ResponseEntity<?> getCourse(@RequestBody CourseRequest request) {
        executingMethodLog(log, Constants.GET_COURSE, request);
        return courseService.getCourse(request);
    }

    @PostMapping(value = Constants.GET_COURSES)
    public @ResponseBody ResponseEntity<?> getCourses() {
        executingMethodLog(log, Constants.GET_COURSES, null);
        return courseService.getCourses();
    }
}