import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class StudentTest {
    private static Student st0, st1, st2, st3;
    private static ArrayList<Integer> m1, m2, m3;

    @BeforeAll
    public static void randomizeMarks() {
        m1 =  new ArrayList<Integer>();
        m2 =  new ArrayList<Integer>();
        m3 =  new ArrayList<Integer>();
        Random rand = new Random();

        for(int i = 0; i < 10; i++) {
            m1.add(rand.nextInt((5 - 2) + 1) + 2);
            m2.add(rand.nextInt((5 - 2) + 1) + 2);
            m3.add(5);
        }
    }

    @BeforeAll
    public static void createNewStudent() {
        st0 = new Student("", "", "", 0, "", null);
        st1 = new Student("Husak", "Vladyslav", "Yanovych", 20, "IKM-219a", m1);
        st2 = new Student("Smith", "John", "David", 25, "KK213", m2);
        st3 = new Student("Shevchenko", "Taras", "Hryhorovych", 208, "DF-21", m3);
    }

    @Test
    public void getFullNameShouldReturnFullName() throws IncorrectUsernameException {
        Assertions.assertEquals(st1.getLastName() + " " + st1.getFirstName() + " " + st1.getPatronymic(), st1.getFullName());
    }

    @Test
    public void getFullNameShouldThrowException() {
        Exception e = Assertions.assertThrows(
                IncorrectUsernameException.class,
                () -> st0.getFullName()
        );

        Assertions.assertEquals("Incorrect username", e.getMessage());
    }

    @Test
    public void isAdultShouldReturnTrue() {
        Assertions.assertEquals(true, st1.isAdult());
    }

    @Test
    public void isAdultShouldReturnFalse() {
        Assertions.assertEquals(false, st0.isAdult());
    }

    @Test
    public void getMarksAverageShouldThrowException() {
        Exception e = Assertions.assertThrows(
                RuntimeException.class,
                () -> st0.getMarksAverage()
        );

        Assertions.assertEquals("Array with marks is empty", e.getMessage());
    }

    @Test
    public void getMarksAverageShouldReturnAverageOfMarks() {
        Assertions.assertEquals(5, st3.getMarksAverage());
    }

    @Test
    public void getBetterStudentByAverageShouldReturnBetterStudent() {
        Assertions.assertEquals(st3, Student.getBetterStudentByAverage(st1, st2, st3));
    }

    @Test
    public void isExcellentStudentShouldReturnTrue() {
        Assertions.assertEquals(true, st3.isExcellentStudent());
    }

    @Test
    public void isExcellentStudentShouldReturnFalse() {
        Assertions.assertEquals(false, st1.isExcellentStudent());
    }

    @Test
    public void isExcellentStudentShouldThrowException() {
        Exception e = Assertions.assertThrows(
                RuntimeException.class,
                () -> st0.getMarksAverage()
        );

        Assertions.assertEquals("Array with marks is empty", e.getMessage());
    }
}
