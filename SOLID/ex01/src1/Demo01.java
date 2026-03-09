public class Demo01 {
    public static void main(String[] args) {
        String input = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";

        // Wiring
        infrastructure.FakeStudentRepository repo = new infrastructure.FakeStudentRepository();
        domain.service.DefaultStudentIdGenerator idGen = new domain.service.DefaultStudentIdGenerator(repo);
        domain.RegistrationPolicy policy = new domain.RegistrationPolicy();
        infra.ConsolePrinter printer = new infra.ConsolePrinter();

        application.OnboardingService service = new application.OnboardingService(idGen, repo, policy, printer);
        controller.StudentController controller = new controller.StudentController(service, printer);

        controller.handle(input);
    }
}
