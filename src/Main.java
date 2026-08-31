public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Student student1 = new Student(101, "Ravi", 21, "Java");
        Student student2 = new Student(102, "Priya", 22, "Python");
        service.addStudent(student1);
        service.addStudent(student2);
        Student result = service.searchStudent(101);
        if(result != null) {
            System.out.println("Student found!");
            System.out.println("name: " + result.getName());
            System.out.println("age: " + result.getAge());
            System.out.println("course: " + result.getCourse());
        }
        else {
            System.out.println("student not found");
        }
    }
}