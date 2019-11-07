package moe.pine.github.contribution.stats;

import moe.pine.nonnull.Nullable;


public interface WebClient {
    static WebClient create() {
        return new DefaultWebClient();
    }

    @Nullable
    String get(final String uri) throws InterruptedException;
}
