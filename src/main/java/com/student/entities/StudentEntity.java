package com.student.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "student")
public class StudentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "The field is required!")
  private String name;

  @NotBlank(message = "The email field cannot be blank!")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
      message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character and no whitespace")
  private String password;

  @Past(message = "The date of birth must be in the past")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateOfBirth;
}
