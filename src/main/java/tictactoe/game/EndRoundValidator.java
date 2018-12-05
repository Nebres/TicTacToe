package tictactoe.game;

import java.util.Collection;
import java.util.Objects;

public class EndRoundValidator {

    final Board board;

    protected boolean isEndRound;
    protected boolean isPlayerWin;
    protected boolean isCpuWin;
    protected boolean isDraw;

    public EndRoundValidator(Board board) {
        this.board = board;
    }


    protected void checkIsDraw() {
        this.isDraw = board.getGameBoard()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .allMatch(marks -> marks.getValue() != 0);
        if (isDraw) {this.isEndRound = true;}
    }

    private int sumValueInRow(int row) {
        return board.getGameBoard()
                .get(row)
                .stream()
                .mapToInt(Marks::getValue)
                .sum();
    }

    private int sumValueInColumn(int column) {
        return board.getGameBoard()
                .values()
                .stream()
                .mapToInt(marks -> marks.get(column).getValue())
                .sum();
    }

    private int sumSlantUpToDown() {
        int result = 0;
        for (int i = 0; i < 3; i++){
            int value = board.getGameBoard().get(i).get(i).getValue();
            result += value;
        }
        return result;
    }

    private int sumSlantDownToUp() {
        int result = 0;
        int row = 2;
        for (int i = 0; i < 3; i++){
            int value = board.getGameBoard().get(row).get(i).getValue();
            result += value;
            row --;
        }
        return result;
    }

    private void playerWinRound() {
        this.isPlayerWin = true;
        this.isEndRound = true;
    }

    private void cpuWinRound() {
        this.isCpuWin = true;
        this.isEndRound = true;
    }

    protected void checkWinCondition() {

        for (int  i = 0; i < 3; i++) {
            if (sumValueInRow(i) == 3) {
                playerWinRound();
            } else if (sumValueInRow(i) == -3) {
                cpuWinRound();
            } else if (sumValueInColumn(i) == 3) {
                playerWinRound();
            } else if (sumValueInColumn(i) == -3) {
                cpuWinRound();
            } else if (sumSlantDownToUp() == 3) {
                playerWinRound();
            } else if (sumSlantDownToUp() == -3) {
                cpuWinRound();
            } else if (sumSlantUpToDown() == 3) {
                playerWinRound();
            } else if (sumSlantUpToDown() == -3) {
                cpuWinRound();
            }
        }
    }

    public boolean isEndRound() {
        return isEndRound;
    }

    public boolean isPlayerWin() {
        return isPlayerWin;
    }

    public boolean isCpuWin() {
        return isCpuWin;
    }

    public boolean isDraw() {
        return isDraw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndRoundValidator)) return false;
        EndRoundValidator that = (EndRoundValidator) o;
        return isEndRound() == that.isEndRound() &&
                isPlayerWin() == that.isPlayerWin() &&
                isCpuWin() == that.isCpuWin() &&
                isDraw() == that.isDraw() &&
                Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, isEndRound(), isPlayerWin(), isCpuWin(), isDraw());
    }

    @Override
    public String toString() {
        return "EndRoundValidator{" +
                "board=" + board.toString() +
                ", isEndRound=" + isEndRound +
                ", isPlayerWin=" + isPlayerWin +
                ", isCpuWin=" + isCpuWin +
                ", isDraw=" + isDraw +
                '}';
    }

}
