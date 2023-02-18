package Students.StudentTypes;

import Marks.Mark;
import Students.Student;

/**
 * @author Yousef M. Y. AlSabbah
 * @author 120212265
 * <p>
 * ArtStudent class extends Student class.
 * <p>
 * The grade for ArtStudent is calculated as:
 * <p>
 * grade = mid * 0.40 + report * 0.10 + final * 0.50
 */
public class ArtStudent extends Student {
    private static final double[] percent = {0.40, 0.10, 0.50};

    public ArtStudent(int ID, String name, String major, int midMark, int reportMark, int finalMark) {
        super(ID, name, major, new Mark("Midterm", midMark), new Mark("Report", reportMark), new Mark("Final", finalMark));
    }

    @Override
    protected void calcGrade() {
        for (int i = 0; i < marks.length; i++) {
            grade += marks[i].mark() * percent[i];
        }
    }
}
