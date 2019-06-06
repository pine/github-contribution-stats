package moe.pine.github.contribution.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class StreakTest {
    @Test
    public void isUnmeasurableTest() {
        final Streak streak = new Streak();

        assertFalse(streak.isUnmeasurable());

        streak.setUnmeasurable(true);

        assertTrue(streak.isUnmeasurable());
    }

    @Test
    public void equalsTest() {
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
    public void equalsTest_empty() {
        final Streak streak1 = new Streak();
        final Streak streak2 = new Streak();

        assertNotSame(streak1, streak2);
        assertEquals(streak1, streak2);
    }

    @Test
    public void hashCodeTest() {
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

        assertEquals(streak1.hashCode(), streak2.hashCode());
    }

    @Test
    public void toStringTest() {
        final Streak streak = new Streak();
        streak.setDays(5);
        streak.setStart(LocalDate.of(2019, 6, 5));
        streak.setEnd(LocalDate.of(2019, 6, 6));
        streak.setUnmeasurable(true);

        assertEquals(
            "Streak{days=5, start=2019-06-05, end=2019-06-06, unmeasurable=true}",
            streak.toString());
    }
}
