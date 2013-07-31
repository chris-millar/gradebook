package main.java.gradebook.model;

public abstract class ActiveStudent extends Student
{
    public ActiveStudent(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Student createNew();
    
    public abstract Student findById(Integer id);
    
    public abstract void save();
}
