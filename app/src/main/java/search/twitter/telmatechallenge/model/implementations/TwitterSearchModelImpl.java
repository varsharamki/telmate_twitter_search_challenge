package search.twitter.telmatechallenge.model.implementations;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.data.BearerTokenResponse;
import search.twitter.telmatechallenge.model.data.SearchQueryResponse;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;
import search.twitter.telmatechallenge.model.interfaces.TwitterSearchModel;
import search.twitter.telmatechallenge.model.network.TweetSearchService;

public class TwitterSearchModelImpl implements TwitterSearchModel{

    public TwitterSearchModelImpl() {
    }

    @Override
    public void accessTokenRequest(TweetSearchService service, final OnJSONResponseCallback callback) {
        Call<BearerTokenResponse> call = service.token(AuthConstants.BODY);
        call.enqueue(new Callback<BearerTokenResponse>() {
            @Override
            public void onResponse(Call<BearerTokenResponse> call, Response<BearerTokenResponse> response) {
                if (response.code() == 200) {
                  callback.onJSONResponse(true,response);
                    Log.d("TELMATE====== ", call.request().toString() + "  " + response.code() + " Resposnse ");

                }

            }

            @Override
            public void onFailure(Call<BearerTokenResponse> call, Throwable t) {
                callback.onJSONResponse(false,null);

            }
        });
    }

    @Override
    public void searchResultsRequest(String query, TweetSearchService service, final OnSearchResultsResponseCallback callback) {
        Call<SearchQueryResponse> call = service.getSearchQueryResponse(customSearchQueryURL(query,10));
        call.enqueue(new Callback<SearchQueryResponse>() {

            @Override
            public void onResponse(Call<SearchQueryResponse> call, Response<SearchQueryResponse> response) {
                callback.onSearchResponse(true,response);
                Log.d("TELMATE======"," TWEETS "+ call.request().toString() + "  " + response.code());

            }

            @Override
            public void onFailure(Call<SearchQueryResponse> call, Throwable t) {
callback.onSearchResponse(false,null);
                Log.d("TELMATE======"," TWEETSFAil "+t.getMessage());
            }
        });

    }

    public String customSearchQueryURL(String query,int count) {
        String url = "";

        try {
            url = String.format(Locale.ENGLISH,"%s?q=%s&result_type=mixed&count=%d",
                    AuthConstants.TWEETS,
                    URLEncoder.encode(query, "UTF-8"),
                    count
            );
        } catch (UnsupportedEncodingException exception) {

        } catch (Exception e) {

        }

        return url;
    }
    public interface OnJSONResponseCallback {
        public void onJSONResponse(boolean success, Response<BearerTokenResponse> response);
    }

    public interface OnSearchResultsResponseCallback{
        public void onSearchResponse(boolean success, Response<SearchQueryResponse> response);
    }
}
