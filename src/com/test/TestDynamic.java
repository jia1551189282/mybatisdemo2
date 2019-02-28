package com.test;

import com.domain.Employee;
import com.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDynamic {
    @Test
    public void testDynamic() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee empById = mapper.getEmpById(1);

        System.out.println("============="+empById);
        Employee employee = new Employee();
        employee.setGender("1");
        List<Employee> empByConditionTrim = mapper.getEmpByConditionTrim(employee);
        System.out.println("============="+empByConditionTrim);
        List<Employee> emps = new ArrayList<>();
        Employee employee1 = new Employee("成成","chengcheng@qq.com","1");

        Employee employee2 = new Employee("翠翠","cuicui@qq.com","1");
        emps.add(employee1);
        emps.add(employee2);
        mapper.addEmps(emps);

        sqlSession.commit();
        sqlSession.close();
    }
}
