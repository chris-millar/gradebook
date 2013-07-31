package main.java.gradebook.model;


public class GradebookItem
{
    protected final Integer dataStoreID;
    
    protected String name;
    protected GradebookCategory category;
    
    public GradebookItem(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setCategory(GradebookCategory category)
    {
        this.category = category;
    }
    
    public GradebookCategory getCategory()
    {
        return category;
    }
}
