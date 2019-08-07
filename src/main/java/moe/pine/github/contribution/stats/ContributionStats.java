package moe.pine.github.contribution.stats;

import java.util.List;
import java.util.Objects;

public class ContributionStats {
    private final List<Contribution> contributions;
    private final Streak currentStreak;
    private final Streak longestStreak;
    private final Summary summary;

    public ContributionStats(
        final List<Contribution> contributions,
        final Streak currentStreak,
        final Streak longestStreak,
        final Summary summary
    ) {
        this.contributions = Objects.requireNonNull(contributions);
        this.currentStreak = Objects.requireNonNull(currentStreak);
        this.longestStreak = Objects.requireNonNull(longestStreak);
        this.summary = Objects.requireNonNull(summary);
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public Streak getCurrentStreak() {
        return currentStreak;
    }

    public Streak getLongestStreak() {
        return longestStreak;
    }

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
