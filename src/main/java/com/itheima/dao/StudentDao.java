package com.itheima.dao;

import com.itheima.entity.Student;

public interface StudentDao {
    public Student findStudentByUsernameAndPassword(String username, String password);
}
