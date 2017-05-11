package search.twitter.telmatechallenge.presenter.interfaces;

/**
 * Created by varsha on 5/11/17.
 */

public interface TwitterSearchQueryPresenter {
    void sendAccessTokenRequest();
    void sendSearchQuery(String query);

}
