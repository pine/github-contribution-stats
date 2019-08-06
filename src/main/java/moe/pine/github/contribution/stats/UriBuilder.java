package moe.pine.github.contribution.stats;

public class UriBuilder {
    private static final String BASE_URI = "https://github.com";
    private static final String PATH = "/users/%s/contributions";

    private final String baseUri;

    String build(final String username) {
        return baseUri + String.format(PATH, username);
    }
}
