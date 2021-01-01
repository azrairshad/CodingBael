package org.baeldung.web.main.rest;

import org.baeldung.web.main.domain.Employee;
import org.baeldung.web.main.exception.InvalidRequestException;
import org.baeldung.web.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/employees")
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(produces = "application/json", method=RequestMethod.GET)
    public List<Employee> findEmployees()
            throws InvalidRequestException {
        return employeeService.getEmployeeList();
    }
}
