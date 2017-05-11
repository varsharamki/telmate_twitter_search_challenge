package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Hashtag {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("indices")
    @Expose
    private List<Long> indices = null;


    public Hashtag() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getIndices() {
        return indices;
    }

    public void setIndices(List<Long> indices) {
        this.indices = indices;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "text='" + text + '\'' +
                ", indices=" + indices +
                '}';
    }
}
