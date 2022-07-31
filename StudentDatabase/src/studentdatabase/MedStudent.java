package studentdatabase;

/**
 * A class that represents a Medical Student.
 * Getters and setters with .toString() method included
 */

public class MedStudent extends Student{ // Creates a new Medical Student (Now includes prizes)
    private String prize;

    public MedStudent(String studentNumber, String familyName,
                      String givenNames, String prize) { // Constructor for new Medical Student if there is a Prize in input line
        super(studentNumber, familyName, givenNames); // Sets the variables as per parent Student class
        this.prize = prize;
        degree = "Medicine";
    } // Constructor

    public MedStudent(String studentNumber, String familyName,
                      String givenNames) { // Constructor for new Medical Student if there is no Prize in input line
        super(studentNumber, familyName, givenNames); // Sets the variables as per parent Student class
        degree = "Medicine";
    } // Constructor

    @Override
    public String toString() { // Calls parent constructor's .toString() and adds prizes for Medical Students
        String s = "";
        if (this.prize != null) { // Prints the value of String Prize if it's not null
            s = "\nPrize: " + prize;
        }
        for (Prize p : prizes) { // adds each Prize from Student's Prize List
            s += "\nPrize: " + p.prize;
        } // for
        return super.toString() + s;
    } // toString

    //---------------------------------------------------------------------------------------------------
    // Getters and setters
    //---------------------------------------------------------------------------------------------------

    public void setPrize(String prize) { // Sets the value of String prize
        this.prize = prize;
    } // setPrize

    public String getPrize() { // Returns the value of String prize
        return this.prize;
    } // getPrize


} // MedStudent
