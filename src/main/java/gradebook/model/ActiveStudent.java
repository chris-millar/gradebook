package main.java.gradebook.model;

/**
 * Factory methods for Student object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
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
