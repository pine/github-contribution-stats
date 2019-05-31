package moe.pine.github.contribution.stats;

import java.time.LocalDate;

public class Contribution {
    private LocalDate date;
    private int count;

    Contribution(final LocalDate date, final int count) {
        this.date = date;
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }
}
