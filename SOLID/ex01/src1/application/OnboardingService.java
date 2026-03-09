package application;

import dto.StudentRegistrationRequest;
import domain.service.StudentIdGenerator;
import repository.StudentRepository;
import domain.RegistrationPolicy;
import infra.ConsolePrinter;
import domain.model.Student;
import domain.model.Email;
import domain.model.Program;
import domain.model.StudentId;

public class OnboardingService {
    private final StudentIdGenerator idGenerator;
    private final StudentRepository repository;
    private final RegistrationPolicy policy;
    private final ConsolePrinter printer;

    public OnboardingService(StudentIdGenerator idGenerator, StudentRepository repository,
                             RegistrationPolicy policy, ConsolePrinter printer) {
        this.idGenerator = idGenerator;
        this.repository = repository;
        this.policy = policy;
        this.printer = printer;
    }

    public void onboard(StudentRegistrationRequest req) {
        // Domain value objects for validation
        Email email = new Email(req.email);
        Program program = Program.from(req.program);

        StudentId id = idGenerator.generate();
        Student student = new Student(id.getValue(), req.name, email.getValue(), req.phone, program.name());

        // Business validation
        policy.validate(student);

        repository.save(student);

        System.out.println("OK: created student " + id.getValue());
        System.out.println("Saved. Total students: " + repository.count());
        System.out.println("CONFIRMATION:");
        System.out.println(student);
        System.out.println();
        printer.printDbDump(repository);
    }
}
