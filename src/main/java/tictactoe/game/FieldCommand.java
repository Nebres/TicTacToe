package tictactoe.game;

import java.util.Objects;
import java.util.Scanner;

import static tictactoe.game.OutputMessage.*;


public class FieldCommand {

    private static Scanner scan = new Scanner(System.in);
    private int row;
    private int column;

    public void updateRow() {

        System.out.println(ROW_UPDATE);
        int input = scan.nextInt();
        while(input < 1 || input > 3 ) {
            System.out.println(WRONG_ROW_UPDATE);
            System.out.println(ROW_UPDATE);
            input = scan.nextInt();
        }
        setRow(input - 1);
    }

    public void updateColumn() {

        System.out.println(COLUMN_UPDATE);
        int input = scan.nextInt();
        while(input < 1 || input > 3 ) {
            System.out.println(WRONG_COLUMN_UPDATE);
            System.out.println(COLUMN_UPDATE);
            input = scan.nextInt();
        }
        setColumn(input - 1);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "FieldCommand{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldCommand)) return false;
        FieldCommand that = (FieldCommand) o;
        return getRow() == that.getRow() &&
                getColumn() == that.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }

}
