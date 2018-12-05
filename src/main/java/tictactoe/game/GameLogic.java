package tictactoe.game;

import static tictactoe.game.OutputMessage.OCCUPIED_FIELD;


public class GameLogic {

    private Board board;
    private final GameConfig gameConfig;
    private FieldCommand fieldCommand;
    private final AiLogic aiLogic;
    private final EndRoundValidator endRoundValidator;
    private boolean isCpuTurn;
    private int turn;
    private int round = 0;
    private boolean isStart = true;

    public GameLogic(Board board, GameConfig gameConfig, FieldCommand fieldCommand, AiLogic aiLogic,
                     EndRoundValidator endRoundValidator) {
        this.board = board;
        this.gameConfig = gameConfig;
        this.fieldCommand = fieldCommand;
        this.aiLogic = aiLogic;
        this.endRoundValidator = endRoundValidator;
    }

    private void initRound(){
        board.initEmptyBoard();
        this.isCpuTurn = gameConfig.isCpuBegin();
        this.turn ++;
    }

    private void validateIsNotOccupied() {
        while (board.getGameBoard().get(fieldCommand.getRow()).get(fieldCommand.getColumn()).getValue() != 0) {
            if (!isCpuTurn) {
                System.out.println(OCCUPIED_FIELD);
                fieldCommand.updateRow();
                fieldCommand.updateColumn();
            } else {
                aiLogic.aiRun();
            }
        }
    }

    private void beginTurnInfo() {
        System.out.println("Round: " + round + "Turn: " + turn);
    }

    private void gameLoop() {

        while (!endRoundValidator.isEndRound()) {
            beginTurnInfo();

            if (!isCpuTurn) {
                board.drawBoard();
                fieldCommand.updateRow();
                fieldCommand.updateColumn();
                validateIsNotOccupied();
                board.updateBoard(fieldCommand.getRow(), fieldCommand.getColumn(), Marks.playerMark);
                board.drawBoard();
                endRoundValidator.checkIsDraw();
                endRoundValidator.checkWinCondition();
                isCpuTurn = true;
                if (gameConfig.isCpuBegin()) {
                    this.turn++;
                }
            } else {
                aiLogic.aiRun();
                validateIsNotOccupied();
                board.updateBoard(fieldCommand.getRow(), fieldCommand.getColumn(), Marks.cpuMark);
                board.drawBoard();
                endRoundValidator.checkIsDraw();
                endRoundValidator.checkWinCondition();
                isCpuTurn = false;
                if (!gameConfig.isCpuBegin()) {
                    this.turn++;
                }
            }
        }
        System.out.println("End Round"); //here will be added text about win/ lost/ draw
        this.round ++;
        this.turn = 0;
    }

    public void gameRun() {
        if (isStart) {
            GameConfig.getInstance().initGameConfig();
            board.initEmptyBoard();
            this.round ++;
            this.isStart = false;
        }

        while (round <= GameConfig.getInstance().getNumberOfRounds()) {
            initRound();
            gameLoop();
        }

        System.out.println("End Game");
        //here will be added field to storage round wining
    }

//here will be added logic to change start player each turn
}
