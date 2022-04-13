package com.itheima.dao.Impl;

import com.itheima.dao.StudentDao;
import com.itheima.entity.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student findStudentByUsernameAndPassword(String username, String password) {

        String sql="select * from students where username=?and password=?";
        Student student=null;
        try{
             student=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),username,password);
        }catch (EmptyResultDataAccessException e){
            return null;
        }


        return student;
    }
}
