public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private char currentPlayer;

    public Game(boolean isSinglePlayer) {
        board = new Board();
        playerX = new HumanPlayer('X');
        playerO = isSinglePlayer ? new ComputerPlayer('O') : new HumanPlayer('O');
        currentPlayer = 'X';
    }

    public void play() {
        while (true) {
            board.printBoard();
            if (currentPlayer == 'X') {
                playerX.makeMove(board);
            } else {
                playerO.makeMove(board);
            }
            if (board.isWinner(currentPlayer)) {
                board.printBoard();
                System.out.println("Le joueur " + currentPlayer + " a gagné !");
                break;
            }
            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("Match nul !");
                break;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
