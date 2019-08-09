package moe.pine.github.contribution.stats;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

@SuppressWarnings("NullableProblems")
public class ContributionStatsClientIT {
    private static final List<String> USERNAMES =
            Collections.singletonList("pine");

    private ContributionStatsClient contributionStatsClient;

    @Before
    public void setUp() {
        contributionStatsClient = ContributionStatsClient.create();
    }

    @Test
    public void getTest() throws IOException {
        for (final String username : USERNAMES) {
            final ContributionStats contributionStats =
                    contributionStatsClient.collect(username);
            assertFalse(contributionStats.getContributions().isEmpty());
        }
    }
}
