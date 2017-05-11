package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varsha on 5/10/17.
 */

public class BearerTokenResponse {

    private String status;
    @SerializedName("token_type")
    @Expose
    private String token_type;
    @SerializedName("access_token")
    @Expose
    private String access_token;


    public BearerTokenResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "BearerTokenResponse{" +
                "status='" + status + '\'' +
                ", token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
