package search.twitter.telmatechallenge.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import search.twitter.telmatechallenge.R;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;
import search.twitter.telmatechallenge.presenter.implementations.TwitterSeachQueryPresenterImpl;
import search.twitter.telmatechallenge.presenter.implementations.TwitterSearchResultsPresenterImpl;
import search.twitter.telmatechallenge.view.TwitterSearchResultsAdapter;
import search.twitter.telmatechallenge.view.interfaces.TwitterSearchResultsView;

public class DisplayTwitterSearchResultsActivity extends AppCompatActivity implements TwitterSearchResultsView{
@InjectView(R.id.text1)
    TextView textView;
    @InjectView(R.id.searchRecylerView)
    RecyclerView searchResultsView;

    private TwitterSearchResultsAdapter searchAdapter;
    private ArrayList<TweetsSearchQuery> searchTweets=new ArrayList<>();
private TwitterSearchResultsPresenterImpl impl;
    private TwitterSearchResultsView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_twitter_search_results);

        ButterKnife.inject(this);
        view=this;
        impl=new TwitterSearchResultsPresenterImpl(this,view);
    if(getIntent()!=null) {
        if(getIntent().hasExtra("QUERY")){
            impl.sendSearchQuery(getIntent().getStringExtra("QUERY"));
        }
    }
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
       if(results!=null) {
           preFetchImages(results);
           searchAdapter = new TwitterSearchResultsAdapter(this, results);
           RecyclerView.LayoutManager linear = new LinearLayoutManager(this);
           searchResultsView.setLayoutManager(linear);
           searchResultsView.setHasFixedSize(true);
           searchResultsView.setItemViewCacheSize(10);
           searchResultsView.setDrawingCacheEnabled(true);
           searchResultsView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
           searchResultsView.setAdapter(searchAdapter);
           searchResultsView.addOnScrollListener(new RecyclerView.OnScrollListener() {
               @Override
               public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                   super.onScrollStateChanged(recyclerView, newState);
               }

               @Override
               public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                   super.onScrolled(recyclerView, dx, dy);
                   /// to do pagination
               }
           });
       }
    }

    private void preFetchImages(ArrayList<TweetsSearchQuery> tweet){
        String[] imgUrls;
        imgUrls=new String[tweet.size()];
        for(int y=0;y<tweet.size();y++){
            if(!TextUtils.isEmpty(tweet.get(y).getUser().getProfileImageUrlHttps())) {
                imgUrls[y] = tweet.get(y).getUser().getProfileImageUrlHttps();
            }else if(!TextUtils.isEmpty(tweet.get(y).getUser().getProfileBackgroundImageUrlHttps())){
                imgUrls[y] = tweet.get(y).getUser().getProfileBackgroundImageUrlHttps();
            }else if(!TextUtils.isEmpty(tweet.get(y).getUser().getProfileImageUrl())) {
                imgUrls[y] = tweet.get(y).getUser().getProfileImageUrl();
            }else if(!TextUtils.isEmpty(tweet.get(y).getUser().getProfileBackgroundImageUrl())){
                imgUrls[y] = tweet.get(y).getUser().getProfileBackgroundImageUrl();
            }
        }
        if(imgUrls!=null){
            for(String img:imgUrls){
                getPicassoInstance().load(img).fetch();
            }
        }
    }
    private Picasso getPicassoInstance(){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setProtocols(Arrays.asList(Protocol.HTTP_1_1));
        OkHttpDownloader downloader = new OkHttpDownloader(okHttpClient);
        return new Picasso.Builder(this).downloader(downloader).build();
    }


}
