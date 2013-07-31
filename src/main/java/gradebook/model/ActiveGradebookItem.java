package main.java.gradebook.model;

public abstract class ActiveGradebookItem extends GradebookItem
{
    public ActiveGradebookItem(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract GradebookItem createNew();
    
    public abstract GradebookItem findById(Integer id);
    
    public abstract void save();
}
