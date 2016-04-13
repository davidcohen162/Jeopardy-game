package Game;

import Questions.Clue;
import Questions.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final int amountOfQuestionsInGame;
    private final int minAmountOfCluesInCategory;  // will control the minimum amount of clues a category has; too little means that the multiple choices might have duplicate answers.
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

    //    Only public for testing.
    public List<Question> getQuestionsList() {
        return questionsList;
    }

    protected void setQuestionsList(List<Question> q) {
        questionsList = q;

        int scoreAccrue = 0;
        for (Question question : questionsList) {
            scoreAccrue += question.getCLUE().getValue();
        }
        this.MAX_SCORE = scoreAccrue;
    }

    protected void setUpQuestions(List<Clue> clues) {
        List<Question> questionList = new ArrayList<>(getAmountOfQuestionsInGame());
        Random rand = new Random();

        for (int i = 0; i < getAmountOfQuestionsInGame(); i++) {
            Clue c = clues.get(rand.nextInt(clues.size()));
            questionList.add(new Question((c), (ArrayList<Clue>) clues));
            clues.remove(c);
        }
        setQuestionsList(questionList);
    }


    public String getQuestionString(int index) {
        return questionsList.get(index).getCLUE().getQuestion();
    }

    protected Question getQuestion(int index) {
        return questionsList.get(index);
    }

    public ArrayList<String> getMultipleChoiceAnswers(int index) {
        return questionsList.get(index).getANSWER_STRING_ARRAY_LIST();
    }

    public String getAQuestionsCategory(int index) {
        return questionsList.get(index).getCLUE().getCategory().getTitle();
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
