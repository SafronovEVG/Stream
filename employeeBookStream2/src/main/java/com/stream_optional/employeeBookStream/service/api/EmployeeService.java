package com.stream_optional.employeeBookStream.service.api;

import com.stream_optional.employeeBookStream.domian.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    void setSalaryEmployee(Integer id, Integer salary);

    void addEmployee(Employee employee);

    Map<Integer, List<Employee>> getAllEmployee();

    void removeEmployee(Integer id);

    Employee findEmployee(Integer id);

}
