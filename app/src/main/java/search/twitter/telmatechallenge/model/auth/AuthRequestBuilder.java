package search.twitter.telmatechallenge.model.auth;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by varsha on 5/10/17.
 */

public class AuthRequestBuilder {

    private Context context;

    public AuthRequestBuilder(Context context) {
        this.context = context;
    }

    private String encodedConsumerKey() {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(AuthenticationPreferences.getAuthInstance(context).getAuthString(AuthenticationPreferences.AuthKey.CONSUMER_KEY), AuthConstants.ENCODING);
        } catch (UnsupportedEncodingException ue) {

        } catch (Exception e) {

        }
        return encoded;
    }

    private String encodedConsumerSecret() {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(AuthenticationPreferences.getAuthInstance(context).getAuthString(AuthenticationPreferences.AuthKey.CONSUMER_SECRET), AuthConstants.ENCODING);
        } catch (UnsupportedEncodingException ue) {

        } catch (Exception e) {

        }
        return encoded;
    }

    public String buildBase64() {
        String combined = "";
        String base64 = "";
        try {
            combined = encodedConsumerKey() + ":" + encodedConsumerSecret();
            base64 = Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP);
        } catch (Exception ue) {

        }
        return base64;
    }

    public OkHttpClient buildBearerRequest() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request wtHeader = request.newBuilder()
                        .header(AuthConstants.HEADER_AUTHORIZATION, "Basic " + buildBase64())
                        .header(AuthConstants.HEADER_CONTENT_TYPE, AuthConstants.HEADER_URL_ENCODED)
                        .method(request.method(), request.body())
                        .build();
                Log.d("TELMATE====== ", " base64 " + buildBase64() + " " + encodedConsumerSecret() + "  " + encodedConsumerKey());
                Log.d("TELMATE====== ", " Header " + wtHeader.url().toString() + " " + wtHeader.body().toString());
                return chain.proceed(wtHeader);
            }
        });
        return httpClientBuilder.build();

    }

    public OkHttpClient buildSearchTweetRequest(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request wtHeader = request.newBuilder()
                        .header(AuthConstants.HEADER_AUTHORIZATION, "Bearer " + AuthenticationPreferences.getAuthInstance(context).getAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN))
                        .header(AuthConstants.HEADER_CONTENT_TYPE, AuthConstants.HEADER_CONTENT_JSON)
                        .method(request.method(), request.body())
                        .build();
                Log.d("TELMATE====== ", "SearchRequest " +AuthenticationPreferences.getAuthInstance(context).getAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN)+"  "+
                AuthConstants.HEADER_CONTENT_JSON);
                return chain.proceed(wtHeader);
            }
        });
        return httpClientBuilder.build();
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

}
