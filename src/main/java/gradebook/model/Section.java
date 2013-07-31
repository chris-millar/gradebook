package main.java.gradebook.model;

import java.util.LinkedList;

/**
 * A list of students enrolled in a particular class.
 * Plays the role of ConcreteProduct in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public class Section implements GradeReport
{
    protected final Integer dataStoreID;

    protected LinkedList<Student> studentsInSection;


    public Section(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }


    public void setStudentsInSection(LinkedList<Student> studentsInSection)
    {
        this.studentsInSection = studentsInSection;
    }

    public LinkedList<Student> getStudentsInSection()
    {
        return studentsInSection;
    }

    public void addStudentToSection(Student newStudent)
    {
        studentsInSection.add(newStudent);
    }

    public Integer getAvgScore(GradingScheme gradeScheme)
    {
        Integer sumOfStudentAvgScores = 0;

        for (Student student : studentsInSection)
        {
            sumOfStudentAvgScores += student.getAvgScore(gradeScheme);
        }

        Integer avgScore = sumOfStudentAvgScores / studentsInSection.size();
        return avgScore;
    }

    public LetterGrade getLetterGrade(GradingScheme gradeScheme)
    {
        Integer avgScore = getAvgScore(gradeScheme);
        LetterGrade grade = SimpleGrader.determineLetterGrade(avgScore);
        return grade;
    }
}
