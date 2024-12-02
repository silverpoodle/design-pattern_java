abstract class AbstractFile {

    private String name;

    public AbstractFile(String name) {
        this.name = name;
    }

    public abstract int getSize();

}
