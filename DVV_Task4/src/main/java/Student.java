import java.util.ArrayList;

public class Student extends Person {
    private String group;
    private ArrayList<Integer> marks;

    public Student(String lastName, String firstName, String patronymic, int age, String group, ArrayList<Integer> marks) {
        super(lastName, firstName, patronymic, age);
        this.group = group;
        this.marks = marks;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public double getMarksAverage() {
        if (this.marks == null) {
            throw new RuntimeException("Array with marks is empty");
        }

        double sum = 0;

        for (Integer mark : this.marks) {
            sum += mark;
        }

        return sum / marks.size();
    }

    public static Student getBetterStudentByAverage(Student st1, Student st2, Student st3) {
        if (st1.getMarksAverage() > st2.getMarksAverage()) {
            if (st1.getMarksAverage() > st3.getMarksAverage()) {
                return st1;
            } else {
                return st3;
            }
        } else {
            if (st2.getMarksAverage() > st3.getMarksAverage()) {
                return st2;
            } else {
                return st3;
            }
        }
    }

    public boolean isExcellentStudent() {
        if (this.marks == null) {
            throw new RuntimeException("Array with marks is empty");
        }

        for (Integer mark : this.marks) {
            if (mark < 5) {
                return false;
            }
        }

        return true;
    }
}
