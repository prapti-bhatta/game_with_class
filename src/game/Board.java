package game;

public class Board {

        private char[][] board;

        public Board() {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        public void displayBoard() {
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            }
        }

        public boolean updateBoard(int row, int col, char symbol) {
            if (board[row][col] == ' ') {
                board[row][col] = symbol;
                return true;
            }
            return false;
        }

        public boolean checkWinner(char symbol) {
            for (int i = 0; i < 3; i++) {
                // Check rows
                if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)) {
                    return true;
                }
                // Check columns
                if((board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)){
                    return true;
                }
            }

            // Check diagonals
            if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol))
                     {
                return true;
            }
            if((board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)){
                return true;
            }

            return false;
        }

        public boolean isFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
    }

