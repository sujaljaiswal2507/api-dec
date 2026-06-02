package com.api_dec.controller;

import com.api_dec.dto.APIResponse;
import com.api_dec.dto.StudentDto;

import com.api_dec.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

     private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity< APIResponse<StudentDto>> saveStudent(@RequestBody StudentDto studentDto) {
        StudentDto std = studentService.add(studentDto);
        APIResponse<StudentDto> response = new APIResponse<>();
        if(std != null) {
            response.setMessage("created");
            response.setStatus(201);
            response.setData(std);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            response.setMessage("something went wrong");
            response.setStatus(500);
            response.setData(std);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteStudent(@RequestParam long id){
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("created");
        response.setStatus(201);
        response.setData("permanently deleted from database");
        System.out.println("hello sujal bhai");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
