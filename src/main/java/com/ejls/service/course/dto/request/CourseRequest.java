package com.ejls.service.course.dto.request;

import lombok.Data;

@Data
public class CourseRequest {
    private Long courseId;
    private String name;
    private String status;
    private Integer active;
}
