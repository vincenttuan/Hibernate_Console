package dept.orm.model;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private Long id;
    private String name;
    private Set employees = new HashSet();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getEmployees() {
        return employees;
    }

    public void setEmployees(Set employees) {
        this.employees = employees;
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee); 
    }
 
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    } 
}