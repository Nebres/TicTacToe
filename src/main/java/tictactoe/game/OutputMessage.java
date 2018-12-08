package tictactoe.game;

public interface OutputMessage {
    //Board
    String COLUMN_A = " 1 ";
    String COLUMN_B = " 2 ";
    String COLUMN_C = " 3 ";
    String ROW_I = " 1 ";
    String ROW_II = "2 ";
    String ROW_III = "3";
    String COLUMN_SEPARATOR = " |";
    String ROW_SEPARATOR = "-----------";
    String NEW_LINE = "\n";
    String LONG_SPACE = "   ";
    String SHORT_SPACE = " ";

    //Config
    String NICK_COMMAND = "Please type your Nick (3-12 letters): ";
    String WRONG_NICK = "Wrong Name. Note that Nick must have min 3 letter and max 12 letter";
    String LEVEL_CHOOSE = "If You want play on Hard Mode insert \"y\" otherwise insert any other key";
    String ROUNDS_NUMBER = "Please type number of round between 1 to 10.";
    String WRONG_NUMBER = "Wrong round number. Note that Number must be between 1 to 10. Type again:  ";
    String WRONG_DATA_TYPE = "You can type only number. Round number set automatic to 1";
    String FINAL_CONFIG = "Your nick is %s. We will play %d round.\n" +
            "Hard difficult set? %b.\n" +
            "Cpu go first? %b.\n";
    int DEFAULT_ROUND_NUMBER = 1;

    //Filed Command
    String ROW_UPDATE = "Please type Row where You want put X";
    String COLUMN_UPDATE = "Please type Column where You want put X";
    String WRONG_ROW_UPDATE = "Wrong Row number. Pleas note You must type number between 1 to 3. Try Again";
    String WRONG_COLUMN_UPDATE = "Wrong Column number. Pleas note You must type number between 1 to 3. Try Again";
    String OCCUPIED_FIELD = "You choose field that is already occupied. Try again";
    String END_GAME = "End Game \n";
    String END_ROUND = "End Round %d";
    String TURN_INF0 = "\n Round: %d Turn: %d";

}
