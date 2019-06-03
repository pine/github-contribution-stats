package moe.pine.github.contribution.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class ContributionTest {
    @Test
    public void constructorTest() {
        final LocalDate date = LocalDate.of(2019, 6, 1);
        final Contribution contribution = new Contribution(date, 1);

        assertEquals(date, contribution.getDate());
        assertEquals(1, contribution.getCount());
    }

    @Test
    public void equalsTest() {
        final LocalDate date = LocalDate.of(2019, 6, 3);
        final Contribution contribution1 = new Contribution(date, 1);
        final Contribution contribution2 = new Contribution(date, 1);
        final Contribution contribution3 = new Contribution(date, 2);

        assertNotSame(contribution1, contribution2);
        assertEquals(contribution1, contribution2);
        assertNotEquals(contribution2, contribution3);
    }

    @Test
    public void hashCodeTest() {
        final LocalDate date = LocalDate.of(2019, 6, 3);
        final Contribution contribution1 = new Contribution(date, 1);
        final Contribution contribution2 = new Contribution(date, 1);

        assertNotSame(contribution1, contribution2);
        assertEquals(contribution1.hashCode(), contribution2.hashCode());
    }
}
