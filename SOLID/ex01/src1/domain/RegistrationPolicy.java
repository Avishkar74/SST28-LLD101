package domain;

import domain.model.Student;

public class RegistrationPolicy {
    public void validate(Student s) {
        // minimal rule: name non-empty
        if (s.name == null || s.name.isBlank()) {
            throw new IllegalArgumentException("name required");
        }
        // email and phone are assumed valid for sample
    }
}
