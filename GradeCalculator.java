import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grade Calculator!");

        // Input number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create arrays to store student names, registration numbers, and grades
        String[] studentNames = new String[numStudents];
        int[] registrationNumbers = new int[numStudents];
        double[] studentGrades = new double[numStudents];

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            studentNames[i] = scanner.nextLine();
            System.out.print("Registration Number: ");
            registrationNumbers[i] = scanner.nextInt();
            System.out.print("Grade: ");
            studentGrades[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
        }

        // Compute average, highest, and lowest grades
        double sum = 0;
        double highestGrade = studentGrades[0];
        double lowestGrade = studentGrades[0];
        for (double grade : studentGrades) {
            sum += grade;
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }
        double average = sum / numStudents;

        // Output results
        System.out.println("\nAverage grade: " + average);
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);

        scanner.close();
    }
}
