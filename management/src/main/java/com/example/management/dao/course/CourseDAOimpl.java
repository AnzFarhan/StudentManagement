package com.example.management.dao.course;

import com.example.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CourseDAOimpl implements CourseDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Course> retrieveCourse() {
        String sql = "SELECT * FROM Course";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course course = new Course();
            course.setCode(rs.getString("code"));
            course.setName(rs.getString("name"));
            course.setMark(rs.getFloat("mark"));
            course.setMinMark(rs.getInt("min_mark"));
            return course;
        });
    }

    @Override
    public Course createCourse(Course course) {
        String sql = "INSERT INTO Course (code, name, mark, min_mark) VALUES (:code, :name, :mark, :minMark)";

        // MapSqlParameterSource to set the parameters
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("code", course.getCode());
        params.addValue("name", course.getName());
        params.addValue("mark", course.getMark());
        params.addValue("minMark", course.getMinMark());

        // Execute the insert query
        jdbcTemplate.update(sql, params);

        return course;
    }

    @Override
    public List<Course> updateCourse(Course course) {
        String sql = "UPDATE course SET name = :name, mark = :mark, min_mark = minMark WHERE code = :code";

        // Create MapSqlParameterSource to set the named parameters
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("code", course.getCode());
        params.addValue("name", course.getName());
        params.addValue("mark", course.getMark());
        params.addValue("minMark", course.getMinMark());

        // Execute the update
        jdbcTemplate.update(sql, params);
        // Return the updated list of courses (or a list with the updated course)
        return retrieveCourse();
    }

    @Override
    public List<Course> deleteCourse(Course course) {
        String sql = "DELETE FROM Course WHERE code = :code";

        // Create MapSqlParameterSource to bind the named parameter
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("code", course.getCode());

        // Execute the delete operation
        jdbcTemplate.update(sql, params);

        return retrieveCourse();
    }
}
