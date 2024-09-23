public class GradeCalculator2 extends GradeCalculator {

    public Grade calculateGrade(int midScore, int finalScore, int hwScore) {
        double totalScore = 0.35 * midScore + 0.35 * finalScore + 0.3 * hwScore;

        if (totalScore >= 90.0) return Grade.A;
        if (totalScore >= 80.0) return Grade.B;
        if (totalScore >= 70.0) return Grade.C;
        if (totalScore >= 60.0) return Grade.D;
        return Grade.F;
    }
}
