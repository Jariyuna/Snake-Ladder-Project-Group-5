package source;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] players;
    private Board board;
    private Random random;

    public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        board = new Board();
        random = new Random();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int currentPlayerIndex = 0;

        while (!isGameWon()) {
            board.displayBoard(players);

            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("\n" + currentPlayer.getName() + "'s turn.");
            System.out.print("Press Enter to roll the dice...");
            scanner.nextLine();
            int roll = random.nextInt(6) + 1;
            System.out.println("Rolled a " + roll);

            int newPosition = board.movePlayer(currentPlayer.getPosition(), roll);
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " is now at position " + currentPlayer.getPosition());

            if (currentPlayer.getPosition() >= Board.BOARD_SIZE) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }

        scanner.close();
    }

    private boolean isGameWon() {
        for (Player player : players) {
            if (player.getPosition() >= Board.BOARD_SIZE) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers;
        do {
            System.out.print("Choose the number of players (1-6): ");
            numberOfPlayers = scanner.nextInt();
        } while (numberOfPlayers < 1 || numberOfPlayers > 6);

        Game game = new Game(numberOfPlayers);
        game.start();
    }
}
