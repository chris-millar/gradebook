package gradebook.model;

/**
 * Factory methods for Course object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
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
