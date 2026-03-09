package controller;

import application.OnboardingService;
import dto.StudentRegistrationRequest;
import infra.ConsolePrinter;

public class StudentController {
    private final OnboardingService service;
    private final ConsolePrinter printer;

    public StudentController(OnboardingService service, ConsolePrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    public void handle(String rawInput) {
        System.out.println("=== Student Onboarding ===");
        System.out.println("INPUT: " + rawInput);
        StudentRegistrationRequest req = StudentRegistrationRequest.parse(rawInput);
        service.onboard(req);
    }
}
