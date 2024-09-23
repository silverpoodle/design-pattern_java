public class Student {
    private int midScore;
    private int finalScore;
    private int hwScore;

    private GradeCalculator gradeCalculator;

    public void setGradeCalculator(GradeCalculator gradeCalculator) {
        this.gradeCalculator = gradeCalculator;
    }

    public Student(int midScore, int finalScore, int hwScore) {
        this.midScore = midScore;
        this.finalScore = finalScore;
        this.hwScore = hwScore;
    }

//    public Grade calculateGrade() {
//        double totalScore = 0.35 * midScore + 0.35 * finalScore + 0.3 * hwScore;
//
//        if (totalScore >= 85.0) return Grade.A;
//        if (totalScore >= 75.0) return Grade.B;
//        if (totalScore >= 65.0) return Grade.C;
//        if (totalScore >= 50.0) return Grade.D;
//        return Grade.F;
//    }

    public Grade calculateGrade() {
        return gradeCalculator.calculateGrade(midScore, finalScore, hwScore);
    }

    public int getMidScore() {
        return midScore;
    }

    public void setMidScore(int midScore) {
        this.midScore = midScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getHwScore() {
        return hwScore;
    }

    public void setHwScore(int hwScore) {
        this.hwScore = hwScore;
    }
}
