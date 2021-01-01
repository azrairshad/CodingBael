package org.baeldung.web.main.service;

import org.baeldung.web.main.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("EMP100-A", "Steve Martin"));
        employeeList.add(new Employee("EMP223-B", "Adam Schawn"));
        return employeeList;
    }
}
