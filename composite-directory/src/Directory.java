import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractFile{

    private List<AbstractFile> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addEntry(AbstractFile component) {
        files.add(component);
    }

    @Override
    public int getSize() {

        int totalSize = 0;

        for (AbstractFile f : files) {
            totalSize += f.getSize();
        }
        return totalSize;
    }
}
