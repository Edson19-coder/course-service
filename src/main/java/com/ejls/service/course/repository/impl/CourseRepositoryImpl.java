package com.ejls.service.course.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceUnit;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.ejls.service.course.dto.request.CourseRequest;
import com.ejls.service.course.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceUnit(unitName="base")
    EntityManagerFactory entityManagerFactory;

    @Override
    public Boolean createCourse(CourseRequest request) {
        log.info("Executing procedure PKG_COURSE.CREATE_COURSE");
        EntityManager eManager = entityManagerFactory.createEntityManager();
        try {
            if(eManager.isOpen()) {
                StoredProcedureQuery query = eManager.createStoredProcedureQuery("PKG_COURSE.CREATE_COURSE")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
                .setParameter(1, request.getName());
                query.execute();
                @SuppressWarnings("unchecked")
                Boolean response = Boolean.parseBoolean(query.getOutputParameterValue(2).toString());
                return response;
            }
            return false;
        } catch (Exception error) {
            log.error(error.toString());
            return false;
        } finally {
            eManager.close();
        }
    }

    @Override
    public Boolean updateCourse(CourseRequest request) {
        log.info("Executing procedure PKG_COURSE.UPDATE_COURSE");
        EntityManager eManager = entityManagerFactory.createEntityManager();
        try {
            if(eManager.isOpen()) {
                StoredProcedureQuery query = eManager.createStoredProcedureQuery("PKG_COURSE.UPDATE_COURSE")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.OUT)
                .setParameter(1, request.getCourseId())
                .setParameter(2, request.getName())
                .setParameter(3, request.getStatus());
                query.execute();
                @SuppressWarnings("unchecked")
                Boolean response = Boolean.parseBoolean(query.getOutputParameterValue(4).toString());
                return response;
            }
            return false;
        } catch (Exception error) {
            log.error(error.toString());
            return false;
        } finally {
            eManager.close();
        }
    }

    @Override
    public Boolean deleteCourse(CourseRequest request) {
        log.info("Executing procedure PKG_COURSE.DELETE_COURSE");
        EntityManager eManager = entityManagerFactory.createEntityManager();
        try {
            if(eManager.isOpen()) {
                StoredProcedureQuery query = eManager.createStoredProcedureQuery("PKG_COURSE.DELETE_COURSE")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
                .setParameter(1, request.getCourseId());
                query.execute();
                @SuppressWarnings("unchecked")
                Boolean response = Boolean.parseBoolean(query.getOutputParameterValue(2).toString());
                return response;
            }
            return false;
        } catch (Exception error) {
            log.error(error.toString());
            return false;
        } finally {
            eManager.close();
        }
    }

    @Override
    public List<?> getCourse(CourseRequest request) {
        log.info("Executing procedure PKG_COURSE.GET_COURSE");
        EntityManager eManager = entityManagerFactory.createEntityManager();
        try {
            if(eManager.isOpen()) {
                StoredProcedureQuery query = eManager.createStoredProcedureQuery("PKG_COURSE.GET_COURSE")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR)
                .setParameter(1, request.getCourseId());
                query.execute();
                @SuppressWarnings("unchecked")
                List<Object[]> response = query.getResultList();
                return response;
            }
            return null;
        } catch (Exception error) {
            log.error(error.toString());
            return null;
        } finally {
            eManager.close();
        }
    }

    @Override
    public List<?> getCourses() {
        log.info("Executing procedure PKG_COURSE.GET_COURSES");
        EntityManager eManager = entityManagerFactory.createEntityManager();
        try {
            if(eManager.isOpen()) {
                StoredProcedureQuery query = eManager.createStoredProcedureQuery("PKG_COURSE.GET_COURSES")
                .registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);
                query.execute();
                @SuppressWarnings("unchecked")
                List<Object[]> response = query.getResultList();
                return response;
            }
            return null;
        } catch (Exception error) {
            log.error(error.toString());
            return null;
        } finally {
            eManager.close();
        }
    }
    
}
