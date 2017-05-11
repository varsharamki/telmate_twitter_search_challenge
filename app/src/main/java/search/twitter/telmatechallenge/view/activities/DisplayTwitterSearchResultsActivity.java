package search.twitter.telmatechallenge.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import search.twitter.telmatechallenge.R;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;
import search.twitter.telmatechallenge.view.interfaces.TwitterSearchResultsView;

public class DisplayTwitterSearchResultsActivity extends AppCompatActivity implements TwitterSearchResultsView{
    private ArrayList<TweetsSearchQuery> searchTweets=new ArrayList<>()
@InjectView(R.id.text1)
    TextView textView;

    private TwitterSearchResultsView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_twitter_search_results);

        ButterKnife.inject(this);
        view=this;
    }

    @Override
    public void getSearchResults(SearchQueryResponse searchQueryResponse) {
        searchTweets= searchQueryResponse.getTweetsSearchQueries();
        if(searchTweets!=null) {
            for (TweetsSearchQuery tweet : searchTweets) {
                Log.d("TELMATE======DISPLAY ", tweet.toString());
            }
            populateSearchResults(searchTweets);
        }
    }

    private void populateSearchResults(ArrayList<TweetsSearchQuery> results){
        textView.setText(results.get(0).getUser().getDescription());
    }
}
