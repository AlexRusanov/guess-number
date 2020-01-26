import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private int currentQuestion;

    public Game() {
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void play() {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the game begin! Enter your name:");

        player = new Player(scanner.nextLine());

        int number;

        while (true) {
            setCurrentQuestion(random.nextInt(5));
            System.out.println(Questions.QUESTIONS[this.currentQuestion][1]);

            do {
                while (!scanner.hasNextInt()){
                    System.out.println("It's not a number. Please enter the number!");
                    scanner.next();
                }

                number = scanner.nextInt();

                if (number > Integer.parseInt(Questions.QUESTIONS[this.currentQuestion][0])) {
                    System.out.println("Your number is too big. Please, try again.");
                } else if (number < Integer.parseInt(Questions.QUESTIONS[this.currentQuestion][0])) {
                    System.out.println("Your number is too small. Please, try again.");
                } else {
                    System.out.println("Congratulations, " + player.getName() + "!");
                    player.addAnswer(number);
                    System.out.println("Your numbers:");
                    player.printAnswers();
                    break;
                }
            } while (number != Integer.parseInt(Questions.QUESTIONS[this.currentQuestion][0]));
        }
    }
}
