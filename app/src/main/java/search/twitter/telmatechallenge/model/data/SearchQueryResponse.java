package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by varsha on 5/10/17.
 */

public class SearchQueryResponse {

    @SerializedName("statuses")
    ArrayList<TweetsSearchQuery> tweetsSearchQueries;

    public SearchQueryResponse() {
    }

    ;

    public SearchQueryResponse(ArrayList<TweetsSearchQuery> tweetsSearchQueries) {
        this.tweetsSearchQueries = tweetsSearchQueries;
    }

    public ArrayList<TweetsSearchQuery> getTweetsSearchQueries() {
        return tweetsSearchQueries;
    }

    public void setTweetsSearchQueries(ArrayList<TweetsSearchQuery> tweetsSearchQueries) {
        this.tweetsSearchQueries = tweetsSearchQueries;
    }
}
