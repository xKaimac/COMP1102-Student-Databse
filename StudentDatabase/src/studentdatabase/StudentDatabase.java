package studentdatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentDatabase { // Creates an ArrayList of Students

    public final ArrayList<Student> studentDatabase;
    public final ArrayList<Prize> prizeList = new ArrayList<Prize>();

    public StudentDatabase() { // Creates an ArrayList for storing Student objects
        studentDatabase = new ArrayList<>();
    } // StudentDatabase

    public void addStudent(String s) { // Adds a Student to the studentDatabase
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next(); // Throws away first token
        String studentNumber = vars.next();
        String familyName = vars.next();
        String givenNames = vars.next();

        switch (s.charAt(0)) { // Checks the first character of the line being read in the file
            case 'A' -> { // Adds a new Arts Student to the studentDatabase
                String major = vars.next();
                String minor = vars.next();
                studentDatabase.add(new ArtsStudent(studentNumber, familyName, givenNames, major, minor));
            } // case 'A'
            case 'M' -> { // Adds a new Medical Student to the studentDatabase
                if (vars.hasNext()) { // Checks whether a prize is present and creates the object accordingly
                    String prize = vars.next();
                    studentDatabase.add(new MedStudent(studentNumber, familyName, givenNames, prize));
                } // if
                else { // Creates a MedStudent if there is no prize
                    studentDatabase.add(new MedStudent(studentNumber, familyName, givenNames));
                }
            } // case 'M'
            case 'S' -> { // Adds a new Science Student to the studentDatabase
                studentDatabase.add(new Student(studentNumber, familyName, givenNames));
            } // case 'S'
        } // switch
    } // addStudent

    public void addResult(String s) { // Adds a Result object to a Student's results arrayList
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next(); // Throws away first token
        String studentNumber = vars.next();
        String topic = vars.next();
        String grade = vars.next();
        String score = "";
        if (vars.hasNext()) { // Checks whether a score is present in the file
            score = vars.next();
        } // if
        for (Student student : studentDatabase) { // Checks each Student in the database
            if (student.studentNumber.equals(studentNumber)) { // Assigns the Result to the correct Student by checking their studentNumber
                if (score.length() > 0) { // Checks if a score has been recorded and adds a new Result to the Student's results arrayList
                    student.results.add(new Result(topic, grade, Integer.parseInt(score)));
                } // Inside if
                else  { // Adds a new Result to the Student's results arrayList if no score has been recorded
                    student.results.add(new Result(topic, grade));
                } // else
            } // Outside if
        } // for
    } // addResult

    public void addPrize(String s) { // Adds a new Prize object to prizeList
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next(); // Throws away first token
        String prize = vars.next();
        String template = vars.next();
        int topicsRequired = Integer.parseInt(vars.next());
        prizeList.add(new Prize(prize, template, topicsRequired));
    } // addPrize
    public void awardPrize(String prize, String template, int topicsRequired) {

    } // awardPrize

    public void awardPrize() { // Frankenstein's monster
        int checkCount = 0; // Keeps track for topicsRequired
        boolean topicCheck = false; // On/Off switch to see if a topic has been matched
        Student award = null; // This is the Student to be awarded
        int prevAvgScore = 0; // Records the average score of the previously evaluated Student
        int avgScore = 0; // Records the average score of the Student currently being evaluated
        ArrayList<Integer> avgArr; // Creates an ArrayList that will store the topic scores, to be sorted later

        for (Prize p : prizeList) { // Checks each prize in prizeList
            for (Student s : studentDatabase) { // Checks each Student in studentDatabase
                avgArr = new ArrayList<Integer>(); // Stores the topic scores of Student s into an array
                for (Result r : s.results) { // Loops through each Student's results ArrayList
                    for (int i = 0; i < p.template.length(); i++) { // Goes through a topic and checks if it matches the Prize template
                        if (r.getTopic().charAt(i) == p.template.charAt(i)) { // Checks to see if Student has topics that match the template for the Prize
                            topicCheck = true;
                        } // if
                        else { // resets topicCheck if there is no topic match
                            topicCheck = false;
                            break; // ends the loop early if there is no topic match
                        } // else
                    } // Innermost for
                    if (topicCheck) { // If the topic codes matched, add 1 to checkCount
                        checkCount++;
                        topicCheck = false; // Resets topicCheck
                        avgArr.add(r.score); // Sets an element of the array to it's score, to be sorted later
                    } // if
                } // Inside for
                if (avgArr.size() > 0) { // Checks if avgArr has been populated
                    Collections.sort(avgArr); // Sorts the elements into ascending order
                    for (int i = 0; i < p.topicsRequired; i++) { // Adds the required topic scores
                        avgScore += avgArr.get(i);
                    } // for
                } // if
                avgScore = (avgScore/p.topicsRequired); // Averages the required amount of topic scores
                if (checkCount >= p.topicsRequired && avgScore > prevAvgScore) { // Checks if the Student meets the topic criteria for the prize
                    award = s; // Sets the current Student to be awarded the prize if still eligible at the end of the loop
                    prevAvgScore = avgScore;
                } // if
                avgScore = 0; // Resets the average score when a new Student is evaluated
                checkCount = 0; // Resets the checkCount when a new Student is evaluated
            } // Middle for
            if (award != null) { // If a Student has met the criteria for an award
                award.prizes.add(p); // Awards the eligible Student the current Prize
            } // if
            award = null; // Resets the student to be awarded when a new Prize is evaluated
            prevAvgScore = 0; // Sets prevAvgScore to 0 when a new Prize is evaluated
        } // Outside for
    } // awardPrize

    public void printRecords() throws IOException {  // Prints all items in studentDatabase to data/record.txt
        FileWriter fileWriter = new FileWriter("data/record.txt", true);
        for (Student s : studentDatabase) { // Checks each Student in the database
            fileWriter.write(s.toString() + "\n");
            System.out.println(s);// Calls toString() method for each Student
            for (Result r : s.results) { // Checks all Result objects within each Student's results arrayList
                fileWriter.write(r.toString() + "\n");
                System.out.println(r);// Calls toString method for each Result
            } // Inside for
            fileWriter.write("\n"); // Adds a blank line after each Student's record
            System.out.println();
        } // outside for
        fileWriter.close();
    } // printRecords

    public void clearRecords() { // Removes all elements from studentDatabase
        studentDatabase.clear();
    } // clearRecords
} // StudentDatabase
