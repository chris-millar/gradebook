package main.java.gradebook.model;

/**
 * Factory methods for Class object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
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
