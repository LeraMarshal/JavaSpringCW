package de.marshal.javaspringcw.services;

import de.marshal.javaspringcw.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("E1"),
            new Employee("E1"),
            new Employee("E1")
    ));

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getById(String id) {
        return employees.stream()
                .filter(e -> Objects.equals(id, e.getId()))
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(String name) {
        Employee employee = new Employee(name);
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String id){
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            Employee employee = it.next();

            if (Objects.equals(employee.getId(), id)){
                it.remove();

                return employee;
            }
        }
        return  null;
    }
}
