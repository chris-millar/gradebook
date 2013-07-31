package main.java.gradebook.model;

public class SimpleGrader
{
    public SimpleGrader()
    {    
    }
    
    public static LetterGrade determineLetterGrade(Integer avgScore)
    {
        if (avgScore == null || avgScore > 100 || avgScore < 0)
        {
            return null;
        }
        else if (avgScore >= 90 && avgScore <= 100)
        {
            return LetterGrade.A;
        }
        else if (avgScore >= 80 && avgScore < 90)
        {
            return LetterGrade.B;
        }
        else if (avgScore >= 70 && avgScore < 80)
        {
            return LetterGrade.C;
        }
        else if (avgScore >= 60 && avgScore < 70)
        {
            return LetterGrade.D;
        }
        else
        {
            return LetterGrade.F;
        }
    }
}
