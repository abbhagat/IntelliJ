package com.pingidentity.token;

import java.time.Instant;

/**
 * A class representing a security token.
 */
public class Token
{
    private final String tokenID;
    private final Instant notValidBefore;
    private final Instant notValidAfter;
    private final TokenSignature tokenSignature;
    private final byte[] rawToken;

    public Token(String tokenID,
                 Instant notValidBefore,
                 Instant notValidAfter,
                 TokenSignature tokenSignature,
                 byte[] rawToken)
    {
        this.tokenID = tokenID;
        this.notValidBefore = notValidBefore;
        this.notValidAfter = notValidAfter;
        this.tokenSignature = tokenSignature;
        this.rawToken = rawToken;
    }

    /**
     *
     * Get the unique identifier for this token (guaranteed to be unique across all tokens).
     * @return the token ID
     */
    public String getTokenID()
    {
        return tokenID;
    }

    /**
     * Get the beginning of the token validity window.
     * @return the point in time before which this token is not valid
     */
    public Instant getNotValidBefore()
    {
        return notValidBefore;
    }

    /**
     * Get the end of the token validity window.
     * @return the point in time after which this token is not valid
     */
    public Instant getNotValidAfter()
    {
        return notValidAfter;
    }

    /**
     * Get the object that contains signature information for this token.
     * @return this tokens signature
     */
    public TokenSignature getTokenSignature()
    {
        return tokenSignature;
    }

    /**
     * Get the binary content of the token.
     * @return a byte array containing all the token data encoded in binary.
     */
    public byte[] getRawToken()
    {
        return rawToken;
    }
}
