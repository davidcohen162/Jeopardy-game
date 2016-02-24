import GetJsonData.CategoryJson;
import GetJsonData.RandomQuestionsJson;
import Questions.Category;
import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RandomQuestion {
    private static RandomQuestionsJson getRandClueJson = new RandomQuestionsJson();
    private static CategoryJson categoryJson = new CategoryJson();

    protected Clue clue;
    private final int answerCount = 4;
    protected ArrayList<String> answerStringArrayList = new ArrayList<>(answerCount + 1);


    public RandomQuestion() {}

    public static RandomQuestion getRandomQuestion() throws IOException {
        RandomQuestion randomQuestion = new RandomQuestion();
        randomQuestion.clue = getRandClueJson.getRandomClueBasedOnLastRequest();

        Category category;
        category = categoryJson.getCategory(randomQuestion.clue.getCategoryId());
        randomQuestion.setAnswers(category);

        return randomQuestion;
    }

    private void setAnswers(Category category) {
        Random random = new Random();
        ArrayList<Clue> clueArray = (ArrayList<Clue>) category.getClues();
        for (int i = 0; i < answerCount; i++) {
            answerStringArrayList.add(clueArray.get(random.nextInt(clueArray.size() - 1)).getAnswer());
        }
        answerStringArrayList.add(this.clue.getAnswer());
        Collections.shuffle(answerStringArrayList);
    }

}
