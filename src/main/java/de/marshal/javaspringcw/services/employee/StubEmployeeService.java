package de.marshal.javaspringcw.services.employee;

import de.marshal.javaspringcw.entities.employee.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
@ConditionalOnProperty("app.service.employee.stub")
// Обьект этого класса будет инстанцирован спрингом в зависимости от свойства properties
public class StubEmployeeService implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("E1"),
            new Employee("E1"),
            new Employee("E1")
    ));

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
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

    @Override
    public Employee updateEmployee(String id, String name) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();

            if (Objects.equals(employee.getId(), id)) {
                employee.setName(name);

                return employee;
            }
        }

        return null;
    }

    public Employee deleteEmployee(String id) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();

            if (Objects.equals(employee.getId(), id)) {
                it.remove();

                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee patchEmployee(String id, String surname, int age) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();

            if (Objects.equals(employee.getId(), id)) {
                employee.setSurname(surname);
                employee.setAge(age);

                return employee;
            }
        }
        return null;
    }
}
