package test.java.gradebook.model;

import main.java.gradebook.model.*;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

@RunWith(JUnit4.class)
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
