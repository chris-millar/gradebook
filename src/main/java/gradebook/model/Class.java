package main.java.gradebook.model;

import java.util.LinkedList;

public class Class implements GradeReport
{
    protected final Integer dataStoreID;
    
    protected LinkedList<Section> sectionsInClass;
    
    
    public Class(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }
    
    
    public void setSectionsInClass(LinkedList<Section> sections)
    {
        this.sectionsInClass = sections;
    }
    
    public void addSectionToClass(Section section)
    {
        sectionsInClass.add(section);
    }
    
    public LinkedList<Section> getSectionsInClass()
    {
        return sectionsInClass;
    }
    
    public Integer getAvgScore(GradingScheme gradeScheme)
    {
        Integer sumOfSectionsAvgScores = 0;
        
        for(Section section : sectionsInClass)
        {
            sumOfSectionsAvgScores += section.getAvgScore(gradeScheme);
        }
        
        Integer avgScore = sumOfSectionsAvgScores / sectionsInClass.size();
        return avgScore;
    }
    
    public LetterGrade getLetterGrade(GradingScheme gradeScheme)
    {
        Integer avgScore = getAvgScore(gradeScheme);
        LetterGrade grade = SimpleGrader.determineLetterGrade(avgScore);
        return grade;
    }
}
