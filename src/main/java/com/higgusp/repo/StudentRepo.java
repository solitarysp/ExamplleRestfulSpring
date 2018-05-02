package com.higgusp.repo;

import com.higgusp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentRepo {
    List<Student> getAll();

    Boolean update(Student student);
    Boolean create(Student student);
    Boolean delete(Integer id);
}
