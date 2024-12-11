package com.stream_optional.employeeBookStream.controller;

import com.stream_optional.employeeBookStream.domian.Employee;
import com.stream_optional.employeeBookStream.exception.DepartmentNotFoundException;
import com.stream_optional.employeeBookStream.service.api.DepartmentService;
import com.stream_optional.employeeBookStream.service.impl.DepartmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/set-department")
    public String setDepartmentEmployee(@RequestParam Integer id, @RequestParam Integer department) {
        try {
            departmentService.setDepartmentEmployee(id, department);
            return "Отдел у работника изменен";
        } catch (DepartmentNotFoundException e) {
            return "Такого отдела не существует";
        }
    }
    @GetMapping("/min-salary")
    public ResponseEntity<Employee> findMinSalaryByDepartment(@RequestParam Integer departmentId) {
       try {
           return ResponseEntity.ok(departmentService.findMinSalaryByDepartment(departmentId));
       } catch (DepartmentNotFoundException e) {
           return ResponseEntity.status(406).build();
       }
    }



    @GetMapping("/max-salary")
    public Employee findMaxSalaryByDepartment(@RequestParam Integer departmentId) {
        return departmentService.findMaxSalaryByDepartment(departmentId);
    }

}
