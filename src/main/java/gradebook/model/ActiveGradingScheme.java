package main.java.gradebook.model;

public abstract class ActiveGradingScheme extends GradingScheme
{
    public ActiveGradingScheme(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Course createNew();
    
    public abstract Course findById(Integer id);
    
    public abstract void save();
}
