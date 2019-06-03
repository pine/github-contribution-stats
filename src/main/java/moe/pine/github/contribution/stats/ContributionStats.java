package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class ContributionStats {
    private final List<Contribution> contributions;
    private final Streak currentStreak;
    private final Streak longestStreak;
    private final Summary summary;

    public ContributionStats(
        @Nonnull final List<Contribution> contributions,
        @Nonnull final Streak currentStreak,
        @Nonnull final Streak longestStreak,
        @Nonnull final Summary summary
    ) {
        this.contributions = Objects.requireNonNull(contributions);
        this.currentStreak = Objects.requireNonNull(currentStreak);
        this.longestStreak = Objects.requireNonNull(longestStreak);
        this.summary = Objects.requireNonNull(summary);
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

    @Nonnull
    public Summary getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "ContributionStats{" +
                "contributions=" + contributions +
                ", currentStreak=" + currentStreak +
                ", longestStreak=" + longestStreak +
                ", summary=" + summary +
                '}';
    }
}
