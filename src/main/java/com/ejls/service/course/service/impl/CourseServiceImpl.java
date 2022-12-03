package com.ejls.service.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ejls.service.course.dto.request.CourseRequest;
import com.ejls.service.course.dto.response.GenericResponse;
import com.ejls.service.course.repository.CourseRepository;
import com.ejls.service.course.service.CourseService;
import com.ejls.service.course.utils.FormatUtil;
import com.ejls.service.course.utils.ResponseCodes;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseEntity<?> createCourse(CourseRequest request) {
        GenericResponse response = new GenericResponse();
        
        if(request.getName() == null || request.getName().equals("")) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.BAD_REQUEST, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.BAD_REQUEST, HttpStatus.CONFLICT);
        }

        if(!courseRepository.createCourse(request)) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.CREATED_FAILED, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.CREATED_FAILED, HttpStatus.CONFLICT);
        }

        return FormatUtil.fillResponse(response, ResponseCodes.OK_CODE, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCourse(CourseRequest request) {
        GenericResponse response = new GenericResponse();

        if((request.getName() == null || request.getName().equals("")) || (request.getStatus() == null || request.getStatus().equals("")) || 
        request.getCourseId() == null || request.getActive() == null) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.BAD_REQUEST, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.BAD_REQUEST, HttpStatus.CONFLICT);
        }

        if(!courseRepository.updateCourse(request)) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.UPDATE_FAILED, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.UPDATE_FAILED, HttpStatus.CONFLICT);
        }

        return FormatUtil.fillResponse(response, ResponseCodes.OK_CODE, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteCourse(CourseRequest request) {
        GenericResponse response = new GenericResponse();

        if(request.getCourseId() == null) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.BAD_REQUEST, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.BAD_REQUEST, HttpStatus.CONFLICT);
        }

        if(!courseRepository.deleteCourse(request)) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.DELETE_FAILED, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.DELETE_FAILED, HttpStatus.CONFLICT);
        }

        return FormatUtil.fillResponse(response, ResponseCodes.OK_CODE, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCourse(CourseRequest request) {
        GenericResponse response =  new GenericResponse();

        if(request.getCourseId() == null) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.BAD_REQUEST, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.BAD_REQUEST, HttpStatus.CONFLICT);
        }

        List<?> course = courseRepository.getCourse(request);

        if(course == null || course.isEmpty()) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.NO_DATA_FOUND, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.NO_DATA_FOUND, HttpStatus.CONFLICT);
        }

        response = FormatUtil.fillCourses(course);

        return FormatUtil.fillResponse(response, ResponseCodes.OK_CODE, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCourses() {
        GenericResponse response = new GenericResponse();
        List<?> coruses = courseRepository.getCourses();

        if(coruses == null || coruses.isEmpty()) {
            response = FormatUtil.fillErrorResponse(response, ResponseCodes.NO_DATA_FOUND, this.getClass());
            return FormatUtil.fillResponse(response, ResponseCodes.NO_DATA_FOUND, HttpStatus.CONFLICT);
        }

        response = FormatUtil.fillCourses(coruses);

        return FormatUtil.fillResponse(response, ResponseCodes.OK_CODE, HttpStatus.OK);
    }
    
}
