package main.java.gradebook.model;

public class GradebookCategory
{
    protected final Integer dataStoreID;
    
    protected String name;
    protected Integer weight;
    
    public GradebookCategory(Integer dataStoreID)
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
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    public Integer getWeight()
    {
        return weight;
    }
}
