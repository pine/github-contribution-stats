package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Objects;

public class Summary {
    @Nonnull
    private LocalDate start;

    @Nonnull
    private LocalDate end;

    private int total;

    @Nullable
    private Contribution busiestDay;

    public Summary(
            @Nonnull final LocalDate start,
            @Nonnull final LocalDate end,
            final int total,
            @Nullable final Contribution busiestDay
    ) {
        this.start = Objects.requireNonNull(start);
        this.end = Objects.requireNonNull(end);
        this.total = total;
        this.busiestDay = busiestDay;
    }

    @Nonnull
    public LocalDate getEnd() {
        return end;
    }

    @Nonnull
    public LocalDate getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    @Nullable
    public Contribution getBusiestDay() {
        return busiestDay;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "start=" + start +
                ", end=" + end +
                ", total=" + total +
                ", busiestDay=" + busiestDay +
                '}';
    }
}
