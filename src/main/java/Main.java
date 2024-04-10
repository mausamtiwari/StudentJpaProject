import org.example.model.Student;
import org.example.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
      Student student = new Student("Alan", "Red");

        StudentRepository studentRepository = new StudentRepository();

        studentRepository.add(student);
        System.out.println("Added student: " + student);

        student = studentRepository.find(student.getId());
        System.out.println("Found student :" + student.toString());

        student.setLastName("Demir");
        studentRepository.update(student);
    }
}