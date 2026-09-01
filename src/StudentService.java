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
        if(students.isEmpty()) {
            System.out.println("no students found");
            return;
        }
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
    public void sortByName() {
        if(students.isEmpty()) {
            System.out.println("no students found");
            return;
        }
        students.sort((s1,s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("sorted by name");
        viewStudents();
    }
    public void findByCourse(String course) {
        boolean found = false;
        for(Student student : students) {
            if(student.getCourse().equalsIgnoreCase(course)) {
                System.out.println("id: "+student.getId());
                System.out.println("name:"+student.getName());
                System.out.println("age:"+student.getAge());
                System.out.println("course:" + student.getCourse());
                System.out.println("----------------");
                found = true;
            }
        }
        if(!found) {
            System.out.println("no students found for this course");
        }
    }
    public void showStatistics() {
        if(students.isEmpty()) {
            System.out.println("no students found");
            return;
        }
        int total = 0;
        for(Student student : students) {
            total += student.getAge();
        }
        double averageAge = (double)total / students.size();
        System.out.println("total students: "+students.size());
        System.out.println("average age: " + averageAge);
    }
}
