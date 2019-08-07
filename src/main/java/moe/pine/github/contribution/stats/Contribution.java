package moe.pine.github.contribution.stats;

import java.time.LocalDate;
import java.util.Objects;

public class Contribution {
    private final LocalDate date;
    private final int count;

    public Contribution(
        final LocalDate date,
        final int count
    ) {
        this.date = Objects.requireNonNull(date);
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribution that = (Contribution) o;
        return count == that.count &&
            date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, count);
    }

    @Override
    public String toString() {
        return "Contribution{" +
            "date=" + date +
            ", count=" + count +
            '}';
    }
}
