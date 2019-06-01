package moe.pine.github.contribution.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ContributionTest {
    @Test
    public void constructorTest() {
        final LocalDate date = LocalDate.of(2019, 6, 1);
        final Contribution contribution = new Contribution(date, 1);

        assertEquals(date, contribution.getDate());
        assertEquals(1, contribution.getCount());
    }
}
