package moe.pine.github.contribution.stats;

import reactor.netty.http.client.HttpClient;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ContributionStatsClient {
    private final Parser parser;
    private final Aggregator aggregator;

    public ContributionStatsClient() {
        this(new Parser(), new Aggregator());
    }

    ContributionStatsClient(
            final Parser parser,
            final Aggregator aggregator
    ) {
        this.parser = Objects.requireNonNull(parser);
        this.aggregator = Objects.requireNonNull(aggregator);
    }

    public ContributionStats collect(@Nonnull final String username) throws IOException {
        final String body =
                HttpClient.create()
                        .get()
                        .uri("https://github.com/users/" + username + "/contributions")
                        .responseContent()
                        .aggregate()
                        .asString()
                        .block();

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
