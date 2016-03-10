package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Question {

    //    INCORRECT_ANSWER_CHOICES controls how many false answers choices there are in a question.
    public final int INCORRECT_ANSWER_CHOICES = 3;
    protected final ArrayList<String> ANSWER_STRING_ARRAY_LIST = new ArrayList<>(INCORRECT_ANSWER_CHOICES + 1);
    private final Clue CLUE;
    private boolean answeredCorrectly = false;


    public Question(Clue clue, ArrayList<Clue> listOfCluesInSameCategory) {
        this.CLUE = clue;

        setAnswerMultipleChoice(listOfCluesInSameCategory);
    }

    public Question(Clue clue) {
        this.CLUE = clue;
    }


    /*  setAnswerMultipleChoice will accept a list of Clue objects and generate a list of of answers for the question. This way, a question
        will have multiple choices to display for the user to choose from. The correct answer is stored in
        this.getCLUE().getAnswer().
        The list that is passed in should be a list of Clues in the same category. If the list contains clues from a different
        category the false answers will be too obvious.
        If the List is too small (ie, the category does not have many clues in it), duplicate answers are likely to occur.*/
    public void setAnswerMultipleChoice(ArrayList<Clue> cluesList) {
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

    public String getCorrectAnswer() {
        return getCLUE().getAnswer();
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(String answerChoice) {
        setAnsweredCorrectly(answerChoice.equalsIgnoreCase(this.getCorrectAnswer()));
    }

    private void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    public String getAnswerFromMultipleChoice(int i) {
        return ANSWER_STRING_ARRAY_LIST.get(i);
    }
}
