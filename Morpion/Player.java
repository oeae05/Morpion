import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void makeMove(Board board);
}

class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(char symbol) {
        super(symbol);
        scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove(Board board) {
        int row, col;
        while (true) {
            System.out.print("Joueur " + symbol + ", entrez votre mouvement (ligne et colonne) : ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (board.makeMove(row, col, symbol)) {
                break;
            } else {
                System.out.println("Ce mouvement n'est pas valide. Réessayez.");
            }
        }
    }
}

class ComputerPlayer extends Player {
    private Random rand;

    public ComputerPlayer(char symbol) {
        super(symbol);
        rand = new Random();
    }

    @Override
    public void makeMove(Board board) {
        int row, col;
        while (true) {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if (board.makeMove(row, col, symbol)) {
                break;
            }
        }
        System.out.println("Ordinateur " + symbol + " a joué en (" + (row + 1) + "," + (col + 1) + ")");
    }
}
