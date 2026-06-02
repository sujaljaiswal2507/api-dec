package com.api_dec.service;

import com.api_dec.dto.StudentDto;
import com.api_dec.entity.Student;
import com.api_dec.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto add(StudentDto studentDto) {

        Student std = new Student();
        BeanUtils.copyProperties(studentDto,std);
        Student savedStudent = studentRepository.save(std);
        BeanUtils.copyProperties(savedStudent,studentDto);
        return studentDto;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public void updateStudent(long id, StudentDto studentDto) {

    }

    @Override
    public List<StudentDto> getAllStudents() {
        return List.of();
    }
}
