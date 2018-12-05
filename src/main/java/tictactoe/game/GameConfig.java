package tictactoe.game;

import java.util.Random;
import java.util.Scanner;

import static tictactoe.game.OutputMessage.*;

public class GameConfig {
    private static GameConfig gameConfigInstance = null;
    private String nick;
    private int numberOfRounds;
    private boolean isHardLevel;
    private boolean isCpuBegin;
    private static Scanner scan = new Scanner(System.in);
    private static final Random GENERATOR = new Random();

    public static GameConfig getInstance() {
        if (gameConfigInstance == null) {
            synchronized(GameConfig.class) {
                if (gameConfigInstance == null) {
                    gameConfigInstance = new GameConfig();
                }
            }
        }
        return gameConfigInstance;
    }

    private void configNick() {
        System.out.println(NICK_COMMAND);
        String input = scan.nextLine();
        while(input.length() < 3 || input.length() > 12 ) {
            System.out.println(WRONG_NICK);
            System.out.println(NICK_COMMAND);
            input = scan.nextLine();
        }
        this.nick = input;
    }

    private void configDifficultLevel() {
        System.out.println(LEVEL_CHOOSE);
        String input = scan.nextLine();
        boolean result = false;
        if(input.equals("y")) {
            result = true;
        }
        this.isHardLevel = result;
    }

    private void configNumbersOfRounds() {
        System.out.println(ROUNDS_NUMBER);
        try {
            int input = scan.nextInt();
            while (input < 1 || input > 10) {
                System.out.println(WRONG_NUMBER);
                input = scan.nextInt();
            }
            this.numberOfRounds = input;
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(WRONG_DATA_TYPE);
            this.numberOfRounds = DEFAULT_ROUND_NUMBER;
        }
    }

    private void configIsCpuBegin() {
        this.isCpuBegin = GENERATOR.nextBoolean();
    }

    public void initGameConfig() {
        configNick();
        configDifficultLevel();
        configNumbersOfRounds();
        configIsCpuBegin();
        System.out.println(String.format(FINAL_CONFIG, getNick(), getNumberOfRounds(), isHardLevel(), isHardLevel()));
    }

    public String getNick() {
        return nick;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public boolean isHardLevel() {
        return isHardLevel;
    }

    public boolean isCpuBegin() {
        return isCpuBegin;
    }

}
