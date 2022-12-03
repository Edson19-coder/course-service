package com.ejls.service.course.utils;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ejls.service.course.dto.response.CourseResponse;
import com.ejls.service.course.dto.response.GenericResponse;
import com.ejls.service.course.dto.response.list.CoruseResponseList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FormatUtil {

    public static ResponseEntity<GenericResponse> fillResponse(GenericResponse genericResponse, ResponseCodes responseCode, HttpStatus status) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        genericResponse.setCode(responseCode.getCode());
        genericResponse.setMessage(responseCode.getMessage());
        log.info("End Response: {}",gson.toJson(genericResponse));
        return new ResponseEntity<GenericResponse>(genericResponse, status);
    }

    public static GenericResponse fillErrorResponse(GenericResponse genericResponse, ResponseCodes responseCode, Class<?> level) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.error("An error has ocurred: {}", responseCode.getMessage());
        genericResponse.setCode(responseCode.getCode());
        genericResponse.setMessage(responseCode.getMessage());
        log.error("End of: {}",level.getName());
        log.error("End Response: {}",gson.toJson(genericResponse));
        return genericResponse;
    }

    public static CoruseResponseList fillCourses(List<?> courses) {
        CoruseResponseList response = new CoruseResponseList();
        for(Object o : courses) {
            Object[] obj = (Object[]) o;
            CourseResponse course = new CourseResponse();
            course.setCourseId(Long.valueOf(String.valueOf(obj[0])));
            course.setName(String.valueOf(obj[1]));
            course.setStatus(String.valueOf(obj[2]));
            course.setActive(Integer.valueOf(String.valueOf(obj[3])));
            response.add(course);
        }
        return response;
    }
}
