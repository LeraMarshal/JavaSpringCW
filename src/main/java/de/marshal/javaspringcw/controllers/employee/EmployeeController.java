package de.marshal.javaspringcw.controllers.employee;

import de.marshal.javaspringcw.entities.employee.Employee;
import de.marshal.javaspringcw.services.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees") // Чтобы все работало внутри префикса ".." => (value = "/employees")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class.getName()); // org.slf4j пакет

    // 1.
    /*
Context:
    EmployeeService -> Конкретный объект

EmployeeController
    EmployeeService <- (EmployeeService -> Конкретный объект)

Context:
    EmployeeService -> Конкретный объект
    EmployeeController -> Конкретный объект
    */

//    @Autowired // IoC (Inversion of Control) Автосвязывание эксземпляра класса EmployeeService с экземпляром класса EmployeeController
//    private EmployeeService employeeService;

    // 2.
    private EmployeeService employeeService;

    @Autowired
    // Спринг, создавая экземляр EmployeeController, идет в конструктор и подставляет в него EmployeeService из контекста
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

        log.info("EmployeeController is now initialized");
    }

    @GetMapping("/") // Обработчик для GET - запроса по пути ".."
    // ResponseEntity - Для возможности управлять статусом и заголовками
    public ResponseEntity<List<Employee>> list(
            // http://localhost:8080/employees/?id=e3019d4e-0751-4ed5-b929-aa1d97596446
            // RequestParam - параметр берется из query string (?id=1 (все, что после знака ?))
            @RequestParam(name = "id", required = false)
            String id,
            @RequestParam(name = "name", required = false)
            String name
    ) {
        List<Employee> employees = employeeService.getAllEmployees();
        if (id != null) {
            employees.removeIf(e -> !Objects.equals(id, e.getId()));
        } // удаление из списка всех работников, у которых id не совпадает с запрошенным
        if (name != null) {
            employees.removeIf(e -> !Objects.equals(name, e.getName()));
        } // удаление из списка всех работников, у которых name не совпадает с запрошенным

//        return ResponseEntity.ok() // Вернуть 200
//                .body(employeeService.getAllEmployees());

        return ResponseEntity.status(HttpStatus.OK) // Добавление заголовка со статусом 200
                .header("My-header", "Hello world!")
                .body(employees);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> patch(
            @PathVariable String id,
            @RequestParam String surname,
            @RequestParam int age
    ){
        Employee employeeToUpdate  = employeeService.patchEmployee(id, surname, age);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeToUpdate); // HttpStatus.ACCEPTED - принято
    }


    @GetMapping("/{id}") // {placeholder} - заполнитель
    // http://localhost:8080/employees/e3019d4e-0751-4ed5-b929-aa1d97596446
    public ResponseEntity<Employee> getById(@PathVariable("id") String id) { // берем из пути
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        if (employee.getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // HttpStatus.BAD_REQUEST - плохой запрос
        }

        Employee newEmployee = employeeService.addEmployee(employee.getName());
        return ResponseEntity.ok(newEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable("id") String id) {
        Employee employee = employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.updateEmployee(employee.getId(), employee.getName()));
    }
}
