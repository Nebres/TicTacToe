package tictactoe;

import tictactoe.game.*;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        GameConfig gameConfig = new GameConfig();
        FieldCommand fieldCommand = new FieldCommand();
        AiLogic aiLogic = new AiLogic(gameConfig, fieldCommand );
        EndRoundValidator endRoundValidator = new EndRoundValidator(board);

        new GameLogic(board, gameConfig, fieldCommand, aiLogic, endRoundValidator).gameRun();
    }
}
