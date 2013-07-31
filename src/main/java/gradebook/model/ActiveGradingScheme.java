package main.java.gradebook.model;

public abstract class ActiveGradingScheme extends GradingScheme
{
    public ActiveGradingScheme(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract GradingScheme createNew();
    
    public abstract GradingScheme findById(Integer id);
    
    public abstract void save();
}
