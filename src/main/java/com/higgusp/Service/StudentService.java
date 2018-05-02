package com.higgusp.Service;

import com.higgusp.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Boolean update(Student student);
    Boolean create(Student student);
    Boolean delete(Integer id);

}
