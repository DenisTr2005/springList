package denistr.springlist.service;

import denistr.springlist.exceptions.EmployeeAlreadyAddedException;
import denistr.springlist.exceptions.EmployeeNotFoundException;
import denistr.springlist.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee addEmployee(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() == 10) {
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен!");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке!");
        } else {
            employees.add(employee);
            return employee;
        }
    }

    public Employee delEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = findEmployee(firstName,lastName);
        return employees.remove(employees.indexOf(employee));
    }
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        } else {
            return employee;
        }
    }

}
