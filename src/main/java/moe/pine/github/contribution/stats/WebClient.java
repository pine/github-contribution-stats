package moe.pine.github.contribution.stats;

import reactor.netty.http.client.HttpClient;

import javax.annotation.Nonnull;

public abstract class WebClient {
    public static WebClient create() {
        return new WebClientImpl();
    }

    public abstract String get(@Nonnull final String uri);

    static class WebClientImpl extends WebClient {
        private final HttpClient httpClient;

        WebClientImpl() {
            httpClient = HttpClient.create();
        }

        @Override
        public String get(@Nonnull final String uri) {
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
