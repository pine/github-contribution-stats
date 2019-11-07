package moe.pine.github.contribution.stats;

import moe.pine.nonnull.Nullable;
import reactor.netty.http.client.HttpClient;


class DefaultWebClient implements WebClient {
    private final HttpClient httpClient;

    DefaultWebClient() {
        httpClient = HttpClient.create();
    }

    @Override
    @Nullable
    public String get(final String uri) {
        return httpClient
            .get()
            .uri(uri)
            .responseContent()
            .aggregate()
            .asString()
            .block();
    }
}
