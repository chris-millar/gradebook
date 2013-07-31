package main.java.gradebook.model;

public abstract class ActiveClass extends Class
{
    public ActiveClass(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Class createNew();
    
    public abstract Class findById(Integer id);
    
    public abstract void save();
}
