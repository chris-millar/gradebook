package main.java.gradebook.model;

public abstract class ActiveClass extends Class
{
    public ActiveClass(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Course createNew();
    
    public abstract Course findById(Integer id);
    
    public abstract void save();
}
