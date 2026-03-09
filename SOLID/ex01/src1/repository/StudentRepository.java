package repository;

import domain.model.Student;
import java.util.Map;

public interface StudentRepository {
    void save(Student s);
    int getNextSequence();
    int count();
    Map<String, Student> all();
}
