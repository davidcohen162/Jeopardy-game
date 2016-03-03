import Questions.Clue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Question {

    private final Clue CLUE;
    //    INCORRECT_ANSWER_CHOICES controls how many false answers choices there are in a question.
    private final int INCORRECT_ANSWER_CHOICES = 3;

    protected final ArrayList<String> ANSWER_STRING_ARRAY_LIST = new ArrayList<>(INCORRECT_ANSWER_CHOICES + 1);


    public Question(Clue clue, ArrayList<Clue> cluesListOfSameCategory) {
        this.CLUE = clue;

        setAnswers(cluesListOfSameCategory);
    }

    public Question(Clue clue) {
        this.CLUE = clue;
    }


    //If the List is small, duplicate answers are likely to occur.
    protected void setAnswers(ArrayList<Clue> cluesList) {
        ANSWER_STRING_ARRAY_LIST.add(this.CLUE.getAnswer());
        Random random = new Random();

        for (int i = 0; i < INCORRECT_ANSWER_CHOICES; i++) {
            ANSWER_STRING_ARRAY_LIST.add(cluesList.get(random.nextInt(cluesList.size())).getAnswer());
        }

        Collections.shuffle(ANSWER_STRING_ARRAY_LIST);
    }

    public Clue getCLUE() {
        return CLUE;
    }
}
