package employee.management.employee_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
  // Home Route
  @GetMapping("/")
  public ResponseEntity<String> home() {
    try {
      String homeMessage = "Welcome to the Employee API!\n" +
        "Available endpoints:\n" +
        "GET /api/employees - Retrieve all employees\n" +
        "POST /api/employees - Add a new employee\n" +
        "GET /api/employees/{id} - Retrieve an employee by ID\n" +
        "GET /api/employees/department/{department} - Retrieve employees by department\n" +
        "GET /api/employees/level/{level} - Retrieve employees by level\n" +
        "GET /api/employees/search?keyword= - Search employees by First Name\n" +
        "PUT /api/employees/{id} - Update a employee by ID\n" +
        "DELETE /api/employees/{id} - Delete a employee by ID";
      return ResponseEntity.ok(homeMessage);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred while accessing the home route.");
    }
  }
}
