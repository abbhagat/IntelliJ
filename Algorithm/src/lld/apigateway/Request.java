package lld.apigateway;

import java.util.Map;

public class Request {
  String path;
  String method;
  Map<String, String> headers;
  String body;
}

