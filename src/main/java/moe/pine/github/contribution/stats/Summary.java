package moe.pine.github.contribution.stats;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;

public class Summary {
    @Nonnull
    private LocalDate end;

    @Nonnull
    private LocalDate start;

    private int total;

    @Nullable
    private Contribution busiestDay;

    public Summary(
        @Nonnull LocalDate end,
        @Nonnull LocalDate start,
        int total,
        @Nullable Contribution busiestDay
    ) {
        this.end = end;
        this.start = start;
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
}
