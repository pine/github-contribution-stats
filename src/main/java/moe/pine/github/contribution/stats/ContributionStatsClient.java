package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ContributionStatsClient {
    private final WebClient webClient;
    private final Parser parser;
    private final Aggregator aggregator;

    public ContributionStatsClient() {
        this(new WebClient(), new Parser(), new Aggregator());
    }

    ContributionStatsClient(
        final WebClient webClient,
        final Parser parser,
        final Aggregator aggregator
    ) {
        this.webClient = Objects.requireNonNull(webClient);
        this.parser = Objects.requireNonNull(parser);
        this.aggregator = Objects.requireNonNull(aggregator);
    }

    public ContributionStats collect(@Nonnull final String username) throws IOException {
        final String body = webClient.get(username);
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
