package main.java.gradebook.model;

/**
 * Factory methods for GradebookItem object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public abstract class ActiveGradebookItem extends GradebookItem
{
    public ActiveGradebookItem(Integer dataStoreID)
    {
        super(dataStoreID);
    }

    public abstract GradebookItem createNew();

    public abstract GradebookItem findById(Integer id);

    public abstract void save();
}
