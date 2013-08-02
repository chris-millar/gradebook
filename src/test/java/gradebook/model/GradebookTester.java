package gradebook.model;

import java.util.LinkedList;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//@RunWith(JUnit4.class)
public class GradebookTester
{
    //GradingScheme testSchemeOne;
    //GradingScheme testSchemeTwo;
    
    final Integer IGNORE = 0;
    
    GradebookItem examOne;
    GradebookItem examTwo;
    GradebookItem homeworkOne;
    GradebookItem homeworkTwo;
    GradebookItem homeworkThree;
    GradebookItem quizOne;
    
    GradebookCategory quizzes;
    GradebookCategory exams;
    GradebookCategory homeworks;
    
    LinkedList<String> listOfNames;;
    

    public void setupItmesAndSchemes()
    {
        Integer dbID = 0;
        
        quizzes = new GradebookCategory(dbID++);
        quizzes.setName("Quizzes");
        quizzes.setWeight(new Integer(35));
        
        exams = new GradebookCategory(dbID++);
        exams.setName("Exams");
        exams.setWeight(new Integer(50));
        
        homeworks = new GradebookCategory(dbID++);
        homeworks.setName("Homeworks");
        homeworks.setWeight(new Integer(15));
        
        
        
        quizOne = new GradebookItem(dbID++);
        quizOne.setName("Pop Quiz");
        quizOne.setCategory(quizzes);
        
        
        examOne = new GradebookItem(dbID++);
        examOne.setName("Midterm 1");
        examOne.setCategory(exams);
        
        examTwo = new GradebookItem(dbID++);
        examTwo.setName("Midterm 2");
        examTwo.setCategory(exams);
        
        
        homeworkOne = new GradebookItem(dbID++);
        homeworkOne.setName("Homework 1");
        homeworkOne.setCategory(homeworks);
        
        homeworkTwo = new GradebookItem(dbID++);
        homeworkTwo.setName("Homework 2");
        homeworkTwo.setCategory(homeworks);
        
        homeworkThree = new GradebookItem(dbID++);
        homeworkThree.setName("Homework 3");
        homeworkThree.setCategory(homeworks);
    }
    
    public void setupListOfNames()
    {
        listOfNames = new LinkedList<String>();
        listOfNames.add("Alex");
        listOfNames.add("Bob");
        listOfNames.add("Cam");
        listOfNames.add("Dave");
        listOfNames.add("Eli");
        listOfNames.add("Gary");
        listOfNames.add("Hank");
        listOfNames.add("Joe");
        listOfNames.add("Kim");
        listOfNames.add("Liv");
        listOfNames.add("Ned");
        listOfNames.add("Pat");
        listOfNames.add("Rob");
        listOfNames.add("Sue");
        listOfNames.add("Tom");
        listOfNames.add("Will");        
    }
     
    public LinkedList<Student> buildListOfStudents(int numStudents)
    {
        LinkedList<Student> students = new LinkedList<Student>();
        
        for (int i = 1; i <= numStudents; i++)
        {
            HashMap<GradebookItem, Integer> scores = new HashMap<GradebookItem, Integer>();
            scores.put(homeworkOne, 15*i + 10);
            scores.put(homeworkTwo, 10*i + 15);
            scores.put(homeworkThree, i*i + 12);
            scores.put(examOne, 90 - 5*i);
            scores.put(examTwo, 65 - 3*i);
            scores.put(quizOne, 5*i + 3*i);
            
            Student s = new Student(i);
            s.setName(listOfNames.get(i));
            s.setAllScores(scores);
            
            students.add(s);
        }
        
        return students;
    }
    
    public LinkedList<Section> buildListOfSections(int[] numStudentsPerSection)
    {
        LinkedList<Section> sections = new LinkedList<Section>();
        
        for (int i = 0; i < numStudentsPerSection.length; i++)
        {
            Section section = new Section(IGNORE);
            LinkedList<Student> students = buildListOfStudents(numStudentsPerSection[i]);
            section.setStudentsInSection(students);
            sections.add(section);
        }
        
        return sections;
    }
    
    public LinkedList<Class> buildListOfClasses(int[][] numStudentsPerSectionPerClass)
    {
        LinkedList<Class> classes = new LinkedList<Class>();
        
        for (int i = 0; i < numStudentsPerSectionPerClass.length; i++)
        {
            Class myClass = new Class(IGNORE);
            LinkedList<Section> sections = buildListOfSections(numStudentsPerSectionPerClass[i]);
            myClass.setSectionsInClass(sections);
            classes.add(myClass);
        }
        
        return classes;
    }
    
    
    @Before
    public void setup()
    {
        setupListOfNames();
        setupItmesAndSchemes();
    }

    @Test
    public void testStudent()
    {
        HashMap<GradebookItem, Integer> scores = new HashMap<GradebookItem, Integer>();
        scores.put(homeworkOne, 83);
        scores.put(homeworkTwo, 72);
        scores.put(homeworkThree, 91);
        scores.put(examOne, 77);
        scores.put(examTwo, 95);
        scores.put(quizOne, 86);
        
        Student student = new Student(IGNORE);
        student.setName("Chris");
        student.setAllScores(scores);
        
        GradingScheme scheme = new BasicGradingScheme(IGNORE);
        GradeReport reporter = student;
        Integer grade = reporter.getAvgScore(scheme);
        LetterGrade letter = reporter.getLetterGrade(scheme);
        //System.out.println("Grade: " + grade);
        assertEquals("Student's grade should equal 84", new Integer(84), grade);
        assertEquals("Student's Letter Grade should equal 'B'", LetterGrade.B, letter);
    }
    
    @Test
    public void testSection()
    {
        Section sectionA = new Section(IGNORE);
        Section sectionB = new Section(IGNORE);
        Section sectionC = new Section(IGNORE);
        
        sectionA.setStudentsInSection(buildListOfStudents(1));
        sectionB.setStudentsInSection(buildListOfStudents(2));
        sectionC.setStudentsInSection(new LinkedList<Student>());
        
        GradeReport reporterA = sectionA;
        GradeReport reporterB = sectionB;
        GradeReport reporterC = sectionC;
        
        GradingScheme scheme = new BasicGradingScheme(1);
        Integer gradeA = reporterA.getAvgScore(scheme);
        Integer gradeB = reporterB.getAvgScore(scheme);
        Integer gradeC = reporterC.getAvgScore(scheme);
        
        assertEquals("Section-A's grade should equal 36", new Integer(36), gradeA);
        assertEquals("Section-B's grade should equal 38", new Integer(38), gradeB);
        assertEquals("Section-C's grade should equal 0", new Integer(0), gradeC);
    }
    
    @Test
    public void testClass()
    {
        Class classA = new Class(IGNORE);
        Class classB = new Class(IGNORE);
        Class classC = new Class(IGNORE);
        
        int[][] numStudentsPerSection = {{}, {3}, {3, 2, 1}};
        
        classA.setSectionsInClass(buildListOfSections(numStudentsPerSection[0]));
        classB.setSectionsInClass(buildListOfSections(numStudentsPerSection[1]));
        classC.setSectionsInClass(buildListOfSections(numStudentsPerSection[2]));
        
        GradeReport reporterA = classA;
        GradeReport reporterB = classB;
        GradeReport reporterC = classC;
        
        GradingScheme scheme = new BasicGradingScheme(1);
        Integer gradeA = reporterA.getAvgScore(scheme);
        Integer gradeB = reporterB.getAvgScore(scheme);
        Integer gradeC = reporterC.getAvgScore(scheme);
        
        assertEquals("Class-A's grade should equal 0", new Integer(0), gradeA);
        assertEquals("Class-B's grade should equal 41", new Integer(41), gradeB);
        assertEquals("Class-C's grade should equal 38", new Integer(38), gradeC);
        
        assertEquals("Class-C's Letter Grade should equal 'F'", LetterGrade.F, reporterC.getLetterGrade(scheme));
        
        int[][] me = {{}, {3}, {3, 2, 1, 0}};
        System.out.println("me: " + me.length);
        
    }
    
    @Test
    public void testCourse()
    {
        Course courseA = new Course(IGNORE);
        
        int[][] numStudentsPerSectionPerClass = {{}, {3}, {3, 2, 1}};
        
        courseA.setClassesOfThisCourse(buildListOfClasses(numStudentsPerSectionPerClass));
        
        GradeReport reporterA = courseA;
        
        GradingScheme scheme = new BasicGradingScheme(1);
        Integer gradeA = reporterA.getAvgScore(scheme);
        
        assertEquals("Course-A's grade should equal 26", new Integer(26), gradeA);
    }
    

}
