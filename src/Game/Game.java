package Game;

public class Game {
    private final int amountOfQuestions;
    private final int amountOfCluesInCategory;  // will control the minimum amount of clues a cateogry has, too little means that the multiple choices might have duplicate answers.
    private GameQuestions gameQuestions;


    public Game(int amountOfQuestions, int amountOfCluesInCategory) {
        this.amountOfQuestions = amountOfQuestions;
        this.amountOfCluesInCategory = amountOfCluesInCategory;
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
