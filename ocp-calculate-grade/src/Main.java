public class Main {
    public static void main(String[] args) {
        Student s  = new Student(100, 95, 90);
        s.setGradeCalculator(new GradeCalculator1());
        System.out.println("s.calculateGrade() = " + s.calculateGrade());

        /**
         * class = 변화의 단위
         *
         * 1. 변화 식별
         * 2. 변화를 클래스로 모델링
         * 3. 변화하는 것들을 포괄하는 개념 만들기 (일반화, 실체화)
         * */
    }
}