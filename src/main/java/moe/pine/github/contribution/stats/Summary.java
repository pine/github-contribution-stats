package moe.pine.github.contribution.stats;


import reactor.util.annotation.Nullable;

import java.time.LocalDate;
import java.util.Objects;

public class Summary {
    private LocalDate start;
    private LocalDate end;

    private int total;

    @Nullable
    private Contribution busiestDay;

    public Summary(
        final LocalDate start,
        final LocalDate end,
        final int total,
        final Contribution busiestDay
    ) {
        this.start = Objects.requireNonNull(start);
        this.end = Objects.requireNonNull(end);
        this.total = total;
        this.busiestDay = busiestDay;
    }

    public LocalDate getEnd() {
        return end;
    }

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
