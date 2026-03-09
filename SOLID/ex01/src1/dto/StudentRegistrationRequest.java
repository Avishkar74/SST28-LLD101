package dto;

public class StudentRegistrationRequest {
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public StudentRegistrationRequest(String name, String email, String phone, String program) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }

    public static StudentRegistrationRequest parse(String raw) {
        String[] parts = raw.split(";");
        String name = "", email = "", phone = "", program = "";
        for (String p : parts) {
            String[] kv = p.split("=");
            if (kv.length != 2) continue;
            switch (kv[0].trim()) {
                case "name": name = kv[1]; break;
                case "email": email = kv[1]; break;
                case "phone": phone = kv[1]; break;
                case "program": program = kv[1]; break;
            }
        }
        return new StudentRegistrationRequest(name, email, phone, program);
    }
}
