package domain.model;

public class Email {
    private final String value;

    public Email(String value) {
        // minimal validation for sample
        this.value = value == null ? "" : value;
    }

    public String getValue() {
        return value;
    }
}
