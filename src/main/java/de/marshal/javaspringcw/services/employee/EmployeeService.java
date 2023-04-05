package de.marshal.javaspringcw.services.employee;

import de.marshal.javaspringcw.entities.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getById(String id);

    Employee addEmployee(String name);

    Employee updateEmployee(String id, String name);

    Employee deleteEmployee(String id);

    Employee patchEmployee(String id, String surname, int age);
}
