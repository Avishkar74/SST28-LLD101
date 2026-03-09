package infrastructure;

import domain.model.Student;
import repository.StudentRepository;
import java.util.LinkedHashMap;
import java.util.Map;

public class FakeStudentRepository implements StudentRepository {
    private final Map<String, Student> store = new LinkedHashMap<>();

    @Override
    public void save(Student s) {
        store.put(s.id, s);
    }

    @Override
    public int getNextSequence() {
        return store.size() + 1;
    }

    @Override
    public int count() { return store.size(); }

    @Override
    public Map<String, Student> all() { return store; }
}
