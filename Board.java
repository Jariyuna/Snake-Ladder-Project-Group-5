package source;
import java.util.Arrays;

public class Board {
    public static final int BOARD_SIZE = 100;
    private int[] board;

    public Board() {
        board = new int[BOARD_SIZE + 1];
        initializeBoard();
    }

    private void initializeBoard() {
        // Ladders
        board[2] = 23;
        board[20] = 77;
        board[41] = 79;
        board[8] = 34;
        board[32] = 68;
        board[74] = 88;
        board[85] = 95;
        board[82] = 100;


        // Snakes
        board[38] = 15;
        board[47] = 5;
        board[29] = 9;
        board[53] = 33;
        board[62] = 37;
        board[97] = 25;
        board[86] = 54;
        board[92] = 70;
    }

    public int movePlayer(int currentPosition, int roll) {
        int newPosition = currentPosition + roll;
        if (newPosition > BOARD_SIZE) {
            return currentPosition; // If the new position exceeds the board size, player stays in the same position
        }
        if (board[newPosition] != 0) {
            newPosition = board[newPosition];
        }
        return newPosition;
    }

    public void displayBoard(Player[] players) {
        char[] display = new char[BOARD_SIZE + 1];
        Arrays.fill(display, '-');

        // Place players on the board
        for (Player player : players) {
            int position = player.getPosition();
            int playerNumber = player.getNumber();

            // Convert player number to character, handling cases where number > 9
            if (display[position] == '-') {
                display[position] = Character.forDigit(playerNumber, 10);
            } else {
                display[position] = 'P';
            }
        }

        // Display the board
        for (int i = 9; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 10 * i + 1; j <= 10 * (i + 1); j++) {
                    System.out.print(display[j] + " ");
                }
            } else {
                for (int j = 10 * (i + 1); j > 10 * i; j--) {
                    System.out.print(display[j] + " ");
                }
            }
            System.out.println();
        }
    }
}

