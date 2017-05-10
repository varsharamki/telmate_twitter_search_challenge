package search.twitter.telmatechallenge.model.network;


import retrofit2.Call;
import retrofit2.http.GET;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;

public interface TweetSearchService {

    @GET(AuthConstants.AUTH_BEARER_TOKEN_URL)
    Call<BearerTokenResponse> getBearerToken();

    @GET(AuthConstants.SEARCH_TWEET_URL)
    Call<SearchQueryResponse> getSearchQueryResponse();

}