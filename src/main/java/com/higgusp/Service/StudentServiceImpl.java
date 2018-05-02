package com.higgusp.Service;

import com.higgusp.entity.Student;
import com.higgusp.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    public Boolean update(Student student) {
        return studentRepo.update(student);
    }

    public Boolean create(Student student) {
        return studentRepo.create(student);
    }

    public Boolean delete(Integer id) {
        return studentRepo.delete(id);
    }
}
