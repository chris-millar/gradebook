package main.java.gradebook.model;

public abstract class ActiveCourse extends Course
{
    public ActiveCourse(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Course createNew();
    
    public abstract Course findById(Integer id);
    
    public abstract void save();
}
