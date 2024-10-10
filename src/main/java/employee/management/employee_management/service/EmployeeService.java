package employee.management.employee_management.service;

import employee.management.employee_management.entity.Employee;
import employee.management.employee_management.entity.Department;
import employee.management.employee_management.entity.Level;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    
  // Create a new employee
  Employee createEmployee(Employee employee);
  
  // Retrieve all employees
  List<Employee> getAllEmployees();
  
  // Retrieve employee by ID
  Optional<Employee> getEmployeeById(Long id);
  
  // Update employee details
  Employee updateEmployee(Long id, Employee employeeDetails);
  
  // Delete employee by ID
  void deleteEmployee(Long id);
  
  // Find employees by department
  List<Employee> findEmployeesByDepartment(Department department);

  // Find employees by level
  List<Employee> findEmployeesByLevel(Level level);
  
  // Search employees by first name keyword
  List<Employee> searchEmployeesByFirstName(String keyword);
}
