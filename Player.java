package source;

public class Player {
    private String name;
    private int number;

    private int position;
    private static int playerCounter = 1;

    public Player(String name) {
        this.name = name;
        this.number = playerCounter++;
        this.position = 1; // All players start at position 1
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
    public void setPosition(int position) {
        this.position = position;
    }
}

