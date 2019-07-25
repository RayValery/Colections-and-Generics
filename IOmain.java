import Map.TreeMap.*;

import java.io.*;
import java.util.*;

public class IOmain {

    private static final String source = "Grade_Book.txt";

    public static void main(String[] args) throws IOException {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        writeFile(grades);

        readFile();
    }

    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(IOmain.source));
        String c;
        while ((c=reader.readLine())!=null){
            System.out.println(c);
        }
    }

    private static void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) throws IOException {
        //try (FileWriter writer = new FileWriter(source)) {    // FileWriter must implements interface Closable
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {   // The same, but PrintWriter writes files by rows; FileWriter - by bites
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
