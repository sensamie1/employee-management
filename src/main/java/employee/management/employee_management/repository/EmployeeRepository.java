package employee.management.employee_management.repository;

import employee.management.employee_management.entity.Employee;
import employee.management.employee_management.entity.Department;
import employee.management.employee_management.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
  // Find employee by email
  Employee findByEmail(String email);
  
  // Find all employees by department
  List<Employee> findByDepartment(Department department);

  // Find all employees by level
  List<Employee> findByLevel(Level level);
  
  // Find employees with first name containing a keyword (case-insensitive)
  List<Employee> findByFirstNameContainingIgnoreCase(String keyword);

}
