public class Main {
    public static void main(String[] args) {

        /**
         * 1. 변화 식별(request / command)
         * 2. 변화의 단위 -> 클래스 모델링
         * 3. 변화를 포괄하는 개념 만들기 (일반화 / 실체화)
         */

        MenuItem menuItem1 = new MenuItem();
        TV tv = new TV();

        Command cmd1 = new TvPowerCmd(tv);
        menuItem1.setCommand(cmd1);

        menuItem1.buttonPressed();
        menuItem1.buttonPressed();
        menuItem1.buttonPressed();

        Paengsoo paengsoo = new Paengsoo();
        Command cmd2 = new PaengsooJumpCmd(paengsoo);
        menuItem1.setCommand(cmd2);

        menuItem1.buttonPressed();
        menuItem1.buttonPressed();
    }

    /*
    TV power ON
    TV power OFF
    TV power ON
    Paengsoo is Jumping
    Paengsoo is Jumping
   */
}