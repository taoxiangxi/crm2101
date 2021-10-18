package com.bjpowernode.dao;


import com.bjpowernode.entity.Student;

import java.util.List;

/**
 * 2021/9/8 15:07
 */
public interface StudentDao {
        //动态sql要使用Java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where的使用
    List<Student> selectStudentWhere(Student student);

    //foreach 用法 1
    List<Student> selectForeachOne(List<Integer> idList);

    //foreach 用法 2
    List<Student> selectForeachTwo(List<Student> stuList);
}


