package search.twitter.telmatechallenge.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
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
import search.twitter.telmatechallenge.presenter.implementations.TwitterSeachQueryPresenterImpl;
import search.twitter.telmatechallenge.view.interfaces.TwitterAccessTokenView;


public class EnterTwitterSearchActivity extends AppCompatActivity implements TwitterAccessTokenView{
    @InjectView(R.id.activity_enter_twitter_search)
    RelativeLayout layout;

    @InjectView(R.id.editText)
    EditText editText;
    @InjectView(R.id.button)
    Button button;

private TwitterAccessTokenView view;
    private TwitterSeachQueryPresenterImpl impl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_twitter_search);
        ButterKnife.inject(this);
        saveKeySecret();
        view=this;
        impl=new TwitterSeachQueryPresenterImpl(this,view);
    }

@OnClick(R.id.button)
public void buttonClick(){
if(!TextUtils.isEmpty(editText.getText().toString())){
    // need to do more validations on the search term <10 words ?
    if(editText.getText().toString().split(" ").length<=10){
        Intent intent=new Intent(EnterTwitterSearchActivity.this,DisplayTwitterSearchResultsActivity.class);
intent.putExtra("QUERY",editText.getText().toString());
        startActivity(intent);
    }

}
}

    @Override
    public void getBearerAccessToken(BearerTokenResponse bearerTokenResponse) {
if(bearerTokenResponse!=null){
    saveAccessToken(bearerTokenResponse);
}
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
                         saveAccessToken(bearerTokenResponse);
                    }

                }

            }

            @Override
            public void onFailure(Call<BearerTokenResponse> call, Throwable t) {
                // have to deal with response code 404 ,400
                Toast.makeText(getApplicationContext(), " onfailuree " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }


    private void saveAccessToken(BearerTokenResponse response) {
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN_TYPE, response.getToken_type());
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.BEARER_TOKEN, response.getAccess_token());

    }
    private void saveKeySecret() {
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_KEY, AuthConstants.CONSUMER_KEY);
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_SECRET, AuthConstants.CONSUMER_SECRET);

    }

}