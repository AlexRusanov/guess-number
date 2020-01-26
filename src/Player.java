public class Player {

    private String name;
    private int[] answers;
    private int count;

    private final static int DEFAULT_LENGTH = 2;

    public Player(String name) {
        this.name = name;
        this.answers = new int[DEFAULT_LENGTH];
    }

    public String getName() {
        return this.name;
    }

    public void printAnswers() {
        String answersToPrint = "";

        for (int i = 0; i < count; i++) {
            answersToPrint = answersToPrint.concat(answers[i] + "  ");
        }

        System.out.println(answersToPrint);
    }

    public void addAnswer(int number) {
        if (answers.length * 0.8 < count) {
            int[] newArray = new int[answers.length * 2];
            System.arraycopy(answers, 0, newArray, 0, answers.length);
            answers = newArray;
        }
        answers[count++] = number;
    }
}
