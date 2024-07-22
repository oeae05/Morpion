import java.util.Scanner;

public class Morpion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue au jeu de Morpion !");
        System.out.print("Voulez-vous jouer contre l'ordinateur (1) ou à deux joueurs (2) ? ");
        int mode = scanner.nextInt();
        boolean isSinglePlayer = (mode == 1);

        Game game = new Game(isSinglePlayer);
        game.play();
        
        scanner.close();
    }
}
