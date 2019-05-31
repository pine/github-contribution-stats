package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import java.util.List;

public class ContributionStatsClient {
    private final WebClient webClient;
    private final Aggregator aggregator;

    public ContributionStatsClient() {
        this(new WebClient(), new Aggregator());
    }

    ContributionStatsClient(
            final WebClient webClient,
            final Aggregator aggregator
    ) {
        this.webClient = webClient;
        this.aggregator = aggregator;
    }

    public ContributionStats collect(@Nonnull final String username) {
        final List<Contribution> contributions = webClient.get();
        final Aggregator.Streaks streaks = aggregator.computeStreaks();

        return new ContributionStats(
                contributions,
                streaks.currentStreak,
                streaks.longestStreak);
    }
}
