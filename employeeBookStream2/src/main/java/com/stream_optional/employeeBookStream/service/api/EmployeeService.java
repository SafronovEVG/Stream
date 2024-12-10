package com.stream_optional.employeeBookStream.service.api;

import com.stream_optional.employeeBookStream.domian.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Collection<Employee> getAllEmployee();

    void removeEmployee(Integer id);

    Employee findEmployee(Integer id);

    void setSalaryEmployee(Integer id, Integer salary);

    void setDepartmentEmployee(Integer id, Integer department);

    Optional<Employee> findMaxSalaryByDepartment(Integer department);

    Optional<Employee> findMinSalaryByDepartment(Integer department);
}
