package Questions;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Generated("org.jsonschema2pojo")
public class Category {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;
    @SerializedName("clues_count")
    @Expose
    private int cluesCount;
    @SerializedName("clues")
    @Expose
    private List<Clue> clues = new ArrayList<Clue>();


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
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
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
     *     The cluesCount
     */
    public int getCluesCount() {
        return cluesCount;
    }

    /**
     *
     * @param cluesCount
     *     The clues_count
     */
    public void setCluesCount(int cluesCount) {
        this.cluesCount = cluesCount;
    }

    /**
     *
     * @return
     * The clues
     */
    public List<Clue> getClues() {
        return clues;
    }

    Random rand = new Random();
    public Clue getRandomClue() {
        Clue cl = clues.get(rand.nextInt(clues.size()));
        clues.remove(cl);
        return cl;
    }
    /**
     *
     * @param clues
     * The clues
     */
    public void setClues(List<Clue> clues) {
        this.clues = clues;
    }
}
