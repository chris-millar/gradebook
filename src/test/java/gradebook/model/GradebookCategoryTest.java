package gradebook.model;


import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.JUnit4;
import org.junit.Test;

//@RunWith(Suite.class)
//@SuiteClasses({GradebookCategoryTest.class, GradebookTester.class })
public class GradebookCategoryTest
{

    @Test
    public void test()
    {
        GradebookCategory category = new GradebookCategory(new Integer(5));
        category.setName("Exams");
        category.setWeight(new Integer(25));
        assertEquals("GbCategory Id should be 5", new Integer(5),
                     category.getId());
        assertEquals("GbCategory Name should be 'Exams'", new String("Exams"),
                     category.getName());
        assertEquals("GbCategory Weight should be '25'", new Integer(25),
                     category.getWeight());
    }

}
