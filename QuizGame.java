import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizGame {
    private static int score = 0;
    private static final int TIME_LIMIT = 15000; // 15 seconds in milliseconds
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Berlin", "D. Rome"}, 'B'),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"}, 'B'),
            new QuizQuestion("What is the largest mammal in the world?", new String[]{"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Gorilla"}, 'B'),
            new QuizQuestion("Who wrote Romeo and Juliet?", new String[]{"A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "D. Leo Tolstoy"}, 'A'),
            new QuizQuestion("What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Hg"}, 'A')
            // Add more questions as needed
        };

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You have " + TIME_LIMIT / 1000 + " seconds to answer each question.");

        for (QuizQuestion question : questions) {
            askQuestion(question);
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);

        scanner.close();
    }

    public static void askQuestion(QuizQuestion question) {
        System.out.println("\n" + question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                evaluateAnswer(' '); // Pass an empty character to indicate no user input
            }
        }, TIME_LIMIT);

        char userAnswer = Character.toUpperCase(scanner.next().charAt(0));
        evaluateAnswer(userAnswer);

        timer.cancel(); // Cancel the timer after the question is answered
    }

    public static void evaluateAnswer(char userAnswer) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Berlin", "D. Rome"}, 'B'),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"}, 'B'),
            new QuizQuestion("What is the largest mammal in the world?", new String[]{"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Gorilla"}, 'B'),
            new QuizQuestion("Who wrote Romeo and Juliet?", new String[]{"A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "D. Leo Tolstoy"}, 'A'),
            new QuizQuestion("What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Hg"}, 'A')
            // Add more questions as needed
        };

        if (userAnswer == questions[score].getCorrectAnswer()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! Correct answer: " + questions[score].getCorrectAnswer());
        }
    }
}
