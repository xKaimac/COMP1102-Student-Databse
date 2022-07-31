package studentdatabase;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A class that represents a Student.
 * Getters and setters with .toString() method included
 */
public class Student { // Creates a new Student (default Science)
    protected String studentNumber;
    private String familyName;
    private String givenNames;
    protected String degree;
    final ArrayList<Result> results;
    final ArrayList<Prize> prizes;

    public Student(String studentNumber, String familyName, String givenNames) { // Creates a new student object
        this.studentNumber = studentNumber;
        this.familyName = familyName;
        this.givenNames = givenNames;
        degree = "Science"; // default Student is a Science student
        results = new ArrayList<Result>(); // Creates a Result array for topic results
        prizes = new ArrayList<Prize>(); // Creates a Prize array for Prizes
    } // Student no prize

    @Override
    public String toString() { // Formats the Student information for printing
        return "Academic record for " + givenNames + " " + familyName +
                " (" + studentNumber + ")\n"
                + "Degree: " + degree;
    } // toString

    //---------------------------------------------------------------------------------------------------
    // Getters and setters
    //---------------------------------------------------------------------------------------------------

    public void setStudentNumber(String studentNumber) { // setter for studentNumber
        this.studentNumber = studentNumber;
    } // setStudentNumber

    public void setFamilyName(String familyName) { // setter for familyName
        this.familyName = familyName;
    } // setFamilyName

    public void setGivenNames(String givenNames) { // setter for givenNames
        this.givenNames = givenNames;
    } // setGivenNames

    public void setDegree(String degree) { // setter for degree
        this.degree = degree;
    } // setDegree
} // Student

