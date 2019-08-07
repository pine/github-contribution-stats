package moe.pine.github.contribution.stats;

import moe.pine.nonnull.Nullable;
import reactor.netty.http.client.HttpClient;


public abstract class WebClient {
    public static WebClient create() {
        return new WebClientImpl();
    }

    @Nullable
    public abstract String get(final String uri);

    static class WebClientImpl extends WebClient {
        private final HttpClient httpClient;

        WebClientImpl() {
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
}
