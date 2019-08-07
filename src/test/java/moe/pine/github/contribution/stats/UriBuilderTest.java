package moe.pine.github.contribution.stats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UriBuilderTest {
    @InjectMocks
    private UriBuilder uriBuilder;

    @Test
    public void buildTest() {
        assertEquals(
                "https://github.com/users/username/contributions",
                uriBuilder.build("username"));
    }
}
