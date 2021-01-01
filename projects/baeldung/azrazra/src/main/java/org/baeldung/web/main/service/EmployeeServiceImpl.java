package org.baeldung.web.main.service;

import org.baeldung.web.main.dao.EmployeeRepository;

import org.baeldung.web.main.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<org.baeldung.web.main.domain.Employee> getEmployeeList() {
        List<Employee> employees = employeeRepository.findAll();
        return convertToEmployeeDTO(employees);
    }

    private List<org.baeldung.web.main.domain.Employee> convertToEmployeeDTO(List<Employee> employees) {
        List<org.baeldung.web.main.domain.Employee> employeeList = new ArrayList<>();
        for (Employee emp: employees) {
            employeeList.add(new org.baeldung.web.main.domain.Employee(emp.getEmployeeId(), emp.getName()));
        }

        //employeeList.add(new Employee("EMP100-A", "Steve Martin"));
        //employeeList.add(new Employee("EMP223-B", "Adam Schawn"));
        return employeeList;
    }


}
