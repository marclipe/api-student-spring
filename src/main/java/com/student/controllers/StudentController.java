package com.student.controllers;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.entities.StudentEntity;
import com.student.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("")
  public List<StudentEntity> getAllStudents() {
    return studentRepository.findAll(); 
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") UUID id) {
    StudentEntity student = studentRepository.findById(id).orElse(null);
    if (student == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<StudentEntity> createStudent(@Valid @RequestBody StudentEntity studentEntity) {
    StudentEntity savedStudent = studentRepository.save(studentEntity);
    return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentEntity> updateStudent(@PathVariable("id") UUID id,
      @RequestBody StudentEntity studentEntity) {
    StudentEntity currentStudent = studentRepository.findById(id).orElse(null);
    if (currentStudent == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    currentStudent.setName(studentEntity.getName());
    currentStudent.setEmail(studentEntity.getEmail());
    currentStudent.setPassword(studentEntity.getPassword());
    currentStudent.setDateOfBirth(studentEntity.getDateOfBirth());
    StudentEntity updatedStudent = studentRepository.save(currentStudent);
    return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") UUID id) {
    StudentEntity student = studentRepository.findById(id).orElse(null);
    if (student == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    studentRepository.delete(student);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}