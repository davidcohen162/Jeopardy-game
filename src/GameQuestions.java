import java.util.List;


public class GameQuestions {

    private final List<Question> questionsList;
    private final int MAX_SCORE;

    public GameQuestions(List<Question> q) {
        questionsList = q;
        int scoreAccum = 0;
        for (Question question : questionsList) {
            scoreAccum += question.getCLUE().getValue();
        }
        MAX_SCORE = scoreAccum;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public int getMAX_SCORE() {
        return MAX_SCORE;
    }

    public boolean answerChoiceIsCorrect(String choice, int questionNumber) {
        return (choice.equalsIgnoreCase(questionsList.get(questionNumber).getCLUE().getAnswer()));
    }
}
