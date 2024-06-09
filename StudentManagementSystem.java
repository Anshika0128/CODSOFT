import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Step into the realm of knowledge and achievement with our Student Management System!");
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(students, sc);
                    break;
                case 2:
                    removeStudent(students, sc);
                    break;
                case 3:
                    searchStudent(students, sc);
                    break;
                case 4:
                    displayAllStudents(students);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(List<Student> students, Scanner scanner) {
        System.out.print("Enter your  name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student is  added successfully.");
    }

    private static void removeStudent(List<Student> students, Scanner scanner) {
        System.out.print("Enter roll number of student to remove: ");
        int rollToRemove = scanner.nextInt();
        scanner.nextLine();
        students.removeIf(student -> student.rollNumber == rollToRemove);
        System.out.println("Student is removed successfully.");
    }

    private static void searchStudent(List<Student> students, Scanner scanner) {
        System.out.print("Enter the  roll number of student you want to search: ");
        int rollToSearch = scanner.nextInt();
        scanner.nextLine();
        for (Student student : students) {
            if (student.rollNumber == rollToSearch) {
                System.out.println("Student is found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void displayAllStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
