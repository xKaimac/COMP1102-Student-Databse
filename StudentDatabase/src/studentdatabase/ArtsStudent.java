package studentdatabase;

/**
 * A class that represents an Arts Student.
 * Getters and setters with .toString() method included
 */

public class ArtsStudent extends Student { // Creates a new Arts Student (Now includes major and minor)
    private String major;
    private String minor;

    public ArtsStudent(String studentNumber, String familyName,
                       String givenNames, String major, String minor) { // Constructor for Arts Student
        super(studentNumber, familyName, givenNames); // Sets the variables as per parent Student class
        this.major = major;
        this.minor = minor;
        degree = "Arts";
    } // Constructor

    @Override
    public String toString() { // extends the default Student print method to add a major and minor for Arts Students
        return super.toString() +
                "\nMajor: " + major + "\n" +
                "Minor: " + minor;
    } // toString

    //---------------------------------------------------------------------------------------------------
    // Getters and setters
    //---------------------------------------------------------------------------------------------------

    public String getMajor() { // Returns the value of String major
        return this.major;
    } // getMajor

    public String getMinor() { // Returns the value of String minor
        return this.minor;
    } // getMinor

    public void setMajor(String major) { // Sets the value of String major
        this.major = major;
    } // setMajor

    public void setMinor(String minor) { // Sets the value of String minor
        this.minor = minor;
    } // setMajor
} // ArtsStudent
