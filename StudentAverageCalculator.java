import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentAverageCalculator {

    public static double calculateAverageGrade(String fileName) {
        double total = 0;
        int count = 0;

        try {
            Scanner input = new Scanner(new FileReader(fileName));
            while (input.hasNext()) {
                String name = input.next();
                int grade = input.nextInt();
                total += grade;
                count++;
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return (count > 0) ? (total / count) : 0;
    }

    public static void printStudentGrades(String fileName, String outputFile) {
        try {
            Scanner input = new Scanner(new FileReader(fileName));
            FileWriter writer = new FileWriter(outputFile);

            writer.write("Student Grades:\n");

            while (input.hasNext()) {
                String name = input.next();
                String grade = input.next();
                writer.write(name + ": " + grade + "\n");
            }

            double average = calculateAverageGrade(fileName);
            writer.write(String.format("Average Grade: %.2f\n", average));

            input.close();
            writer.close();

            System.out.println("Output written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error handling file.");
        }
    }

    public static void main(String[] args) {
        String inputFile = "grades.txt";
        String outputFile = "output.txt";
        printStudentGrades(inputFile, outputFile);
    }
}
