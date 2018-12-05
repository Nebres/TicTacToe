package tictactoe.game;

import java.util.Objects;
import java.util.Random;

public class AiLogic {

    private GameConfig gameConfig;
    private FieldCommand fieldCommand;

    private static final Random GENERATOR = new Random();

    public AiLogic(GameConfig gameConfig, FieldCommand fieldCommand) {
        this.gameConfig = gameConfig;
        this.fieldCommand = fieldCommand;
    }

    public void aiRun() {
        if (!gameConfig.isHardLevel()) {
            int row = GENERATOR.nextInt(3);
            int column = GENERATOR.nextInt(3);
            fieldCommand.setColumn(column);
            fieldCommand.setRow(row);
        } else {
            aiHardLevelRun();
        }
    }

    public void aiHardLevelRun(){
        //here will be added logic
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public FieldCommand getFieldCommand() {
        return fieldCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AiLogic)) return false;
        AiLogic aiLogic = (AiLogic) o;
        return Objects.equals(getGameConfig(), aiLogic.getGameConfig()) &&
                Objects.equals(getFieldCommand(), aiLogic.getFieldCommand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameConfig(), getFieldCommand());
    }

    @Override
    public String toString() {
        return "AiLogic{" +
                "gameConfig=" + gameConfig +
                ", fieldCommand=" + fieldCommand +
                '}';
    }

}

