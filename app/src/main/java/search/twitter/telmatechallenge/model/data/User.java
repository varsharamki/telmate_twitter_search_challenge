package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varsha on 5/10/17.
 */

public class User {
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_background_tile")
    @Expose
    private boolean profileBackgroundTile;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("follow_request_sent")
    @Expose
    private Object followRequestSent;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("is_translator")
    @Expose
    private boolean isTranslator;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("default_profile")
    @Expose
    private boolean defaultProfile;
    @SerializedName("contributors_enabled")
    @Expose
    private boolean contributorsEnabled;
    @SerializedName("favourites_count")
    @Expose
    private long favouritesCount;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("utc_offset")
    @Expose
    private long utcOffset;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("profile_use_background_image")
    @Expose
    private boolean profileUseBackgroundImage;
    @SerializedName("listed_count")
    @Expose
    private long listedCount;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("followers_count")
    @Expose
    private long followersCount;
    @SerializedName("protected")
    @Expose
    private boolean _protected;
    @SerializedName("notifications")
    @Expose
    private Object notifications;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("geo_enabled")
    @Expose
    private boolean geoEnabled;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("default_profile_image")
    @Expose
    private boolean defaultProfileImage;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("statuses_count")
    @Expose
    private long statusesCount;
    @SerializedName("friends_count")
    @Expose
    private long friendsCount;
    @SerializedName("following")
    @Expose
    private Object following;
    @SerializedName("show_all_inline_media")
    @Expose
    private boolean showAllInlineMedia;
    @SerializedName("screen_name")
    @Expose
    private String screenName;


    public User() {
    }


    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public boolean isProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Object followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public boolean isIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public boolean isDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public long getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(long utcOffset) {
        this.utcOffset = utcOffset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public long getListedCount() {
        return listedCount;
    }

    public void setListedCount(long listedCount) {
        this.listedCount = listedCount;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public boolean isProtected() {
        return _protected;
    }

    public void setProtected(boolean _protected) {
        this._protected = _protected;
    }

    public Object getNotifications() {
        return notifications;
    }

    public void setNotifications(Object notifications) {
        this.notifications = notifications;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Object getFollowing() {
        return following;
    }

    public void setFollowing(Object following) {
        this.following = following;
    }

    public boolean isShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    public void setShowAllInlineMedia(boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    public String getScreenName() {
        return screenName;
    }

    @Override
    public String toString() {
        return "User{" +
                "profileSidebarFillColor='" + profileSidebarFillColor + '\'' +
                ", profileSidebarBorderColor='" + profileSidebarBorderColor + '\'' +
                ", profileBackgroundTile=" + profileBackgroundTile +
                ", name='" + name + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", location='" + location + '\'' +
                ", followRequestSent=" + followRequestSent +
                ", profileLinkColor='" + profileLinkColor + '\'' +
                ", isTranslator=" + isTranslator +
                ", idStr='" + idStr + '\'' +
                ", defaultProfile=" + defaultProfile +
                ", contributorsEnabled=" + contributorsEnabled +
                ", favouritesCount=" + favouritesCount +
                ", url=" + url +
                ", profileImageUrlHttps='" + profileImageUrlHttps + '\'' +
                ", utcOffset=" + utcOffset +
                ", id=" + id +
                ", profileUseBackgroundImage=" + profileUseBackgroundImage +
                ", listedCount=" + listedCount +
                ", profileTextColor='" + profileTextColor + '\'' +
                ", lang='" + lang + '\'' +
                ", followersCount=" + followersCount +
                ", _protected=" + _protected +
                ", notifications=" + notifications +
                ", profileBackgroundImageUrlHttps='" + profileBackgroundImageUrlHttps + '\'' +
                ", profileBackgroundColor='" + profileBackgroundColor + '\'' +
                ", verified=" + verified +
                ", geoEnabled=" + geoEnabled +
                ", timeZone='" + timeZone + '\'' +
                ", description='" + description + '\'' +
                ", defaultProfileImage=" + defaultProfileImage +
                ", profileBackgroundImageUrl='" + profileBackgroundImageUrl + '\'' +
                ", statusesCount=" + statusesCount +
                ", friendsCount=" + friendsCount +
                ", following=" + following +
                ", showAllInlineMedia=" + showAllInlineMedia +
                ", screenName='" + screenName + '\'' +
                '}';
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

}
