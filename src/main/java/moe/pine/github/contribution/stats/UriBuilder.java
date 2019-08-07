package moe.pine.github.contribution.stats;

class UriBuilder {
    private static final String ENDPOINT = "https://github.com/users/%s/contributions";

    String build(final String username) {
        return String.format(ENDPOINT, username);
    }
}
