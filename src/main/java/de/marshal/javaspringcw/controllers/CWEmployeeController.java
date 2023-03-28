package de.marshal.javaspringcw;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<EmployeeCW> employees = new ArrayList<>(List.of(
            new EmployeeCW("E1"),
            new EmployeeCW("E2"),
            new EmployeeCW("E3")
    ));

//    public EmployeeController() {
//        employees.addAll(Arrays.asList(
//                new Employee("Tom"),
//                new Employee("Tom1"),
//                new Employee("Tom2")
//        ));
//    }

    //    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("")
    public List<EmployeeCW> getEmployees() {
        return employees;
    }

    @PostMapping(value = "/employees") // добавляет сотрудника - для создания и генерации НОВЫХ данных
    public EmployeeCW addEmployee(@RequestBody EmployeeCW employee) {
        employees.add(employee);
        return employee;
    }

    @PutMapping("")
    public EmployeeCW addEmployee(@RequestBody String name) { // для ОБНОВЛЕНИЯ данных
        EmployeeCW employee = new EmployeeCW(name);
        employees.add(employee);
        return employee;
    }

    @DeleteMapping(value = "/employees/{id}")
    public List<EmployeeCW> deleteEmployee(@RequestParam String id) {
//        Employee employeeFromList =
//                employees.stream().filter(e -> id.equals(e.getId())).findAny().get();
//        employees.remove(employeeFromList);
//        return employees;
        Iterator<EmployeeCW> iter = employees.iterator();
        while (iter.hasNext()) {
            EmployeeCW employee = iter.next();
            if (employee.getId().equals(id)) {
                iter.remove();
                break;
            }
        }
        return employees;
    }
}
