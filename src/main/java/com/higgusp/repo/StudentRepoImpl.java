package com.higgusp.repo;

import com.higgusp.configuration.ConnectionDB;
import com.higgusp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRepoImpl implements StudentRepo {
    @Autowired
    ConnectionDB connectionDB;
    private Connection connection = null;

    public List<Student> getAll() {
        connection = connectionDB.connection();
        List<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    public Boolean update(Student student) {
        connection = connectionDB.connection();
        String query = "UPDATE student SET name=?,age=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getId());
            Boolean result = preparedStatement.executeUpdate() > 0;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean create(Student student) {
        connection = connectionDB.connection();
        String query = "INSERT INTO student ( name, age) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            Boolean result = preparedStatement.executeUpdate() > 0;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean delete(Integer id) {
        connection = connectionDB.connection();
        String query = "DELETE FROM student WHERE  id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            Boolean result = preparedStatement.executeUpdate() > 0;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
