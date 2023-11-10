package com.pingidentity.token.validation;

import com.pingidentity.token.Token;
import com.pingidentity.token.TokenSignature;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Simple unit tests for a {@link TokenReplayPrevention} implementation
 */
public class ReplayPreventionSimpleTest {
    @Test
    public void testReplay() {
        TokenReplayPrevention replayPrevention = new TokenReplayPreventionImpl();
        // Create a test Token to test the TokenReplayPrevention
        // A dummy token ID
        String tokenID = "dummy-token-ID-1";
        // Some validity dates on the token
        Instant now = Instant.now();
        Instant notBefore = now.minusSeconds(20);
        Instant notAfter = now.plusSeconds(60);
        // For testing, just convert the tokenID to bytes for the raw token value.  A real token might have more stuff
        // but this is sufficient for testing the replay prevention
        byte[] rawToken = tokenID.getBytes();
        // This TokenReplayPrevention class shouldn't even look at the signature so we'll just leave it null
        TokenSignature tokenSignature = null;
        // Create a test Token
        Token token = new Token(tokenID, notBefore, notAfter, tokenSignature, rawToken);
        // Now do some tests
        // The first check shouldn't be a replay because it's the first time TokenReplayPrevention object has seen it
        assertTrue(!replayPrevention.isTokenReplayed(token));
        // The second check should be a replay because we are giving TokenReplayPrevention the same token again
        assertTrue(replayPrevention.isTokenReplayed(token));
    }

    // Test a single token, basic sanity, NPEs, etc.
    @Test
    public void testSingle() {
        TokenReplayPrevention tokenReplayPrevention = new TokenReplayPreventionImpl(TimeUnit.SECONDS, 1);
        Token token = createToken("dummy-token-ID-1", 10, 50);
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token));
    }

    // Test Case for 3 unique token
    @Test
    public void testUniqueTokens() {
        Token token1 = createToken("dummy-token-ID-1", 10, 60);
        Token token2 = createToken("dummy-token-ID-2", 20, 60);
        Token token3 = createToken("dummy-token-ID-3", 30, 60);
        TokenReplayPrevention tokenReplayPrevention = new TokenReplayPreventionImpl(TimeUnit.SECONDS, 1);
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token1));
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token2));
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token3));
    }

    // Create unique tokens and then repeat tokens
    @Test
    public void testDuplicateTokens() {
        Token token1 = createToken("dummy-token-ID-1", 20, 60);
        Token token2 = createToken("dummy-token-ID-2", 20, 60);
        Token token3 = createToken("dummy-token-ID-3", 20, 60);
        Token token4 = createToken("dummy-token-ID-1", 20, 60);
        TokenReplayPrevention tokenReplayPrevention = new TokenReplayPreventionImpl(TimeUnit.SECONDS, 1);
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token1));
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token2));
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token3));
        assertTrue("Unique Token Not Found", tokenReplayPrevention.isTokenReplayed(token1));
        assertTrue("Unique Token Not Found", tokenReplayPrevention.isTokenReplayed(token4));
    }

    // Replaying expired token results in Exception
    @Test(expected = IllegalArgumentException.class)
    public void testIgnoreExpiredTokens() throws Exception {
        Token token1 = createToken("dummy-token-ID-1", 20, 1);
        Token token2 = createToken("dummy-token-ID-1", -20, 60);
        TokenReplayPrevention tokenReplayPrevention = new TokenReplayPreventionImpl(TimeUnit.SECONDS, 1);
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token1));
        Thread.sleep(1000);
        assertFalse("Unique Token Found", tokenReplayPrevention.isTokenReplayed(token2));
    }

    // Test Case to verify the expired tokens get removed
    @Test
    public void testCleanup() throws Exception {
        // 3 tokens with a 1 sec expiration
        Token token1 = createToken("dummy-token-ID-1", 5, 1);
        Token token2 = createToken("dummy-token-ID-2", 5, 2);
        Token token3 = createToken("dummy-token-ID-3", 5, 2);
        // One long-lived token
        Token token4 = createToken("dummy-token-ID-1", 5, 720);
        TokenReplayPreventionImpl tokenReplayPreventionImpl = new TokenReplayPreventionImpl(TimeUnit.MILLISECONDS, 1);
        assertFalse("Unique Token Found", tokenReplayPreventionImpl.isTokenReplayed(token1));
        assertFalse("Unique Token Found", tokenReplayPreventionImpl.isTokenReplayed(token2));
        assertFalse("Unique Token Found", tokenReplayPreventionImpl.isTokenReplayed(token3));
        // Sleep 1 sec, to allow expiration
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        assertFalse("Unique Token Found", tokenReplayPreventionImpl.isTokenReplayed(token4));
        // Token map size should be 3 now (two old ones and one current)
        assertEquals("token map size mismatch", 3, tokenReplayPreventionImpl.getTokenMapSize());
        tokenReplayPreventionImpl.afterPropertiesSet();
        Thread.sleep(1000);
        // Should be only one left after cleanup
        assertEquals("token map size mismatch", 1, tokenReplayPreventionImpl.getTokenMapSize());
        tokenReplayPreventionImpl.destroy();
    }

    private Token createToken(String tokenID, int notBeforeSeconds, int notAfterSeconds) {
        Instant now = Instant.now();
        Instant notBefore = now.minusSeconds(notBeforeSeconds);
        Instant notAfter = now.plusSeconds(notAfterSeconds);
        return new Token(tokenID, notBefore, notAfter, null, tokenID.getBytes());
    }
}
