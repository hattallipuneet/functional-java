package partitioning;

public class ScoreUtil {

    private static final int PASS_THRESHOLD = 40;

    public static boolean hasPassed(Student student) {
        return student.getTotalMarks() > PASS_THRESHOLD;
    }
}
