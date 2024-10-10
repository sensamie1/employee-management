package employee.management.employee_management.controller;

import employee.management.employee_management.entity.Employee;
import employee.management.employee_management.entity.Department;
import employee.management.employee_management.entity.Level;
import employee.management.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // Create a new employee
  @PostMapping
  public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
    Employee savedEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.ok(savedEmployee);
  }

  // Get all employees
  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = employeeService.getAllEmployees();
    return ResponseEntity.ok(employees);
  }

  // Get employee by ID
  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
    return employeeOpt.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Update employee by ID
  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
    try {
      Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
      return ResponseEntity.ok(updatedEmployee);
    } catch (RuntimeException ex) {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete employee by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    try {
      employeeService.deleteEmployee(id);
      return ResponseEntity.noContent().build();
  } catch (RuntimeException ex) {
      return ResponseEntity.notFound().build();
    }
  }

  // Find employees by department
  @GetMapping("/department/{department}")
  public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Department department) {
    List<Employee> employees = employeeService.findEmployeesByDepartment(department);
    return ResponseEntity.ok(employees);
  }

  // Find employees by level
  @GetMapping("/level/{level}")
  public ResponseEntity<List<Employee>> getEmployeesByLevel(@PathVariable Level level) {
    List<Employee> employees = employeeService.findEmployeesByLevel(level);
    return ResponseEntity.ok(employees);
  }

  // Search employees by first name keyword
  @GetMapping("/search")
  public ResponseEntity<List<Employee>> searchEmployeesByFirstName(@RequestParam String keyword) {
      List<Employee> employees = employeeService.searchEmployeesByFirstName(keyword);
      return ResponseEntity.ok(employees);
  }
}
