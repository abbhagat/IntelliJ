package lld.apigateway;

import java.util.Map;

public record Request(String path, String method, Map<String, String> headers, String requestBody) {}
