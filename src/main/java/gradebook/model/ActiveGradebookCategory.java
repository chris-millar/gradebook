package main.java.gradebook.model;

/**
 * Factory methods for GradebookCategory object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public abstract class ActiveGradebookCategory extends GradebookCategory
{
    public ActiveGradebookCategory(Integer dataStoreID)
    {
        super(dataStoreID);
    }

    public abstract GradebookCategory createNew();

    public abstract GradebookCategory findById(Integer id);

    public abstract void save();
}
