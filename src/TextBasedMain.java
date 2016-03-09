import Game.GameInRandomCategory;

import java.io.IOException;
import java.util.Scanner;

public class TextBasedMain {

    public static void main(String[] args) throws IOException {
        int questionsToAsk = 10;
        Scanner keyboard = new Scanner(System.in);
        String input;
        GameInRandomCategory gameInRandomCategory = new GameInRandomCategory(questionsToAsk, 40);
        gameInRandomCategory.setUpQuestions();

        for (int i = 0; i < questionsToAsk; i++) {
            System.out.println("Question: " + (i + 1) + " out of: " + gameInRandomCategory.getAmountOfQuestions() +
                    "\t\tScore: " + gameInRandomCategory.getGameQuestions().getScore()
                    + " out of: " + gameInRandomCategory.getGameQuestions().getMAX_SCORE());

            System.out.println(gameInRandomCategory.getGameQuestions().getQuestionsList().get(i).getCLUE().getQuestion());

            for (int j = 0; j < gameInRandomCategory.getGameQuestions().getQuestionsList().get(i).INCORRECT_ANSWER_CHOICES + 1; j++) {
                System.out.println(j + 1 + ". "
                        + gameInRandomCategory.getGameQuestions().getQuestionsList().get(i).getAnswerFromMultipleChoice(j));
            }
            input = keyboard.nextLine();
            gameInRandomCategory.getGameQuestions().getQuestionsList().get(i).setAnsweredCorrectly(gameInRandomCategory.getGameQuestions().getQuestionsList().get(i).getAnswerFromMultipleChoice(Integer.parseInt(input) - 1));
        }
    }


}
