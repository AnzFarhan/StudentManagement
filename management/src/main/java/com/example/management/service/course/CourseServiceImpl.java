package com.example.management.service.course;

import com.example.management.dao.course.CourseDAO;
import com.example.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<Course> retrieveCourse() {

        return courseDAO.retrieveCourse();
    }

    @Override
    public Course createCourse(Course course) {
        return courseDAO.createCourse(course);
    }

    @Override
    public List<Course> updateCourse(Course course) {

        return courseDAO.updateCourse(course);
    }

    @Override
    public List<Course> deleteCourse(Course course) {

        return courseDAO.deleteCourse(course);
    }
}
