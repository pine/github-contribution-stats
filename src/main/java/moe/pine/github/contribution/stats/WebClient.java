package moe.pine.github.contribution.stats;

import reactor.netty.http.client.HttpClient;

class WebClient {
    private static final String ENDPOINT = "https://github.com/users/%s/contributions";

    private final HttpClient httpClient;

    WebClient() {
        this(HttpClient.create());
    }

    WebClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    String get(final String username) {
        final String endpoint = String.format(ENDPOINT, username);
        return httpClient
            .get()
            .uri(endpoint)
            .responseContent()
            .aggregate()
            .asString()
            .block();
    }
}
