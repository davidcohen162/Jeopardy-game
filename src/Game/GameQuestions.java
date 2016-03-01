package Game;

import Questions.Question;

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

    //    to be called whenever you want to know the current score. if game completes early, unanswered questions will be considered wrong.
    public int getScore() {
        int currentScore = 0;
        for (Question aQuestion : this.questionsList) {
            if (aQuestion.isAnsweredCorrectly()) {
                currentScore += aQuestion.getCLUE().getValue();
            }
        }
        return currentScore;
    }
}
