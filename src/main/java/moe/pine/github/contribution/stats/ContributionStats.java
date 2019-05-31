package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class ContributionStats {
    private final List<Contribution> contributions;
    private final Streak currentStreak;
    private final Streak longestStreak;

    ContributionStats(
        @Nonnull final List<Contribution> contributions,
        @Nonnull final Streak currentStreak,
        @Nonnull final Streak longestStreak
    ) {
        this.contributions = Objects.requireNonNull(contributions);
        this.currentStreak = Objects.requireNonNull(currentStreak);
        this.longestStreak = Objects.requireNonNull(longestStreak);
    }

    @Nonnull
    public List<Contribution> getContributions() {
        return contributions;
    }

    @Nonnull
    public Streak getCurrentStreak() {
        return currentStreak;
    }

    @Nonnull
    public Streak getLongestStreak() {
        return longestStreak;
    }
}
