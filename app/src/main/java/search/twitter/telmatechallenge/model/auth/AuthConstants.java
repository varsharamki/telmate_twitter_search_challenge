package search.twitter.telmatechallenge.model.auth;

/**
 * Created by varsha on 5/10/17.
 */

public class AuthConstants {
    public final static String CONSUMER_KEY = "iqL2N234oaqcwKPDuj8gbjXyZ";
    public final static String CONSUMER_SECRET = "afGzyjVEy67rXWeC6RECr50DixQ4XJQpHrg5hdnbRaKB7o4HEo";
    public final static String AUTH_BEARER_TOKEN_URL = "https://api.twitter.com/oauth2/token";
    public final static String SEARCH_TWEET_URL = "https://api.twitter.com/1.1/search/tweets.json";
public final static String APP_RATE_LIMIT_STATUS="https://api.twitter.com/1.1/application/rate_limit_status.json";

///// Header Builders
    public static final String HEADER_AUTHORIZATION="Authorization";
    public static final String HEADER_CONTENT_TYPE="Content-Type";
    public static final String ENTITY="grant_type=credentials";
    public static final String HEADER_URL_ENCODED="application/x-www-form-urlencoded;charset=UTF-8";
    public static final String HEADER_CONTENT_JSON="application/json";
}