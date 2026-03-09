package domain.model;

public enum Program {
    CSE, ECE, MECH, MBA;

    public static Program from(String value) {
        try {
            return Program.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return CSE; // default for sample
        }
    }
}
