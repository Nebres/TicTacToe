package tictactoe.game;

import static tictactoe.game.OutputMessage.*;


public class GameLogic {

    private Board board;
    private final GameConfig gameConfig;
    private FieldCommand fieldCommand;
    private final AiLogic aiLogic;
    private final EndRoundValidator endRoundValidator;
    private boolean isCpuTurn;
    private int turn;
    private int round;
    private boolean isGameJustStart = true;

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
        this.isCpuTurn = gameConfig.getInstance().isCpuBegin();
        endRoundValidator.setCpuWin(false);
        endRoundValidator.setDraw(false);
        endRoundValidator.setEndRound(false);
        endRoundValidator.setPlayerWin(false);
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
        System.out.println(String.format(TURN_INF0, round, turn));
    }

    private void gameLoop() {

        while (!endRoundValidator.isEndRound()) {
            beginTurnInfo();

            if (!isCpuTurn) {
                System.out.println("PLAYER TURN \n");
                if (turn == 1)board.drawBoard();
                fieldCommand.updateRow();
                fieldCommand.updateColumn();
                validateIsNotOccupied();
                board.updateBoard(fieldCommand.getRow(), fieldCommand.getColumn(), Marks.playerMark);
                board.drawBoard();
                endRoundValidator.checkIsDraw();
                endRoundValidator.checkWinCondition();
                setCpuTurn(true);
                if (gameConfig.isCpuBegin()) {
                   this.turn ++;
                }
            } else {
                System.out.println("CPU TURN \n");
                aiLogic.aiRun();
                validateIsNotOccupied();
                board.updateBoard(fieldCommand.getRow(), fieldCommand.getColumn(), Marks.cpuMark);
                board.drawBoard();
                endRoundValidator.checkIsDraw();
                endRoundValidator.checkWinCondition();
                setCpuTurn(false);
                if (!gameConfig.isCpuBegin()) {
                    this.turn ++;
                }
            }
        }
        System.out.println(String.format(END_ROUND, round)); //here will be added text about win/ lost/ draw
        this.round ++;
        setTurn(1);
    }

    public void gameRun() {
        if (isGameJustStart) {
            GameConfig.getInstance().initGameConfig();
            board.initEmptyBoard();
            this.round ++;
            setGameJustStart(false);
        }

        while (round <= GameConfig.getInstance().getNumberOfRounds()) {
            initRound();
            gameLoop();
        }

        System.out.println(END_GAME);
        //here will be added field to storage round wining
    }

    public void setCpuTurn(boolean cpuTurn) {
        isCpuTurn = cpuTurn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setGameJustStart(boolean gameJustStart) {
        isGameJustStart = gameJustStart;
    }

    //here will be added logic to change start player each turn
}
