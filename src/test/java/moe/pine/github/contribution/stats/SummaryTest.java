package moe.pine.github.contribution.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class SummaryTest {
    @Test
    public void constructorTest() {
        final LocalDate start = LocalDate.of(2019, 6, 1);
        final LocalDate end = LocalDate.of(2019, 6, 3);
        final Contribution busiestDay = new Contribution(LocalDate.of(2019, 6, 3), 3);
        final Summary summary = new Summary(start, end, 6, busiestDay);

        assertEquals(start, summary.getStart());
        assertEquals(end, summary.getEnd());
        assertEquals(6, summary.getTotal());
        assertEquals(busiestDay, summary.getBusiestDay());
    }
}
