class Customer {
    private String name;
    private int point;

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }
}