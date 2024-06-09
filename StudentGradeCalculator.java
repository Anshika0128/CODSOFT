import java.util.Scanner;

public class StudentGradeCalculator {

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 95) {
            return "O";
        } else if (averagePercentage >= 86 && averagePercentage<= 94) {
            return "A+";
        } else if (averagePercentage >= 77 && averagePercentage<= 85) {
            return "A";
        } else if (averagePercentage >= 67 &&  averagePercentage<= 76) {
            return "B+";
        } else if (averagePercentage >= 57 &&  averagePercentage<= 66) {
            return "B";
        } else if (averagePercentage >= 48 &&  averagePercentage<= 56) {
            return "C+";
        } else if (averagePercentage >= 47 &&  averagePercentage<= 39) {
            return "C";
        } else if (averagePercentage >= 38 &&  averagePercentage<= 33) {
            return "D";
        }
        else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Let's Calculate!");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = totalMarks / (double) numSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
