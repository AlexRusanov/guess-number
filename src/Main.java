import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        Player player;
        int number;
        int questionNumber;

        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the game begin! Enter your name:");

        name = scanner.nextLine();
        player = new Player(name);

        while (true) {
            questionNumber = random.nextInt(5);
            System.out.println(Questions.QUESTIONS[questionNumber][1]);

            do {
                while (!scanner.hasNextInt()){
                    System.out.println("It's not a number. Please enter the number!");
                    scanner.next();
                }

                number = scanner.nextInt();

                if (number > Integer.parseInt(Questions.QUESTIONS[questionNumber][0])) {
                    System.out.println("Your number is too big. Please, try again.");
                } else if (number < Integer.parseInt(Questions.QUESTIONS[questionNumber][0])) {
                    System.out.println("Your number is too small. Please, try again.");
                } else {
                    System.out.println("Congratulations, " + player.getName() + "!");
                    player.addAnswer(number);
                    System.out.println("Your numbers:");
                    player.printAnswers();
                    break;
                }
            } while (number != Integer.parseInt(Questions.QUESTIONS[questionNumber][0]));
        }
    }
}
