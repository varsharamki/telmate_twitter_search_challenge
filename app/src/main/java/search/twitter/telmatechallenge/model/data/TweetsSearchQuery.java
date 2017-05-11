package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varsha on 5/10/17.
 */

public class TweetsSearchQuery {

    @SerializedName("coordinates")
    @Expose
    private Object coordinates;
    @SerializedName("favorited")
    @Expose
    private boolean favorited;
    @SerializedName("truncated")
    @Expose
    private boolean truncated;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("in_reply_to_user_id_str")
    @Expose
    private Object inReplyToUserIdStr;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("retweet_count")
    @Expose
    private long retweetCount;
    @SerializedName("in_reply_to_status_id_str")
    @Expose
    private Object inReplyToStatusIdStr;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("geo")
    @Expose
    private Object geo;
    @SerializedName("retweeted")
    @Expose
    private boolean retweeted;
    @SerializedName("in_reply_to_user_id")
    @Expose
    private Object inReplyToUserId;
    @SerializedName("place")
    @Expose
    private Object place;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("in_reply_to_screen_name")
    @Expose
    private Object inReplyToScreenName;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("in_reply_to_status_id")
    @Expose
    private Object inReplyToStatusId;


    public TweetsSearchQuery() {
    }


    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }


    @Override
    public String toString() {
        return "SearchQueryResponse{" +
                "coordinates=" + coordinates +
                ", favorited=" + favorited +
                ", truncated=" + truncated +
                ", createdAt='" + createdAt + '\'' +
                ", idStr='" + idStr + '\'' +
                ", entities=" + entities +
                ", inReplyToUserIdStr=" + inReplyToUserIdStr +
                ", contributors=" + contributors +
                ", text='" + text + '\'' +
                ", metadata=" + metadata +
                ", retweetCount=" + retweetCount +
                ", inReplyToStatusIdStr=" + inReplyToStatusIdStr +
                ", id=" + id +
                ", geo=" + geo +
                ", retweeted=" + retweeted +
                ", inReplyToUserId=" + inReplyToUserId +
                ", place=" + place +
                ", user=" + user +
                ", inReplyToScreenName=" + inReplyToScreenName +
                ", source='" + source + '\'' +
                ", inReplyToStatusId=" + inReplyToStatusId +
                '}';
    }
}
