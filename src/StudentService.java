import java.util.ArrayList;
import java.util.List;
public class StudentService {
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void viewStudents() {
        for(Student student : students) {
            System.out.println("id: "+student.getId());
            System.out.println("name: "+student.getName());
            System.out.println("age: "+student.getAge());
            System.out.println("course: "+student.getCourse());
        }
    }
    public Student searchStudent(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
