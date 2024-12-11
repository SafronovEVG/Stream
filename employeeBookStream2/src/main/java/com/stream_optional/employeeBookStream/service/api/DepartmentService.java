package com.stream_optional.employeeBookStream.service.api;

import com.stream_optional.employeeBookStream.domian.Employee;

import java.util.Collection;

public interface DepartmentService {

    void setDepartmentEmployee(Integer id, Integer department);

   Employee findMaxSalaryByDepartment(Integer department);

    Employee findMinSalaryByDepartment(Integer department);

    Collection<Employee> findAllEmployeeByDepartment(Integer department);
}
