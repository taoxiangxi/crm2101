package com.bjpowernode;


import com.bjpowernode.dao.OrderDao;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021/9/8 15:38
 */
public class TestMyBatis {

    @Test
    public void testSelectStudentIf(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
   /*     student.setName("李四");*/
        student.setAge(18);
        List<Student> students=dao.selectStudentIf(student);
        students.forEach(stu-> System.out.println("学生="+stu));
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        /*     student.setName("李四");*/
        student.setAge(18);
        List<Student> students=dao.selectStudentWhere(student);
        students.forEach(stu-> System.out.println("学生="+stu));
        sqlSession.close();

    }
    @Test
    public void testFor(){
        List<Integer>list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
//        String  sql="select * from student where in id (1001,1002,1003)";
        String sql="select * from student where in";
        StringBuffer builder=new StringBuffer(sql);
        int init=0;
        int len=list.size();

        //添加开始的(
        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        //循环结尾
        builder.append(")");
        System.out.println("sql="+builder);
    }
    //循环
    @Test
    public void testSelectForeachOne(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Integer> list=new ArrayList();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students=dao.selectForeachOne(list);
        students.forEach(stu-> System.out.println("学生="+stu));
        sqlSession.close();

    }

    //循环2
    @Test
    public void testSelectForeachTwo(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> list=new ArrayList();
        list.add(new Student(1001));
        list.add(new Student(1002));
        list.add(new Student(1003));
        List<Student> students=dao.selectForeachTwo(list);
        students.forEach(stu-> System.out.println("学生="+stu));
        sqlSession.close();

    }

    //分页查询
    @Test
    public void testSelectAll(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        OrderDao dao=sqlSession.getMapper(OrderDao.class);
        //加入PageHelper的方法,分页
        //pageNum:第几页.从1开始
        //pageSize:一页中有多少行数据
        PageHelper.startPage(3,3);
        List<Student> students=dao.selectAll();
        students.forEach(stu-> System.out.println("学生="+stu));
        sqlSession.close();

    }
}
