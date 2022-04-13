package com.itheima.controller;

import com.itheima.dao.StudentDao;
import com.itheima.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("欢迎来到学生管理系统");
        System.out.println("请输入用户名：");

        //接受输入
        Scanner sca = new Scanner(System.in);
        String username = sca.nextLine();
        //接受密码
        System.out.println("请输入"+username+"密码");
        String password =sca.nextLine();

        // 获取AccountDao实例
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        Student student = studentDao.findStudentByUsernameAndPassword(username,password);
        if (student==null){
            System.out.println("用户登录失败，用户名或密码错误");
        }else {
            System.out.println("用户登陆成功");
            System.out.println(username+"是"+student.getCourse()+"班的");
        }
    }
}

