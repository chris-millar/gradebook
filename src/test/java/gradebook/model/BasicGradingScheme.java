package gradebook.model;

import java.util.HashMap;

import gradebook.model.GradebookItem;
import gradebook.model.GradingScheme;
import gradebook.model.LetterGrade;
import gradebook.model.SimpleGrader;

public class BasicGradingScheme extends GradingScheme
{
    private HashMap<GradebookItem, Integer> scores;
    
    public BasicGradingScheme(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    @Override
    public void setStudentItemScores(HashMap<GradebookItem, Integer> scores)
    {
        this.scores = scores;
    }

    @Override
    public Integer calculateAvgScore()
    {
        //for (GradebookItem item : scores.keySet())
        Integer sum = 0;
        for (Integer i : scores.values())
        {
            sum += i;
        }
        Integer avg = sum/scores.size();
        return avg;
    }

    @Override
    public LetterGrade calculateLetterGrade()
    {
        return SimpleGrader.determineLetterGrade(calculateAvgScore());
    }

}
