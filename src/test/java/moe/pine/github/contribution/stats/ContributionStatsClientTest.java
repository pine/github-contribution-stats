package moe.pine.github.contribution.stats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContributionStatsClientTest {
    @Mock
    private Parser webClient;

    @Mock
    private Aggregator aggregator;

    @InjectMocks
    private ContributionStatsClient client;

    @Test
    public void constructorTest_noArgs() {
        final ContributionStatsClient client = new ContributionStatsClient();
        final Parser parser = Whitebox.getInternalState(client, "parser");
        final Aggregator aggregator = Whitebox.getInternalState(client, "aggregator");

        assertNotNull(parser);
        assertNotNull(aggregator);
    }

    @Test
    public void collectTest() throws IOException {
        final List<Contribution> contributions = Arrays.asList(
                new Contribution(LocalDate.of(2019, 6, 1), 1),
                new Contribution(LocalDate.of(2019, 6, 2), 2),
                new Contribution(LocalDate.of(2019, 6, 3), 3)
        );

        final Aggregator.Streaks streaks = new Aggregator.Streaks();
        streaks.currentStreak = mock(Streak.class);
        streaks.longestStreak = mock(Streak.class);

        final Summary summary = mock(Summary.class);

        when(webClient.parse("username")).thenReturn(contributions);
        when(aggregator.getStreaks(contributions)).thenReturn(streaks);
        when(aggregator.summarizeContributions(contributions)).thenReturn(summary);

        final ContributionStats stats = client.collect("username");

        assertEquals(contributions, stats.getContributions());
        assertSame(streaks.currentStreak, stats.getCurrentStreak());
        assertSame(streaks.longestStreak, stats.getLongestStreak());
        assertSame(summary, stats.getSummary());

        verify(webClient).parse("username");
        verify(aggregator).getStreaks(contributions);
        verify(aggregator).summarizeContributions(contributions);
    }
}
