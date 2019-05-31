package moe.pine.github.contribution.stats;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WebClient.class, Jsoup.class})
public class WebClientTest {
    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
    }

    @Test
    public void getTest() {

    }
}
