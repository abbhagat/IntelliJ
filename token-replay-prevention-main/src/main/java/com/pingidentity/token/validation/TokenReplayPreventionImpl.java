package com.pingidentity.token.validation;

import com.pingidentity.token.Token;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * A simple implementation of token tracker using a concurrent hash map.
 */

public class TokenReplayPreventionImpl implements TokenReplayPrevention, InitializingBean, DisposableBean {
    private static final Logger LOG = Logger.getLogger(TokenReplayPreventionImpl.class.getName());

    private final Map<String, Token> tokenMap;
    private final TimeUnit cleanupPeriodTimeUnit;
    private final long cleanupPeriod;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public TokenReplayPreventionImpl() {
        this(TimeUnit.SECONDS, 1);
    }

    public TokenReplayPreventionImpl(TimeUnit cleanupPeriodTimeUnit, long cleanupPeriod) {
        this.cleanupPeriodTimeUnit = cleanupPeriodTimeUnit;
        this.cleanupPeriod = cleanupPeriod;
        tokenMap = new ConcurrentHashMap<>();
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    }

    public int getTokenMapSize() {
        return tokenMap.size();
    }

    public boolean isTokenReplayed(Token token) {
        if (!isValidToken(token)) {
            throw new IllegalArgumentException("Expired token passed");
        }
        Token found = tokenMap.get(token.getTokenID());
        if (found != null && !isValidToken(found)) {
            tokenMap.remove(token.getTokenID());
        }
        found = tokenMap.putIfAbsent(token.getTokenID(), token);
        return found != null;
    }

    private void cleanupExpiredTokens() {
        LOG.info("Cleaning up expired tokenMap, map size before cleanup: " + tokenMap.size());
        tokenMap.entrySet().removeIf(e -> !isValidToken(e.getValue())); // e represents Map.Entry<String, Token>
        LOG.info("Map size after cleanup: " + tokenMap.size());
    }

    private boolean isValidToken(Token token) {
        Instant now = Instant.now();
        return now.isAfter(token.getNotValidBefore()) && now.isBefore(token.getNotValidAfter());
    }

    @Override
    public void afterPropertiesSet() {
        scheduledThreadPoolExecutor.scheduleAtFixedRate(this::cleanupExpiredTokens, 0, cleanupPeriod, cleanupPeriodTimeUnit);
    }

    @Override
    public void destroy() {
        scheduledThreadPoolExecutor.shutdownNow();
    }
}
