package main.java.gradebook.model;

public abstract class ActiveSection extends Section
{
    public ActiveSection(Integer dataStoreID)
    {
        super(dataStoreID);
    }
    
    public abstract Section createNew();
    
    public abstract Section findById(Integer id);
    
    public abstract void save();
}
