package main.java.gradebook.model;

import java.util.HashMap;


public class Student implements GradeReport
{
    protected final Integer dataStoreID;
    
    protected String name;
    protected HashMap<GradebookItem, Integer> scores;
    
    
    public Student(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public HashMap<GradebookItem, Integer> getAllScores()
    {
        return scores;
    }
    
    public void setAllScores(HashMap<GradebookItem, Integer> scores)
    {
        this.scores = scores;
    }
    
    public void addScoreForItem(GradebookItem item, Integer score)
    {
        scores.put(item, score);
    }
    
    public Integer getScoreForItem(GradebookItem item)
    {
        return scores.get(item);
    }
    
    
    public Integer getAvgScore(GradingScheme gradeScheme)
    {
        gradeScheme.setStudentItemScores(scores);
        return gradeScheme.calculateAvgScore();
    }
    
    public LetterGrade getLetterGrade(GradingScheme gradeScheme)
    {
        gradeScheme.setStudentItemScores(scores);
        return gradeScheme.calculateLetterGrade();
    }
}
