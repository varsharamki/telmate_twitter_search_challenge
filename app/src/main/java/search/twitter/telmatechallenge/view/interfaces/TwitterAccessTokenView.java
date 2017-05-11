package search.twitter.telmatechallenge.view.interfaces;

import search.twitter.telmatechallenge.model.data.BearerTokenResponse;

public interface TwitterAccessTokenView {

    void getBearerAccessToken(BearerTokenResponse bearerTokenResponse);
}

