import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        Player player;
        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the game begin! Enter your name:");

        while (!scanner.hasNextLine()) {
            name = scanner.nextLine();
            player = new Player(name);
        }

        Random random = new Random();
        System.out.println(Questions.QUESTIONS[random.nextInt()][1]);


    }
}
