package denistr.springlist.controller;

import denistr.springlist.service.Employee;
import denistr.springlist.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                        @RequestParam String lastName) {
        return employeeService.delEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                           @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/list")
    public List<Employee> employeeList() {
        return employeeService.getEmployees();
    }

}