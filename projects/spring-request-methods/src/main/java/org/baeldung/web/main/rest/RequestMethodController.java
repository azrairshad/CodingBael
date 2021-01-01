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
@RequestMapping(value="/api")
public class RequestMethodController extends RequestMethodsBaseController{

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/employees", produces = "application/json")
    public List<Employee> findEmployees()
            throws InvalidRequestException {
        return service.getEmployeeList();
    }

    @RequestMapping(value = "/employees", produces = "application/json", method=RequestMethod.POST)
    public List<Employee> postEmployees()
            throws InvalidRequestException {
        return service.getEmployeeList();
    }
}
