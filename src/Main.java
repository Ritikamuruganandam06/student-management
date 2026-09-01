import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        while(true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("7. Sort Students by Name");
            System.out.println("8. Find Students by Course");
            System.out.print("Enter choice: ");
            int choice;
            try{
            choice = sc.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("invalid input.please enter a number");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1: {
                    System.out.println("enter student id:");
                    int id = sc.nextInt();
                    if (id <= 0) {
                        System.out.println("Invalid ID.");
                        break;
                    }
                    System.out.println("enter student name:");
                    String name = sc.next();
                    System.out.println("enter student age:");
                    int age = sc.nextInt();
                    System.out.println("enter student course:");
                    String course = sc.next();
                    Student student = new Student(id, name, age, course);
                    service.addStudent(student);
                    break;
                }
                case 2 : {
                    service.viewStudents();
                    break;
                }
                case 3: {
                     System.out.print("Enter student id to search: ");
                     int id = sc.nextInt();
                     Student result = service.searchStudent(id);
                    if(result != null) {
                    System.out.println("Student found!");
                    System.out.println("name: " + result.getName());
                    System.out.println("age: " + result.getAge());
                    System.out.println("course: " + result.getCourse());
                    }
                    else {
                        System.out.println("student not found");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter student id to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter new course: ");
                    String course = sc.nextLine();
                    service.updateStudent(id,name,age,course);
                    break;
                }
                case 5: {
                    System.out.print("Enter student id to delete: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    return;
                }
                case 7: {
                    service.sortByName();
                    break;
                }
                case 8: {
                    sc.nextLine();
                    System.out.println("enter course");
                    String course = sc.nextLine();
                    service.findByCourse(course);
                    break;
                }
                default :
                System.out.println("invalid choice");
            }
        }
       
    }
}