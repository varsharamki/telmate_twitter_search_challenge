package search.twitter.telmatechallenge.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import search.twitter.telmatechallenge.R;
import search.twitter.telmatechallenge.model.auth.AuthConstants;
import search.twitter.telmatechallenge.model.auth.AuthenticationPreferences;

public class EnterTwitterSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_twitter_search);
        saveKeySecret();

        
    }

    private void saveKeySecret(){
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_KEY, AuthConstants.CONSUMER_KEY);
        AuthenticationPreferences.getAuthInstance(getApplicationContext()).putAuthString(AuthenticationPreferences.AuthKey.CONSUMER_SECRET, AuthConstants.CONSUMER_SECRET);

    }
}