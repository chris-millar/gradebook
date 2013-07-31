package main.java.gradebook.model;

import java.util.LinkedList;

public class Course implements GradeReport
{
    protected final Integer dataStoreID;
    
    protected String subject;
    protected Integer courseNumber;
    protected String courseName;
    protected LinkedList<Course> preReqCourses;
    protected LinkedList<Class> classesOfThisCourse;
    
    
    public Course(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }
    
    
    public String getSubject()
    {
        return this.subject;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public Integer getCourseNumber()
    {
        return this.courseNumber;
    }
    
    public void setCourseNumber(Integer number)
    {
        this.courseNumber = number;
    }
    
    public String getCourseName()
    {
        return this.courseName;
    }
    
    public void setCourseName(String name)
    {
        this.courseName = name;
    }
    
    public LinkedList<Course> getPreReqCourses()
    {
        return this.preReqCourses;
    }
    
    public void setPreReqCourses(LinkedList<Course> preReqCourses)
    {
        this.preReqCourses = preReqCourses;
    }
    
    public void addPreReqCourse(Course preReq)
    {
        preReqCourses.add(preReq);
    }
    
    
    public Integer getAvgScore(GradingScheme gradeScheme)
    {
        Integer sumOfSectionsAvgScores = 0;
        
        for(Class aClass : classesOfThisCourse)
        {
            sumOfSectionsAvgScores += aClass.getAvgScore(gradeScheme);
        }
        
        Integer avgScore = sumOfSectionsAvgScores / classesOfThisCourse.size();
        return avgScore;
    }
    
    public LetterGrade getLetterGrade(GradingScheme gradeScheme)
    {
        Integer avgScore = getAvgScore(gradeScheme);
        LetterGrade grade = SimpleGrader.determineLetterGrade(avgScore);
        return grade;
    }
}
