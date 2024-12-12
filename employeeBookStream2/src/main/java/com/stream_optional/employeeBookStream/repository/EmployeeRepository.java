package com.stream_optional.employeeBookStream.repository;

import com.stream_optional.employeeBookStream.domian.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class EmployeeRepository {
   private final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<>();
    public void add(Employee employee) {
        EMPLOYEE_MAP.put(employee.getId(), employee);
    }

    public Map<Integer, Employee> getAll() {
        return EMPLOYEE_MAP;
    }

    public void remove(Integer id) {
        EMPLOYEE_MAP.remove(id);
    }

    public Employee find(Integer id) {
        return EMPLOYEE_MAP.get(id);
    }
}
