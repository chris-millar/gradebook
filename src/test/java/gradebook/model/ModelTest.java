package test.java.gradebook.model;
import main.java.gradebook.model.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest
{

    @Test
    public void test()
    {
        GradebookCategory category = new GradebookCategory(new Integer(5));
        category.setName("Exams");
        category.setWeight(new Integer(25));
        assertEquals("GbCategory Id should be 5", new Integer(5), category.getId());
        assertEquals("GbCategory Name should be 'Exams'", new String("Exams"), category.getName());
        assertEquals("GbCategory Weight should be '25'", new Integer(24), category.getWeight());
    }

}
