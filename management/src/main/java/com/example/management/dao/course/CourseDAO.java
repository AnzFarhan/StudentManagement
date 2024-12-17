package com.example.management.dao.course;

import com.example.management.model.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> retrieveCourse(); //retrieve all course
    Course createCourse(Course course); //create new course
    List<Course>  updateCourse(Course course); //update the course
    List<Course> deleteCourse(Course course); //delete the course by code
}
