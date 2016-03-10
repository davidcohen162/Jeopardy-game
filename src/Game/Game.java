package Game;

import Questions.Question;

import java.util.List;

public class Game {
    private final int amountOfQuestionsInGame;
    private final int minAmountOfCluesInCategory;  // will control the minimum amount of clues a cateogry has; too little means that the multiple choices might have duplicate answers.
    private List<Question> questionsList;
    private int MAX_SCORE;


    public Game(int amountOfQuestions) {
        this.amountOfQuestionsInGame = amountOfQuestions;
        this.minAmountOfCluesInCategory = amountOfQuestions * 4;
    }

    public Game(int amountOfQuestions, int amountOfCluesInCategory) {
        this.amountOfQuestionsInGame = amountOfQuestions;
        this.minAmountOfCluesInCategory = amountOfCluesInCategory;
    }
    public List<Question> getQuestionsList() {
        return questionsList;
    }

    protected void setQuestionsList(List<Question> q) {
        questionsList = q;

        int scoreAccum = 0;
        for (Question question : questionsList) {
            scoreAccum += question.getCLUE().getValue();
        }
        this.MAX_SCORE = scoreAccum;
    }

    public Question getQuestion(int index) {
        return questionsList.get(index);
    }

    //
    public void setPlayersAnswer(int index, String playerChoice) {
        getQuestion(index).setAnsweredCorrectly(playerChoice);
    }

    public boolean aQuestionWasAnsweredCorrectly(int index) {
        return getQuestion(index).isAnsweredCorrectly();
    }

    public int getAmountOfQuestionsInGame() {
        return amountOfQuestionsInGame;
    }

    public int getMinAmountOfCluesInCategory() {
        return minAmountOfCluesInCategory;
    }


    public int getMaxScore() {
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
