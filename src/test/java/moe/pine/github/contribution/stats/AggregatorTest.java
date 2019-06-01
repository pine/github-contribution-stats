package moe.pine.github.contribution.stats;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AggregatorTest {
    private Aggregator aggregator;

    @Before
    public void setUp() {
        aggregator = new Aggregator();
    }

    @Test
    public void getStreaksTest() {
        final List<Contribution> contributions = TestUtils.getContributions();
        final Aggregator.Streaks streaks = aggregator.getStreaks(contributions);

        assertEquals(
            new Streak(6,
                LocalDate.of(2019, 5, 27),
                LocalDate.of(2019, 6, 1),
                false),
            streaks.currentStreak);

        assertEquals(
            new Streak(77,
                LocalDate.of(2018, 5, 27),
                LocalDate.of(2018, 8, 11),
                false),
            streaks.longestStreak);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStreaksTest_illegalContributions() {
        aggregator.getStreaks(Collections.emptyList());
    }
}
