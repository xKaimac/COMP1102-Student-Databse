package studentdatabase;

/**
 * A class that represents a Prize
 * Getters and setters with .toString() method included
 */

public class Prize{ // Creates a new Prize object
    protected String prize;
    protected String template;
    protected int topicsRequired;

    public Prize(String prize) { // Creates a new Prize object when only given name of prize
        this.prize = prize;
    } // Prize (only name)

    public Prize(String prize, String template, int topicsRequired) { // Constructor for Prize object
        this.prize = prize;
        this.template = template;
        this.topicsRequired = topicsRequired;
    } // Prize

    public String toString() { // Formats Prize information for printing
        return prize + " " + template + " " + topicsRequired;
    } // toString

    //---------------------------------------------------------------------------------------------------
    // Getters and setters
    //---------------------------------------------------------------------------------------------------

    public String getPrize() { // Gets String prize
        return this.prize;
    } // getPrize

    public void setPrize(String prize) { // Sets String prize
        this.prize = prize;
    } // setPrize

    public String getTemplate() { // Gets String template
        return this.template;
    } // getTemplate

    public void setTemplate(String template) { // Sets String template
        this.template = template;
    } // setTemplate

    public int getTopicsRequired() { // Gets int topicsRequired
        return this.topicsRequired;
    } // getTopicsRequired

    public void setTopicsRequired(int topicsRequired) { // Sets int topicsRequired
        this.topicsRequired = topicsRequired;
    } // setTopicsRequired
} // Prize
