package tictactoe.game;

import java.util.*;

import static tictactoe.game.OutputMessage.*;

public class Board {

    private Map<Integer, ArrayList<Marks>> gameBoard;

    public Board() {
        this.gameBoard = new HashMap<>();
    }

    public Map<Integer, ArrayList<Marks>> getGameBoard() {
        return gameBoard;
    }

    public void initEmptyBoard() {

        ArrayList<Marks> row1List = new ArrayList<>(2);
        ArrayList<Marks> row2List = new ArrayList<>(2);
        ArrayList<Marks> row3List = new ArrayList<>(2);
        Collections.addAll(row1List, Marks.blankMark, Marks.blankMark, Marks.blankMark);
        Collections.addAll(row2List, Marks.blankMark, Marks.blankMark, Marks.blankMark);
        Collections.addAll(row3List, Marks.blankMark, Marks.blankMark, Marks.blankMark);
        gameBoard.put(0, row1List);
        gameBoard.put(1, row2List);
        gameBoard.put(2, row3List);
    }

    public void drawBoard() {
        System.out.println(LONG_SPACE.concat(ROW_I).concat(SHORT_SPACE).concat(ROW_II).concat(SHORT_SPACE).concat(ROW_III)
                .concat(NEW_LINE).concat(COLUMN_A).concat(gameBoard.get(0).get(0).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(0).get(1).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(0).get(2).getMark()).concat(NEW_LINE).concat(LONG_SPACE).concat(ROW_SEPARATOR)
                .concat(NEW_LINE).concat(COLUMN_B).concat(gameBoard.get(2).get(0).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(1).get(1).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(1).get(2).getMark()).concat(NEW_LINE).concat(LONG_SPACE).concat(ROW_SEPARATOR)
                .concat(NEW_LINE).concat(COLUMN_C).concat(gameBoard.get(2).get(0).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(2).get(1).getMark()).concat(COLUMN_SEPARATOR)
                .concat(gameBoard.get(2).get(2).getMark()));
    }

    public boolean updateBoard(int key, int index, Marks mark) {
        try {
            gameBoard.get(key).set(index, mark);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board = (Board) o;
        return Objects.equals(getGameBoard(), board.getGameBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameBoard());
    }

    @Override
    public String toString() {
        return "Board{" +
                "gameBoard=" +  gameBoard +
                '}';
    }

}
