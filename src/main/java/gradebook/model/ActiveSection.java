package gradebook.model;

/**
 * Factory methods for Section object.
 * Plays the Creator role in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
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
