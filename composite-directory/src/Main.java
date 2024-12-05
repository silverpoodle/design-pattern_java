public class Main {
    public static void main(String[] args) {

        Directory dir1 = new Directory("Directory1");
        File f1 = new File("File1", 200);
        File f2 = new File("File2", 300);

        Directory dir2 = new Directory("Directory2");
        Directory dir3 = new Directory("Directory3");
        File f3 = new File("File3", 100);
        File f4 = new File("File4", 50);

        dir1.addEntry(f1);
        dir1.addEntry(f2);
        dir1.addEntry(dir2);

        dir2.addEntry(dir3);
        dir2.addEntry(f3);

        dir3.addEntry(f4);

        System.out.println(dir1.getSize());
        System.out.println(dir2.getSize());
        System.out.println(dir3.getSize());
    }
}