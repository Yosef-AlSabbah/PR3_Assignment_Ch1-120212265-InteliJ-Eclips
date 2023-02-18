package Students.StudentTypes;

import Marks.Mark;
import Students.Student;

/**
 * @author Yousef M. Y. AlSabbah
 * @author 120212265
 * <p>
 * ItStudent class extends Student class.
 * <p>
 * The grade for ItStudent is calculated as:
 * <p>
 * grade = mid * 0.30 + project * 0.30 + final * 0.40
 */
public class ItStudent extends Student {
    private static final double[] percent = {0.30, 0.30, 0.40};

    public ItStudent(int ID, String name, String major, int midMark, int projectMark, int finalMark) {
        super(ID, name, major, new Mark("Midterm", midMark), new Mark("Project", projectMark), new Mark("Final", finalMark));
    }

    @Override
    protected void calcGrade() {
        for (int i = 0; i < marks.length; i++) {
            grade += marks[i].mark() * percent[i];
        }
    }
}
