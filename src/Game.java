public class Game {
    private final int amountOfQuestions = 10;
    private final int amountOfCluesInCategory;  // will control the minimum amount of clues a cateogry has, too little means that the multiple choices might have duplicate answers.
    private int currentScore;
    private GameQuestions gameQuestions;


    public Game(int amountOfCluesInCategory) {
        currentScore = 0;
        this.amountOfCluesInCategory = amountOfCluesInCategory;

    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void addToScore(int amount) {
        this.currentScore += amount;
    }

    public GameQuestions getGameQuestions() {
        return gameQuestions;
    }

    public void setGameQuestions(GameQuestions gameQuestions) {
        this.gameQuestions = gameQuestions;
    }

    public int getAmountOfQuestions() {
        return amountOfQuestions;
    }

    public int getAmountOfCluesInCategory() {
        return amountOfCluesInCategory;
    }


}
