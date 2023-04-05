package de.marshal.javaspringcw.controllers.employee;

import de.marshal.javaspringcw.entities.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CWEmployeeController {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("E1"),
            new Employee("E2"),
            new Employee("E3")
    ));

//    public EmployeeController() {
//        employees.addAll(Arrays.asList(
//                new Employee("Tom"),
//                new Employee("Tom1"),
//                new Employee("Tom2")
//        ));
//    }

    //    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/cw/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping(value = "/cw/employees") // добавляет сотрудника - для создания и генерации НОВЫХ данных
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @PutMapping("/cw/employees") // Put - запрос дб идемпотентным (свойство объекта или операции при повторном применении операции
                                    // к объекту давать тот же результат, что и при первом.)
    public Employee addEmployee(@RequestBody String name) { // для ОБНОВЛЕНИЯ данных
        Employee employee = new Employee(name);
        employees.add(employee);
        return employee;
    }

    @DeleteMapping(value = "/cw/employees/{id}")
    public List<Employee> deleteEmployee(@RequestParam String id) {
//        Employee employeeFromList =
//                employees.stream().filter(e -> id.equals(e.getId())).findAny().get();
//        employees.remove(employeeFromList);
//        return employees;
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext()) {
            Employee employee = iter.next();
            if (employee.getId().equals(id)) {
                iter.remove();
                break;
            }
        }
        return employees;
    }
}
