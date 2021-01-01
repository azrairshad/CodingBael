package org.baeldung.web.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="EMPLOYEE")
public class Employee {

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String employeeId;
    private String name;

    @Id
    @Column(name = "employee_id")
    public String getEmployeeId() {
        return employeeId;
    }
}
