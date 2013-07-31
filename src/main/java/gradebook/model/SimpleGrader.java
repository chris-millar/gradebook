package main.java.gradebook.model;

/**
 * Simple class with static 'determineLetterGrade()' method
 * to aid in the determination of what letter grade should
 * be awarded given an integer score between 0 and 100.
 * @author Steven Millar
 *
 */
public class SimpleGrader
{
    public static final Integer MAX_SCORE = 100;
    public static final Integer A_BORDER_B = 90;
    public static final Integer B_BORDER_C = 80;
    public static final Integer C_BORDER_D = 70;
    public static final Integer D_BORDER_F = 60;
    public SimpleGrader()
    {
    }

    public static LetterGrade determineLetterGrade(Integer avgScore)
    {
        if (avgScore == null || avgScore > MAX_SCORE || avgScore < 0)
        {
            return null;
        } else if (avgScore >= A_BORDER_B && avgScore <= MAX_SCORE)
        {
            return LetterGrade.A;
        } else if (avgScore >= B_BORDER_C && avgScore < A_BORDER_B)
        {
            return LetterGrade.B;
        } else if (avgScore >= C_BORDER_D && avgScore < B_BORDER_C)
        {
            return LetterGrade.C;
        } else if (avgScore >= D_BORDER_F && avgScore < C_BORDER_D)
        {
            return LetterGrade.D;
        } else
        {
            return LetterGrade.F;
        }
    }
}
