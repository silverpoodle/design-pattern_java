class Printer {
    public void print1() {
        synchronized (obj1) {
            for (int i = 0; i < 3; i++)
                System.out.print(i);
        }
    }

    public synchronized void print2() {  // print2 lock 객체 지정
        for (int i = 3; i < 6; i++)
            System.out.print(i);
    }

    private final Object obj1 = new Object();
}

//한쪽은 프린터, 한쪽은 obj. -> 동기화 안 됨!!