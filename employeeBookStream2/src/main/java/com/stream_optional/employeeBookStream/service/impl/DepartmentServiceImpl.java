package com.stream_optional.employeeBookStream.service.impl;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.exception.DepartmentNotFoundException;
import com.stream_optional.employeeBookStream.repository.EmployeeRepository;
import com.stream_optional.employeeBookStream.service.api.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findMinSalaryByDepartment(Integer department) {
        return  employeeRepository.getAll().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary)).orElseThrow(() -> new DepartmentNotFoundException());
    }

    @Override
    public Employee findMaxSalaryByDepartment(Integer department) {
        return employeeRepository.getAll().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException());
    }

    @Override
    public void setDepartmentEmployee(Integer id, Integer department) {
        if (department < 0 || department > 5) throw new DepartmentNotFoundException();
        employeeRepository.find(id).setDepartment(department);
    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartment(Integer department) {
        return employeeRepository.getAll().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

}
