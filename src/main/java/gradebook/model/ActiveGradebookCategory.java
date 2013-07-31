package main.java.gradebook.model;

public abstract class ActiveGradebookCategory extends GradebookCategory
{
    public ActiveGradebookCategory(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract GradebookCategory createNew();
    
    public abstract GradebookCategory findById(Integer id);
    
    public abstract void save();
}
