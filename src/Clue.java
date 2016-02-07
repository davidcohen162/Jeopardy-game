import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Clue {

    private int id;
    private String answer;
    private String question;
    private int value;
    private String airdate;
    private String createdAt;
    private String updatedAt;
    private int categoryId;
    private Object gameId;
    private Object invalidCount;

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     * The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     * The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     * The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     * The value
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The airdate
     */
    public String getAirdate() {
        return airdate;
    }

    /**
     *
     * @param airdate
     * The airdate
     */
    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The gameId
     */
    public Object getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     * The game_id
     */
    public void setGameId(Object gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     * The invalidCount
     */
    public Object getInvalidCount() {
        return invalidCount;
    }

    /**
     *
     * @param invalidCount
     * The invalid_count
     */
    public void setInvalidCount(Object invalidCount) {
        this.invalidCount = invalidCount;
    }

}
