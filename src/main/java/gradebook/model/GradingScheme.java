package main.java.gradebook.model;

import java.util.HashMap;

/**
 * An algorithm for computing the "average" score and letter grade
 * for a particular student in a particular section of a particular
 * class based on the student's scores on the GradebookItem's for
 * that class.
 * Plays the role of ConcreteProduct in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public abstract class GradingScheme
{
    protected final Integer dataStoreID;
    protected HashMap<GradebookItem, Integer> scores;

    public GradingScheme(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }

    public abstract void setStudentItemScores(HashMap<GradebookItem,
                                                  Integer> scores);

    public abstract Integer calculateAvgScore();

    public abstract LetterGrade calculateLetterGrade();
}
