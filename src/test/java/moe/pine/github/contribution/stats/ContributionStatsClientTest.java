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
    private WebClient webClient;

    @Mock
    private UriBuilder uriBuilder;

    @Mock
    private Parser parser;

    @Mock
    private Aggregator aggregator;

    @InjectMocks
    private ContributionStatsClient client;

    @Test
    public void createTest_noArgs() {
        final ContributionStatsClient client = ContributionStatsClient.create();
        final WebClient webClient = Whitebox.getInternalState(client, "webClient");
        final UriBuilder uriBuilder = Whitebox.getInternalState(client, "uriBuilder");
        final Parser parser = Whitebox.getInternalState(client, "parser");
        final Aggregator aggregator = Whitebox.getInternalState(client, "aggregator");

        assertNotNull(webClient);
        assertNotNull(uriBuilder);
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

        when(uriBuilder.build("username")).thenReturn("https://example.com/username");
        when(webClient.get("https://example.com/username")).thenReturn("body");
        when(parser.parse("body")).thenReturn(contributions);
        when(aggregator.getStreaks(contributions)).thenReturn(streaks);
        when(aggregator.summarizeContributions(contributions)).thenReturn(summary);

        final ContributionStats stats = client.collect("username");

        assertEquals(contributions, stats.getContributions());
        assertSame(streaks.currentStreak, stats.getCurrentStreak());
        assertSame(streaks.longestStreak, stats.getLongestStreak());
        assertSame(summary, stats.getSummary());

        verify(uriBuilder).build("username");
        verify(webClient).get("https://example.com/username");
        verify(parser).parse("body");
        verify(aggregator).getStreaks(contributions);
        verify(aggregator).summarizeContributions(contributions);
    }
}
