package gradebook.model;

import java.util.HashMap;

public class HashMapStudent extends ActiveStudent
{
    private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
    private static Integer lastUsedID = 0;
    
    public HashMapStudent(Integer dbID)
    {
        super(dbID);
    }
    
    @Override
    public Student createNew()
    {
        Student newStudent = new HashMapStudent(lastUsedID);
        students.put(lastUsedID++, newStudent);
        return newStudent;
    }

    @Override
    public Student findById(Integer id)
    {
        return students.get(id);
    }

    @Override
    public void save()
    {
        // Not needed for HashMap
    }

}
