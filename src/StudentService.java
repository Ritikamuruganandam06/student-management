import java.util.ArrayList;
import java.util.List;
public class StudentService {
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        if(studentExists(student.getId())) {
            System.out.println("already exists");
            return;
        }
        if(student.getId() <= 0) {
            System.out.println("invalid student id");
            return;
        }
        if(student.getAge() <= 0) {
            System.out.println("invalid age");
            return;
        }
        if(student.getCourse() == null || student.getCourse().trim().isEmpty()) {
             System.out.println("Course cannot be empty.");
            return;
        }
        if(student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Student name cannot be empty."); 
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
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
    public boolean studentExists(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
