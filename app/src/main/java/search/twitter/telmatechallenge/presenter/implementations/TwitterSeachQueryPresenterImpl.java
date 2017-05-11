package search.twitter.telmatechallenge.presenter.implementations;

import android.content.Context;
import android.util.Log;

import retrofit2.Response;
import retrofit2.Retrofit;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.auth.AuthRequestBuilder;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;
import search.twitter.telmatechallenge.model.implementations.TwitterSearchModelImpl;
import search.twitter.telmatechallenge.model.interfaces.TwitterSearchModel;
import search.twitter.telmatechallenge.model.network.TweetSearchClient;
import search.twitter.telmatechallenge.model.network.TweetSearchService;
import search.twitter.telmatechallenge.presenter.interfaces.TwitterSearchQueryPresenter;
import search.twitter.telmatechallenge.view.interfaces.TwitterAccessTokenView;

/**
 * Created by varsha on 5/11/17.
 */

public class TwitterSeachQueryPresenterImpl implements TwitterSearchQueryPresenter{

    Context context;
    private TwitterAccessTokenView view;
    private TwitterSearchModel model;


    public TwitterSeachQueryPresenterImpl() {
    }

    public TwitterSeachQueryPresenterImpl(Context context, TwitterAccessTokenView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void sendAccessTokenRequest() {
        AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder(context);

        Retrofit retrofit = TweetSearchClient.getRetrofitInstance(AuthConstants.AUTH_BEARER_TOKEN_BASE_URL).client(authRequestBuilder.buildBearerRequest()).build();
        TweetSearchService service = retrofit.create(TweetSearchService.class);
model=new TwitterSearchModelImpl();
        model.accessTokenRequest(service, new TwitterSearchModelImpl.OnJSONResponseCallback() {
            @Override
            public void onJSONResponse(boolean success, Response<BearerTokenResponse> response) {
                BearerTokenResponse bearerTokenResponse = response.body();
                if (bearerTokenResponse != null) {
view.getBearerAccessToken(bearerTokenResponse);
                }
                }
        });

    }

    @Override
    public void sendSearchQuery(String query) {

        AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder(context);

        Retrofit retrofit = TweetSearchClient.getRetrofitInstance(AuthConstants.SEARCH_TWEET_BASE_URL).client(authRequestBuilder.buildSearchTweetRequest()).build();
        TweetSearchService service = retrofit.create(TweetSearchService.class);
model.searchResultsRequest(query, service, new TwitterSearchModelImpl.OnSearchResultsResponseCallback() {
    @Override
    public void onSearchResponse(boolean success, Response<SearchQueryResponse> response) {
        SearchQueryResponse searchResponse=response.body();


    }
});
    }
}
