package moe.pine.github.contribution.stats;

import moe.pine.nonnull.Nullable;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;


class DefaultWebClient implements WebClient {
    private final HttpClient httpClient;

    DefaultWebClient() {
        httpClient = HttpClient.create();
    }

    @Override
    @Nullable
    public String get(final String uri) throws InterruptedException {
        final Mono<String> mono =
            httpClient
                .get()
                .uri(uri)
                .responseContent()
                .aggregate()
                .asString();

        try {
            return mono.block();
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InterruptedException) {
                throw (InterruptedException) e.getCause();
            }
            throw e;
        }
    }
}
