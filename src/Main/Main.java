package Main;

import Students.Student;
import Students.StudentTypes.ArtStudent;
import Students.StudentTypes.ItStudent;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Yousef M. Y. AlSabbah
 * @author 120212265
 * <p>
 * Assignment 1 | Programming 3
 * <p>
 * Instructor: Dr. Abdelkareem Alashqar
 */
public class Main {

    //An array that consists of 100 random unique names.
    private static final String[] randomNames = {"Sophia", "Jackson", "Olivia", "Liam", "Emma", "Noah", "Ava", "Elijah", "Isabella", "Oliver", "Mia", "Lucas", "Amelia", "Mason", "Charlotte", "Ethan", "Harper", "Logan", "Evelyn", "Aiden", "Abigail", "Caden", "Emily", "Grayson", "Ella", "Michael", "Avery", "Ezra", "Scarlett", "Jacob", "Riley", "Carter", "Luna", "William", "Chloe", "James", "Sofia", "Levi", "Layla", "Gabriel", "Ellie", "Benjamin", "Nora", "Mateo", "Aubrey", "Lincoln", "Hazel", "Nicholas", "Addison", "Jaxon", "Brooklyn", "Luke", "Stella", "Isaac", "Victoria", "Anthony", "Paisley", "Dylan", "Audrey", "Wyatt", "Bella", "Sebastian", "Claire", "Henry", "Skylar", "Olivia", "Mila", "Owen", "Genesis", "Leah", "Cameron", "Aaliyah", "Leo", "Savannah", "Caroline", "Zoe", "Adam", "Aurora", "Evelyn", "Naomi", "Tristan", "Aria", "Maddox", "Lydia", "Alexa", "Brayden", "Liliana", "Nathan", "Kinsley", "Hudson", "Elliana", "Eli", "Peyton", "Eleanor", "Leilani", "Roman", "Madelyn", "Daisy", "Miles", "Alyssa", "David", "Camila", "John", "Harmony", "Israel", "Adalyn", "Mateo", "Isabelle", "Eliana", "Ezekiel"};

    public static void main(String[] args) {
        //Major
        String[] major = {"IT", "Art"};

        //Get from user how many student he wants in his app.
        int numberOfStudents;
        while (true) try {
            numberOfStudents = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students do you want to add?", "5"));
            break;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter a valid number", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
        }

        //to generate random names and majors...
        Random random = new Random();
        Student[] students = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++)
            switch (random.nextInt(major.length)) {
                case 0 ->
                        students[i] = new ItStudent(i, generateRandomNames(), major[0], generateRandomMarks(), generateRandomMarks(), generateRandomMarks());
                case 1 ->
                        students[i] = new ArtStudent(i, generateRandomNames(), major[1], generateRandomMarks(), generateRandomMarks(), generateRandomMarks());
            }

        //Saves student info into a text file.
        String file_name = "Students.txt";
        try (PrintWriter printWriter = new PrintWriter(file_name)) {

            // b.  Sort the Student objects by grade in descending order using functions
            Arrays.sort(students, (s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));

            for (Student s : students)
                printWriter.println(s + "\n\n==============\n");

            //If you are using windows this code will open text editor automatically.
            new ProcessBuilder("notepad.exe", file_name).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int generateRandomMarks() {
        return new Random().nextInt(40, 101);
    }
    private static String generateRandomNames() {
        return randomNames[new Random().nextInt(randomNames.length)];
    }
}
