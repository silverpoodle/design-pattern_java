public class PaengsooJumpCmd implements Command{
    private Paengsoo paengsooReceiver;

    public PaengsooJumpCmd(Paengsoo paengsooReceiver) {
        this.paengsooReceiver = paengsooReceiver;
    }
    public void execute() {
        paengsooReceiver.jump();
    }
}
