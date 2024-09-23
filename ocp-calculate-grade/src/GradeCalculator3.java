public class GradeCalculator3 extends GradeCalculator {

    public Grade calculateGrade(int midScore, int finalScore, int hwScore) {
        double totalScore = 0.30 * midScore + 0.40 * finalScore + 0.3 * hwScore;

        if (totalScore >= 85.0) return Grade.A;
        if (totalScore >= 75.0) return Grade.B;
        if (totalScore >= 65.0) return Grade.C;
        if (totalScore >= 50.0) return Grade.D;
        return Grade.F;
    }
}
