package moe.pine.github.contribution.stats;

import reactor.netty.http.client.HttpClient;

import javax.annotation.Nonnull;

class WebClient {
    private final HttpClient httpClient;

    WebClient() {
        this(HttpClient.create());
    }

    WebClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    String get(@Nonnull final String uri) {
        return httpClient
                .get()
                .uri(uri)
                .responseContent()
                .aggregate()
                .asString()
                .block();
    }
}
