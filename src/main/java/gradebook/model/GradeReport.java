package main.java.gradebook.model;

/**
 * Interface for the methods to get the average score and
 * letter grade of either a Course, Class, Section, or Student.
 * Plays the role of Component in the Composite Pattern.
 * @author Steven Millar
 *
 */
public interface GradeReport
{
    Integer getAvgScore(GradingScheme gradeScheme);

    LetterGrade getLetterGrade(GradingScheme gradeScheme);
}
