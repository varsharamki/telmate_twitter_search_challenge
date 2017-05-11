package search.twitter.telmatechallenge.model.network;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;

public interface TweetSearchService {

    @FormUrlEncoded
    @POST(AuthConstants.TOKEN)
    Call<BearerTokenResponse> token(@Field("grant_type") String entity);

    @GET
    Call<SearchQueryResponse> getSearchQueryResponse(@Url String url);

}