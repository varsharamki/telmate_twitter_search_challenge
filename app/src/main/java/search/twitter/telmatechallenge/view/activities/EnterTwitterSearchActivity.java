package search.twitter.telmatechallenge.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import search.twitter.telmatechallenge.R;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.auth.AuthRequestBuilder;
import search.twitter.telmatechallenge.model.auth.AuthenticationPreferences;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;
import search.twitter.telmatechallenge.model.network.TweetSearchClient;
import search.twitter.telmatechallenge.model.network.TweetSearchService;


public class EnterTwitterSearchActivity extends AppCompatActivity {
    @InjectView(R.id.activity_enter_twitter_search)
    RelativeLayout layout;
    @InjectView(R.id.text1)
    TextView textView;
    @InjectView(R.id.text2)
    TextView textView1;
private ArrayList<TweetsSearchQuery> searchTweets=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_twitter_search);
        ButterKnife.inject(this);
        saveKeySecret();
        getAccessToken();

        AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder(this);

        Retrofit retrofit = TweetSearchClient.getRetrofitInstance(AuthConstants.SEARCH_TWEET_BASE_URL).client(authRequestBuilder.buildSearchTweetRequest()).build();
        TweetSearchService service = retrofit.create(TweetSearchService.class);
        Call<SearchQueryResponse> call = service.getSearchQueryResponse(authRequestBuilder.customSearchQueryURL("god",10));
        call.enqueue(new Callback<SearchQueryResponse>() {

            @Override
            public void onResponse(Call<SearchQueryResponse> call, Response<SearchQueryResponse> response) {
SearchQueryResponse searchResponse=response.body();
                searchTweets= searchResponse.getTweetsSearchQueries();
for(TweetsSearchQuery tweet:searchTweets){
    textView1.setText(textView1.getText()+" \n "+tweet.toString());
    Log.d("TELMATE======",tweet.toString());
}

                Log.d("TELMATE======"," TWEETS "+ call.request().toString() + "  " + response.code()+" "+searchTweets.size() );

            }

            @Override
            public void onFailure(Call<SearchQueryResponse> call, Throwable t) {

                Log.d("TELMATE======"," TWEETSFAil "+t.getMessage());
            }
        });


    }


    private void getAccessToken() {

        AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder(this);

        Retrofit retrofit = TweetSearchClient.getRetrofitInstance(AuthConstants.AUTH_BEARER_TOKEN_BASE_URL).client(authRequestBuilder.buildBearerRequest()).build();
        TweetSearchService service = retrofit.create(TweetSearchService.class);
        Call<BearerTokenResponse> call = service.token(AuthConstants.BODY);
        call.enqueue(new Callback<BearerTokenResponse>() {
            @Override
            public void onResponse(Call<BearerTokenResponse> call, Response<BearerTokenResponse> response) {
                if (response.code() == 200) {
                    BearerTokenResponse bearerTokenResponse = response.body();
                    if (bearerTokenResponse != null) {
                        textView.setText(bearerTokenResponse.getToken_type() + " ////// " + bearerTokenResponse.getAccess_token());
                        saveAccessToken(bearerTokenResponse);
                    }
                    Log.d("TELMATE====== ", call.request().toString() + "  " + response.code() + " Resposnse " + bearerTokenResponse.getAccess_token());

                }

            }

            @Override
            public void onFailure(Call<BearerTokenResponse> call, Throwable t) {
                // have to deal with response code 404 ,400
                Toast.makeText(getApplicationContext(), " onfailuree " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void saveKeySecret() {
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_KEY, AuthConstants.CONSUMER_KEY);
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_SECRET, AuthConstants.CONSUMER_SECRET);

    }

    private void saveAccessToken(BearerTokenResponse response) {
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN_TYPE, response.getToken_type());
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN, response.getAccess_token());

    }
}