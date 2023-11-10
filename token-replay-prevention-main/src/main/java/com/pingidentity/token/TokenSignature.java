package com.pingidentity.token;

import java.security.PublicKey;

public class TokenSignature
{
    private byte[] signatureValue;
    private String signatureAlgorithm;
    private PublicKey verificationKey;

    public TokenSignature(byte[] signatureValue, String signatureAlgorithm, PublicKey verificationKey)
    {
        this.signatureValue = signatureValue;
        this.signatureAlgorithm = signatureAlgorithm;
        this.verificationKey = verificationKey;
    }

    /**
     * The value of the signature.
     * @return The byte array that is the signature
     */
    public byte[] getSignatureValue()
    {
        return signatureValue;
    }

    /**
     * The algorithm used to create the signature.
     * @return a string describing the signature algorithm (i.e. SHA1withRSA)
     */
    public String getSignatureAlgorithm()
    {
        return signatureAlgorithm;
    }

    /**
     * The public component of the public/private key pair that was used to create the signature.
     * @return the PublicKey that can be used to verify the signature
     */
    public PublicKey getVerificationKey()
    {
        return verificationKey;
    }
}
