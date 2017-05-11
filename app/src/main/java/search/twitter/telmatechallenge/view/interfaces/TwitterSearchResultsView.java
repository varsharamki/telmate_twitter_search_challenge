package search.twitter.telmatechallenge.view.interfaces;

import search.twitter.telmatechallenge.model.data.SearchQueryResponse;

/**
 * Created by varsha on 5/11/17.
 */

public interface TwitterSearchResultsView {
    void getSearchResults(SearchQueryResponse searchQueryResponse);
}
