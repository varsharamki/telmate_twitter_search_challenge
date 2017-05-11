package search.twitter.telmatechallenge.model.network;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;

public interface TweetSearchService {

    @FormUrlEncoded
    @POST("token")
    Call<BearerTokenResponse> token(@Field("grant_type") String entity);

    @GET(AuthConstants.SEARCH_TWEET_URL)
    Call<SearchQueryResponse> getSearchQueryResponse();

}