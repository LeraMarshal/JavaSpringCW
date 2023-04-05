package de.marshal.javaspringcw.services.employee;

import de.marshal.javaspringcw.entities.employee.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty("app.service.employee.null")
public class NullEmployeeService implements EmployeeService{
    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getById(String id) {
        return null;
    }

    @Override
    public Employee addEmployee(String name) {
        return null;
    }

    @Override
    public Employee updateEmployee(String id, String name) {
        return null;
    }

    @Override
    public Employee deleteEmployee(String id) {
        return null;
    }

    @Override
    public Employee patchEmployee(String id, String surname, int age) {
        return null;
    }
}
