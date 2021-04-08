package org.retail.order.util;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class Util {

    public static HttpComponentsClientHttpRequestFactory getHttpComponentsClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        return factory;
    }
}
