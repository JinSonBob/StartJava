public class Player {
    private String name;
    private int number;

    public Player(String name) {
        this.name = name;
        this.number = 101;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}