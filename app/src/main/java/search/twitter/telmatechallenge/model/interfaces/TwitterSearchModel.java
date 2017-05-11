package search.twitter.telmatechallenge.model.interfaces;

import search.twitter.telmatechallenge.model.implementations.TwitterSearchModelImpl;
import search.twitter.telmatechallenge.model.network.TweetSearchService;

/**
 * Created by varsha on 5/11/17.
 */

public interface TwitterSearchModel {

void accessTokenRequest(TweetSearchService service, TwitterSearchModelImpl.OnJSONResponseCallback callback);
void searchResultsRequest(String query,TweetSearchService service, TwitterSearchModelImpl.OnSearchResultsResponseCallback callback);
}
