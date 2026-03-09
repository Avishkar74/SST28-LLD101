package domain.service;

import domain.model.StudentId;
import repository.StudentRepository;
import java.time.Year;

public class DefaultStudentIdGenerator implements StudentIdGenerator {
    private final StudentRepository repository;

    public DefaultStudentIdGenerator(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentId generate() {
        int seq = repository.getNextSequence();
        int year = Year.now().getValue();
        String value = String.format("SST-%d-%04d", year, seq);
        return new StudentId(value);
    }
}
