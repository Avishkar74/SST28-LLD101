package infra;

import repository.StudentRepository;
import domain.model.Student;
import java.util.Map;

public class ConsolePrinter {
    public void printDbDump(StudentRepository repo) {
        System.out.println("-- DB DUMP --");
        System.out.println("| ID             | NAME | PROGRAM |");
        for (Map.Entry<String, Student> e : repo.all().entrySet()) {
            Student s = e.getValue();
            // simpler spacing to match sample
            System.out.println("| " + padRight(s.id,15) + " | " + padRight(s.name,4) + " | " + padRight(s.program,6) + " |");
        }
    }

    private String padRight(String s, int n) {
        if (s == null) s = "";
        if (s.length() >= n) return s;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < n) sb.append(' ');
        return sb.toString();
    }
}
