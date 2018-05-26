import java.util.Map;

class Request {
    private String uri;
    private HttpMethod method;
    private Map<String, String> headers;

    Request() {
    }

    String getUri() {
        return uri;
    }

    void setUri(String uri) {
        this.uri = uri;
    }

    HttpMethod getMethod() {
        return method;
    }

    void setMethod(HttpMethod method) {
        this.method = method;
    }

    Map<String, String> getHeaders() {
        return headers;
    }

    void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request{" +
                "uri='" + uri + '\'' +
                ", method=" + method +
                ", headers=" + headers +
                '}';
    }
}
