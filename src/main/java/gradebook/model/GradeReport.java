package main.java.gradebook.model;

public interface GradeReport
{
    public Integer getAvgScore(GradingScheme algorithm);
    
    public LetterGrade getLetterGrade(GradingScheme algorithm);
}
