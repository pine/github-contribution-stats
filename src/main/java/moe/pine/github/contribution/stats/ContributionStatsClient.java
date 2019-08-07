package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ContributionStatsClient {
    private final WebClient webClient;
    private UriBuilder uriBuilder;
    private final Parser parser;
    private final Aggregator aggregator;

    public static ContributionStatsClient create() {
        return create(WebClient.create());
    }

    public static ContributionStatsClient create(@Nonnull final WebClient webClient) {
        return new ContributionStatsClient(
                webClient, new UriBuilder(), new Parser(), new Aggregator());
    }

    ContributionStatsClient(
            final WebClient webClient,
            final UriBuilder uriBuilder,
            final Parser parser,
            final Aggregator aggregator
    ) {
        this.webClient = Objects.requireNonNull(webClient);
        this.uriBuilder = Objects.requireNonNull(uriBuilder);
        this.parser = Objects.requireNonNull(parser);
        this.aggregator = Objects.requireNonNull(aggregator);
    }

    public ContributionStats collect(@Nonnull final String username) throws IOException {
        final String uri = uriBuilder.build(username);
        final String body = webClient.get(uri);
        final List<Contribution> contributions = parser.parse(body);
        final Aggregator.Streaks streaks = aggregator.getStreaks(contributions);
        final Summary summary = aggregator.summarizeContributions(contributions);

        return new ContributionStats(
                contributions,
                streaks.currentStreak,
                streaks.longestStreak,
                summary);
    }
}
