import Game.GameInRandomCategory;

import java.io.IOException;
import java.util.Scanner;

public class TextBasedMain {

    public static void main(String[] args) throws IOException {
        int questionsToAsk = 10;
        Scanner keyboard = new Scanner(System.in);
        String input;
        GameInRandomCategory gameInRandomCategory = new GameInRandomCategory(questionsToAsk);
        gameInRandomCategory.setUpQuestions();

        for (int i = 0; i < questionsToAsk; i++) {
            System.out.println("Question: " + (i + 1) + " out of: " + gameInRandomCategory.getAmountOfQuestionsInGame() +
                    "\t\tScore: " + gameInRandomCategory.getScore()
                    + " out of: " + gameInRandomCategory.getMaxScore());

            System.out.println(gameInRandomCategory.getQuestion(i).getCLUE().getQuestion());

            for (int j = 0; j < gameInRandomCategory.getQuestion(i).INCORRECT_ANSWER_CHOICES + 1; j++) {
                System.out.println(j + 1 + ". "
                        + gameInRandomCategory.getQuestion(i).getAnswerFromMultipleChoice(j));
            }
            input = keyboard.nextLine();
            gameInRandomCategory.getQuestion(i).setAnsweredCorrectly(gameInRandomCategory.getQuestion(i).getAnswerFromMultipleChoice(Integer.parseInt(input) - 1));
        }
    }


}
