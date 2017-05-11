package search.twitter.telmatechallenge.model.auth;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by varsha on 5/10/17.
 */

public class AuthenticationPreferences {

private static AuthenticationPreferences authPref;
   private static final String DEFAULT="default_settings";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor sharedPrefEditor;

    private AuthenticationPreferences(Context context){
        sharedPref=context.getSharedPreferences(DEFAULT,Context.MODE_PRIVATE);
        sharedPrefEditor=sharedPref.edit();
    }

    public static synchronized AuthenticationPreferences getAuthInstance(Context context){
        if(authPref==null){
            authPref=new AuthenticationPreferences(context.getApplicationContext());
        }
        return authPref;
    }

    public void putAuthString(AuthKey authKey,String val){
performEdit();
        sharedPrefEditor.putString(authKey.name(),val);
        performCommit();
    }

    public String getAuthString(AuthKey authKey){
        try {
            if (sharedPref.contains(authKey.name())) {
return sharedPref.getString(authKey.name(),null);
            }else{
                // need to add the key again ?
            }
        }catch(Exception e){
            // need to throw a more specific exepction for not getting shared pref key

        }
        return null;
    }

    public void performEdit(){
        if(sharedPref!=null){
            sharedPrefEditor=sharedPref.edit();
        }
    }

    public void performCommit(){
        if(sharedPrefEditor!=null){
            sharedPrefEditor.commit();
            sharedPrefEditor=null;
        }
    }

    public void removeAuthKeys(AuthKey... keys){
    performEdit();
        for(AuthKey key:keys){
            if(sharedPrefEditor!=null){
                sharedPrefEditor.remove(key.name());
            }
        }

        performCommit();
    }



public enum AuthKey{
    CONSUMER_KEY,
    CONSUMER_SECRET,
    BEARER_TOKEN,
    BEARER_TOKEN_TYPE
}

}

