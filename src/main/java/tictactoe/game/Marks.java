package tictactoe.game;

public enum Marks {

    playerMark(" X", 1),
    cpuMark(" O", -1),
    blankMark("  ", 0);

    public String mark;
    public int value;

    Marks(String mark, int value) {
        this.mark = mark;
        this.value = value;
    }

    public String getMark() {
        return mark;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "mark='" + mark + '\'' +
                ", value=" + value +
                '}';
    }

}


