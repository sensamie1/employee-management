package employee.management.employee_management.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "First name is mandatory")
  @Size(max = 50)
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @NotBlank(message = "Last name is mandatory")
  @Size(max = 50)
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email should be valid")
  @Size(max = 100)
  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @NotBlank(message = "Phone number is mandatory")
  @Size(max = 20)
  @Column(name = "phone_number", nullable = false, length = 20)
  private String phoneNumber;

  @NotBlank(message = "Address is mandatory")
  @Size(max = 200)
  @Column(name = "address", nullable = false, length = 200)
  private String address;

  @NotNull(message = "Date of Birth is mandatory")
  @Column(name = "dob", nullable = false)
  private LocalDate dob;

  @NotNull(message = "Department is mandatory")
  @Enumerated(EnumType.STRING)
  @Column(name = "department", nullable = false, length = 20)
  private Department department;

  @NotNull(message = "Level is mandatory")
  @Enumerated(EnumType.STRING)
  @Column(name = "level", nullable = false, length = 20)
  private Level level;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  // Constructors

  public Employee() {
    // Default constructor required by JPA
  }

  public Employee(String firstName, String lastName, String email, String phoneNumber, String address, LocalDate dob, Department department, Level level) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.dob = dob;
    this.department = department;
    this.level = level;
  }

  // Getters and Setters

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

public void setLastName(String lastName) {
    this.lastName = lastName;
  }

public String getEmail() {
    return email;
  }

public void setEmail(String email) {
    this.email = email;
  }

public String getPhoneNumber() {
    return phoneNumber;
  }

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

public String getAddress() {
    return address;
  }

public void setAddress(String address) {
    this.address = address;
  }

public LocalDate getDob() {
    return dob;
  }

public void setDob(LocalDate dob) {
    this.dob = dob;
  }

public Department getDepartment() {
    return department;
  }

public void setDepartment(Department department) {
    this.department = department;
  }

public Level getLevel() {
    return level;
  }

public void setLevel(Level level) {
    this.level = level;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
}
