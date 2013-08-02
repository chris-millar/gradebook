package gradebook.model;

/**
 * a tag applied to GradebookItems to distinguish different types of
 * GradebookItems.
 * Plays the role of ConcreteProduct in the Factory Method Pattern.
 * @author Steven Millar
 *
 */
public class GradebookCategory
{
    protected final Integer dataStoreID;

    protected String name;
    protected Integer weight;

    public GradebookCategory(Integer dataStoreID)
    {
        this.dataStoreID = dataStoreID;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public Integer getId()
    {
        return dataStoreID;
    }
}
