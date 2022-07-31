package studentdatabase;

/**
 * A class that defines the Result of a given topic, with grade ( FL, PS, C, DN, HD) and score (0-100).
 * Includes getters and setters
 */

public class Result { // Creates an object that stores the result for each topic a Student takes
    private String topic;
    private String grade;
    int score;

    public Result(String topic, String grade) { // Constructor if no score has been recorded
        this.topic = topic;
        this.grade = grade;
    } // default Result array

    public Result(String topic, String grade, int score) { // Constructor if score has been recorded
        this.topic = topic;
        this.grade = grade;
        this.score = score;
    } // Result array

    public String toString() { // Prints the results from each topic
        if (score > 0) { // If a score has been recorded, this will print
            return "Topic: " + topic + " Result: " + grade +
                    " " + score;
        } // for
        else  // If no score has been recorded, this will print
            return "Topic: " + topic + " Result: " + grade +
                    " " + score;
        // else
    } // toString


    //---------------------------------------------------------------------------------------------------
    // Getters and setters
    //---------------------------------------------------------------------------------------------------

    public String getTopic() { // Gets String topic
        return this.topic;
    } // getTopic

    public void setTopic(String topic) { // Sets String topic
        this.topic = topic;
    } // setTopic

    public String getGrade() { // Gets String grade
        return this.grade;
    } // getGrade

    public void setGrade(String grade) { // Sets String grade
        this.grade = grade;
    } // setGrade

    public int getScore() { // Gets String score
        return this.score;
    } // getScore

    public void setScore(int score) { // Sets String score
        this.score = score;
    } // setScore
} // Result
