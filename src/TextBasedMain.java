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

            System.out.println(gameInRandomCategory.getQuestionString(i));

            for (int j = 0; j < gameInRandomCategory.getMultipleChoiceAnswers(i).size(); j++) {
                System.out.println(j + 1 + ". "
                        + gameInRandomCategory.getMultipleChoiceAnswers(i).get(j));
            }
            input = keyboard.nextLine();
            gameInRandomCategory.setPlayersAnswer(i, gameInRandomCategory.getMultipleChoiceAnswers(i).get(Integer.parseInt(input) - 1));

            if (gameInRandomCategory.aQuestionWasAnsweredCorrectly(i)) {
                System.out.println("Excelsior!");
            } else {
                System.out.println("Drink Coke, play again :; ");
            }
        }
    }


}
