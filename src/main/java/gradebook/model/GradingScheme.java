package main.java.gradebook.model;

import java.util.HashMap;

public abstract class GradingScheme
{
    protected final Integer dataStoreID;
    protected HashMap<GradebookItem, Integer> scores;
    
    public GradingScheme(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }
    
    public abstract void setStudentItemScores(HashMap<GradebookItem, Integer> scores);
    
    public abstract Integer calculateAvgScore();
    
    public abstract LetterGrade calculateLetterGrade();
}
