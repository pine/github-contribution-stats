package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Aggregator {
    static class Streaks {
        @Nonnull
        Streak currentStreak = new Streak();

        @Nonnull
        Streak longestStreak = new Streak();
    }

    @Nonnull
    @SuppressWarnings("ResultOfMethodCallIgnored")
    Streaks getStreaks(@Nonnull final List<Contribution> contributions) {
        Objects.requireNonNull(contributions);

        if (contributions.isEmpty()) {
            throw new IllegalArgumentException("`contributions` should not be empty.");
        }

        final LocalDate start = contributions.get(0).getDate();
        final LocalDate end = contributions.get(contributions.size() - 1).getDate();
        final Streak currentStreak = new Streak();
        final Streak longestStreak = new Streak();

        for (Contribution contribution : contributions) {
            if (contribution.getCount() > 0) {
                currentStreak.setDays(currentStreak.getDays() + 1);
                currentStreak.setEnd(contribution.getDate());
                if (currentStreak.getStart() == null) {
                    currentStreak.setStart(contribution.getDate());
                }
                if (currentStreak.getDays() >= longestStreak.getDays()) {
                    longestStreak.setDays(currentStreak.getDays());
                    longestStreak.setStart(currentStreak.getStart());
                    longestStreak.setEnd(currentStreak.getEnd());
                }
            } else if (Objects.equals(contribution.getDate(), end)) {
                currentStreak.setDays(0);
                currentStreak.setStart(null);
                currentStreak.setEnd(null);
            }
        }

        if (Objects.equals(currentStreak.getStart(), start) && Objects.equals(currentStreak.getEnd(), end)) {
            currentStreak.setUnmeasurable(true);
            longestStreak.setUnmeasurable(true);
        }

        final Streaks streaks = new Streaks();
        streaks.currentStreak = currentStreak;
        streaks.longestStreak = longestStreak;

        return streaks;
    }

    @Nonnull
    @SuppressWarnings("ResultOfMethodCallIgnored")
    Summary summarizeContributions(@Nonnull final List<Contribution> contributions) {
        Objects.requireNonNull(contributions);

        if (contributions.isEmpty()) {
            throw new IllegalArgumentException("`contributions` should not be empty.");
        }

        final LocalDate start = contributions.get(0).getDate();
        final LocalDate end = contributions.get(contributions.size() - 1).getDate();

        final int total =
            contributions.stream()
                .map(Contribution::getCount)
                .mapToInt(Integer::valueOf)
                .sum();

        @Nullable final Contribution busiestDay =
            contributions.stream()
                .filter(v -> v.getCount() > 0)
                .max(Comparator
                    .comparingInt(Contribution::getCount)
                    .thenComparing(Contribution::getDate))
                .orElse(null);

        return new Summary(start, end, total, busiestDay);
    }
}
