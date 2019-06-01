package moe.pine.github.contribution.stats;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Objects;

public class Streak {
    private int days;

    @Nullable
    private LocalDate start;

    @Nullable
    private LocalDate end;

    private boolean unmeasurable;

    public Streak() {
    }

    public Streak(int days, LocalDate start, LocalDate end, boolean unmeasurable) {
        this.days = days;
        this.start = start;
        this.end = end;
        this.unmeasurable = unmeasurable;
    }

    public int getDays() {
        return days;
    }

    void setDays(int days) {
        this.days = days;
    }

    @Nullable
    public LocalDate getStart() {
        return start;
    }

    void setStart(@Nullable LocalDate start) {
        this.start = start;
    }

    @Nullable
    public LocalDate getEnd() {
        return end;
    }

    void setEnd(@Nullable LocalDate end) {
        this.end = end;
    }

    public boolean isUnmeasurable() {
        return unmeasurable;
    }

    void setUnmeasurable(boolean unmeasurable) {
        this.unmeasurable = unmeasurable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Streak streak = (Streak) o;
        return days == streak.days &&
            unmeasurable == streak.unmeasurable &&
            Objects.equals(start, streak.start) &&
            Objects.equals(end, streak.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, start, end, unmeasurable);
    }

    @Override
    public String toString() {
        return "Streak{" +
            "days=" + days +
            ", start=" + start +
            ", end=" + end +
            ", unmeasurable=" + unmeasurable +
            '}';
    }
}
