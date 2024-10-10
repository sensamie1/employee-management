package employee.management.employee_management.service;

import employee.management.employee_management.entity.Employee;
import employee.management.employee_management.entity.Department;
import employee.management.employee_management.entity.Level;
import employee.management.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  // Create a new employee
  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  // Retrieve all employees
  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  // Retrieve employee by ID
  @Override
  public Optional<Employee> getEmployeeById(Long id) {
    return employeeRepository.findById(id);
  }

  // Update employee details
  @Override
  public Employee updateEmployee(Long id, Employee employeeDetails) {
    Employee employee = employeeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    
    employee.setFirstName(employeeDetails.getFirstName());
    employee.setLastName(employeeDetails.getLastName());
    employee.setEmail(employeeDetails.getEmail());
    employee.setPhoneNumber(employeeDetails.getPhoneNumber());
    employee.setAddress(employeeDetails.getAddress());
    employee.setDob(employeeDetails.getDob());
    employee.setDepartment(employeeDetails.getDepartment());
    employee.setLevel(employeeDetails.getLevel());
    
    return employeeRepository.save(employee);
  }

  // Delete employee by ID
  @Override
  public void deleteEmployee(Long id) {
    Employee employee = employeeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    employeeRepository.delete(employee);
  }

  // Find employees by department
  @Override
  public List<Employee> findEmployeesByDepartment(Department department) {
    return employeeRepository.findByDepartment(department);
  }

  // Find employees by level
  @Override
  public List<Employee> findEmployeesByLevel(Level level) {
    return employeeRepository.findByLevel(level);
  }

  // Search employees by first name keyword
  @Override
  public List<Employee> searchEmployeesByFirstName(String keyword) {
    return employeeRepository.findByFirstNameContainingIgnoreCase(keyword);
  }
}
