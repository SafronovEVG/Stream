package com.stream_optional.employeeBookStream.service.impl;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.repository.EmployeeRepository;
import com.stream_optional.employeeBookStream.service.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void setSalaryEmployee(Integer id, Integer salary) {
        employeeRepository.find(id).setSalary(salary);
    }
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.add(employee);

    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeRepository.getAll().values().stream().
                sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public void removeEmployee(Integer id) {
        employeeRepository.remove(id);
    }

    @Override
    public Employee findEmployee(Integer id) {
        return employeeRepository.find(id);
    }


}
