package com.ejls.service.course.dto.response;

import lombok.Data;

@Data
public class CourseResponse {
    private Long courseId;
    private String name;
    private String status;
    private Integer active;
}
