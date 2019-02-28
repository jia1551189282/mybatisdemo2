package com.mapper;

import com.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee getEmpById(@Param("id")Integer id);

    public List<Employee> getEmpByConditionTrim(Employee employee);

    public  void updateEmp(Employee employee);

    public List<Employee> getEmpByConditionForeach(@Param("ids")List<Integer> ids);

    public void addEmps(@Param("emps")List<Employee> emps);

}
