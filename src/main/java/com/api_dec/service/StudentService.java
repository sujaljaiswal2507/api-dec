package com.api_dec.service;

import com.api_dec.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public StudentDto add(StudentDto studentDto);
    public void deleteStudent(long id);
    public void updateStudent(long id, StudentDto studentDto);
    public List<StudentDto> getAllStudents();

}
