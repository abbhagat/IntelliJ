package com.pingidentity.token.validation;

import com.pingidentity.token.Token;

public interface TokenReplayPrevention
{
    /**
     * This method enforces a one time use policy on tokens that prevents them from being replayed.
     *
     * When invoked an implementation of this interface needs to check to see if it has seen the token
     * previously and also maintain whatever state it needs about the token so it can recognize it if
     * it sees it again in the future.
     *
     * @param token the token that will be checked to ensure that it hasn't been used previously
     * @return true if the token has been seen previously, false otherwise
     */
    boolean isTokenReplayed(Token token);
}
