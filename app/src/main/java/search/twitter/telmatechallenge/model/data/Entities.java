package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by varsha on 5/10/17.
 */

public class Entities {


    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;
    @SerializedName("hashtags")
    @Expose
    private List<Hashtag> hashtags = null;
    @SerializedName("user_mentions")
    @Expose
    private List<Object> userMentions = null;


    public Entities() {
    }


    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Object> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<Object> userMentions) {
        this.userMentions = userMentions;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "urls=" + urls +
                ", hashtags=" + hashtags +
                ", userMentions=" + userMentions +
                '}';
    }
}
