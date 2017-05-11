package search.twitter.telmatechallenge.presenter.implementations;

import android.content.Context;

import retrofit2.Response;
import retrofit2.Retrofit;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.auth.AuthRequestBuilder;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.implementations.TwitterSearchModelImpl;
import search.twitter.telmatechallenge.model.interfaces.TwitterSearchModel;
import search.twitter.telmatechallenge.model.network.TweetSearchClient;
import search.twitter.telmatechallenge.model.network.TweetSearchService;
import search.twitter.telmatechallenge.presenter.interfaces.TwitterSearchResultsPresenter;
import search.twitter.telmatechallenge.view.interfaces.TwitterSearchResultsView;

/**
 * Created by varsha on 5/11/17.
 */

public class TwitterSearchResultsPresenterImpl implements TwitterSearchResultsPresenter {

    Context context;
    private TwitterSearchModel model;
    private TwitterSearchResultsView searchView;

    public TwitterSearchResultsPresenterImpl() {
    }

    public TwitterSearchResultsPresenterImpl(Context context, TwitterSearchResultsView searchView) {
        this.context = context;
        this.searchView = searchView;
    }

    public TwitterSearchResultsPresenterImpl(Context context, TwitterSearchModel model, TwitterSearchResultsView searchView) {
        this.context = context;
        this.model = model;
        this.searchView = searchView;
    }

    @Override
    public void sendSearchQuery(String query) {

        AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder(context);

        Retrofit retrofit = TweetSearchClient.getRetrofitInstance(AuthConstants.SEARCH_TWEET_BASE_URL).client(authRequestBuilder.buildSearchTweetRequest()).build();
        TweetSearchService service = retrofit.create(TweetSearchService.class);
        model = new TwitterSearchModelImpl();

        model.searchResultsRequest(query, service, new TwitterSearchModelImpl.OnSearchResultsResponseCallback() {
            @Override
            public void onSearchResponse(boolean success, Response<SearchQueryResponse> response) {
                SearchQueryResponse searchResponse = response.body();

                searchView.getSearchResults(searchResponse);
            }
        });
    }
}
