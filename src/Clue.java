import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Generated("org.jsonschema2pojo")
public class Clue {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("airdate")
    @Expose
    private Date airdate;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("game_id")
    @Expose
    private Object gameId;
    @SerializedName("invalid_count")
    @Expose
    private Object invalidCount;
    @SerializedName("category")
    @Expose
    private Category category;

    /**
     *
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     *     The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     *     The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     *     The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     *     The value
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     *     The value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @return
     *     The airdate
     */
    public Date getAirdate() {
        return airdate;
    }

    /**
     *
     * @param airdate
     *     The airdate
     */
    public void setAirdate(Date airdate) {
        this.airdate = airdate;
    }

    /**
     *
     * @return
     *     The createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     *     The updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     *     The updated_at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     *     The categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     *     The category_id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     *     The gameId
     */
    public Object getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     *     The game_id
     */
    public void setGameId(Object gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     *     The invalidCount
     */
    public Object getInvalidCount() {
        return invalidCount;
    }

    /**
     *
     * @param invalidCount
     *     The invalid_count
     */
    public void setInvalidCount(Object invalidCount) {
        this.invalidCount = invalidCount;
    }

    /**
     *
     * @return
     *     The category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     *     The category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Clue{");
        sb.append("airdate=").append(airdate);
        sb.append(", id=").append(id);
        sb.append(", answer='").append(answer).append('\'');
        sb.append(", question='").append(question).append('\'');
        sb.append(", value=").append(value);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", gameId=").append(gameId);
        sb.append(", invalidCount=").append(invalidCount);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
