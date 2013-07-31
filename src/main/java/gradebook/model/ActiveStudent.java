package main.java.gradebook.model;

public abstract class ActiveStudent extends Student
{
    public ActiveStudent(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Course createNew();
    
    public abstract Course findById(Integer id);
    
    public abstract void save();
}
