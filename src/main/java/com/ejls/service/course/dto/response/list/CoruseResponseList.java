package com.ejls.service.course.dto.response.list;

import java.util.ArrayList;
import java.util.List;

import com.ejls.service.course.dto.response.CourseResponse;
import com.ejls.service.course.dto.response.GenericResponse;

public class CoruseResponseList extends GenericResponse {
    private List<CourseResponse> courses;
    
    public List<CourseResponse> getCourseList() {
        if(courses == null) {
            courses = new ArrayList<>();
        }
        return this.courses;
    }

    public void add(CourseResponse course) {
        if(courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}
