package moe.pine.github.contribution.stats;

import java.util.List;

public class ContributionStats {
    final List<Contribution> contributions;
    final Streak currentStreak;
    final Streak longestStreak;

    ContributionStats(
            final List<Contribution> contributions,
            final Streak currentStreak,
            final Streak longestStreak
    ) {
        this.contributions = contributions;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
    }

    public Streak getCurrentStreak() {
        return currentStreak;
    }

    public Streak getLongestStreak() {
        return longestStreak;
    }
}
