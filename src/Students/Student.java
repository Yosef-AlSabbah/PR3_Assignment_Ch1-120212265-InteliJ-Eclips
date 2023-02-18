package Students;

import Marks.Mark;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

/**
 * @author Yousef M. Y. AlSabbah
 * @author 120212265
 * <p>
 * Abstract class Student that includes the following hidden attributes:
 * «get» id(int) {readonly},
 * «get/set» name(String),
 * «get/set» major(String),
 * «get» grade(double) {readonly}.
 */
public abstract class Student {
    private final int ID;
    private String name, major;
    protected double grade = 0;

    protected final Mark[] marks;

    public Student(int ID, @NotNull String name, @NotNull String major, @NotNull Mark... marks) {
        this.ID = ID;
        this.name = name;
        this.major = major;
        this.marks = marks;
        calcGrade();
    }

    /**
     * Every child class must implement this method in his own way,
     * his own mark percentages
     */
    protected abstract void calcGrade();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ID: ").append(ID).append("\nName: ").append(name).append("\nMajor: ").append(major).append("\n").append("- Student marks");
        for (Mark mark : marks)
            result.append("\n").append(mark);

        // DecimalFormat will make the grade result show in more readable way.
        double resultGrade = Double.parseDouble(new DecimalFormat(".#").format(grade));
        return result.append("\nGrade: ").append(resultGrade).append("\nStatus: ").append(resultGrade >= 60.0 ? "Pass" : "Fail").toString();
    }

    public double getGrade() {
        return grade;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(@NotNull String major) {
        this.major = major;
    }
}
