package search.twitter.telmatechallenge.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by varsha on 5/10/17.
 */

public class TweetSearchClient {

    public static Retrofit.Builder getRetrofitInstance(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());

    }


//    public static TweetSearchService getTweetSearchService(String url) {
    //   return getRetrofitInstance(url).create(TweetSearchService.class);
    //  }


}
