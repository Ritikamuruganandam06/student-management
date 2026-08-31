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
    public void updateStudent(int id, String name, int age, String course) {
        Student student = searchStudent(id);
        if(student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("student updated successfully");
        }
        else {
            System.out.println("student not found");
        }
    }
    public void deleteStudent(int id) {
        Student student = searchStudent(id);
        if(student != null) {
            students.remove(student);
            System.out.println("student deleted successfully");
        }
        else {
            System.out.println("student not found");
        }
    }
}
