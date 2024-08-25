package game;
import java.util.Scanner;
public class Game {
        private Player player1;
        private Player player2;
        private Board board;

        public Game(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
            this.board = new Board();
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            Player currentPlayer = player1;
            boolean gameWon = false;

            while (!board.isFull() && !gameWon) {
                board.displayBoard();

                System.out.println(currentPlayer.getSymbol()+ "'s turn. Enter a row  and column:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row < -1 || row > 2 || col < -1 || col > 2 || !board.updateBoard(row, col, currentPlayer.getSymbol())){
                    System.out.println("Invalid move, try again.");
                    continue;
                }

                gameWon = board.checkWinner(currentPlayer.getSymbol());

                if (!gameWon) {
                    if(currentPlayer == player1){
                        currentPlayer = player2;
                    }
                    else
                        currentPlayer = player1;
                }
            }

            board.displayBoard();

            if (gameWon) {
                System.out.println("Congratulations! Player " + currentPlayer.getSymbol() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }


        }

        public static void main(String[] args) {
            Player player1 = new Player("Player 1", 'X');
            Player player2 = new Player("Player 2", 'O');
            Game game = new Game(player1, player2);
            game.start();
        }
    }



