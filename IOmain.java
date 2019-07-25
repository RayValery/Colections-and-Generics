import Map.TreeMap.*;

import java.io.*;
import java.text.Format;
import java.util.*;

public class IOmain {

    private static final String source = "Grade_Book.txt";

    public static void main(String[] args) throws IOException {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        //writeFile(grades);
        //readFile();
        //readWriteByte();

        createBankAccount();
    }

    private static void createBankAccount() throws FileNotFoundException {
        Formatter formatter = new Formatter("Bank_Account.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter clientID, client Name, client Surname, client Balance: ");
        int i = 0;
        while (i < 3) {  // how many accounts will be created at once
            try {
                formatter.format("%d, %s, %s, %.2f %n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input is incorrect. Please try again");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    private static void readWriteByte() throws IOException {
        try (FileInputStream reader = new FileInputStream(source);
             FileOutputStream writer = new FileOutputStream("Grade_Book_Byte.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(c);
                writer.write(c);
            }
        }
    }

    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(IOmain.source));
        String c;
        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    private static void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) throws IOException {
        //try (FileWriter writer = new FileWriter(source)) {    // FileWriter must implements interface Closable
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {   // The same, but PrintWriter(or BufferWritter) writes files by rows; FileWriter - by bites
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("\n\n==============================\n");
                writer.write("Student: " + gradeKey.getName() + "\nAvarage grade: " + gradeKey.getAverGrade());
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("\nSubject: " + grade.getSubject() + " | " + grade.getGrade());
                }
            }
        }
    }
}
