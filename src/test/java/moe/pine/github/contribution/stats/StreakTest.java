package moe.pine.github.contribution.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StreakTest {
    @Test
    public void testEquals() {
        final Streak streak1 = new Streak();
        streak1.setDays(5);
        streak1.setStart(LocalDate.of(2019, 6, 5));
        streak1.setEnd(LocalDate.of(2019, 6, 6));
        streak1.setUnmeasurable(true);

        final Streak streak2 = new Streak();
        streak2.setDays(5);
        streak2.setStart(LocalDate.of(2019, 6, 5));
        streak2.setEnd(LocalDate.of(2019, 6, 6));
        streak2.setUnmeasurable(true);

        assertNotSame(streak1, streak2);
        assertEquals(streak1, streak2);
    }

    @Test
    public void testEquals_empty() {
        final Streak streak1 = new Streak();
        final Streak streak2 = new Streak();

        assertNotSame(streak1, streak2);
        assertEquals(streak1, streak2);
    }
}
