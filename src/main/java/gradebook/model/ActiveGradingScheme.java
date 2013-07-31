package main.java.gradebook.model;

/**
 * Factory methods for GradingScheme object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public abstract class ActiveGradingScheme extends GradingScheme
{
    public ActiveGradingScheme(Integer dataStoreID)
    {
        super(dataStoreID);
    }

    public abstract GradingScheme createNew();

    public abstract GradingScheme findById(Integer id);

    public abstract void save();
}
