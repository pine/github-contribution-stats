package moe.pine.github.contribution.stats;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WebClient.class, Jsoup.class})
public class WebClientTest {
    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
    }

    @Test
    public void getTest() throws IOException {
        final String body =
            IOUtils.toString(
                getClass().getResourceAsStream("/contributions.html"),
                StandardCharsets.UTF_8);

        final Document document = Jsoup.parse(body);
        final HttpConnection httpConnection = mock(HttpConnection.class);
        when(httpConnection.get()).thenReturn(document);

        mockStatic(Jsoup.class);
        when(Jsoup.connect(anyString())).thenReturn(httpConnection);

        final List<Contribution> contributions = webClient.get("pine");
        assertEquals(
            new Contribution(LocalDate.of(2018, 5, 27), 9),
            contributions.get(0));
        assertEquals(
            new Contribution(LocalDate.of(2018, 5, 28), 17),
            contributions.get(1));
        assertEquals(
            new Contribution(LocalDate.of(2018, 5, 29), 10),
            contributions.get(2));
        assertEquals(
            new Contribution(LocalDate.of(2018, 5, 30), 13),
            contributions.get(3));
        assertEquals(
            new Contribution(LocalDate.of(2018, 5, 31), 8),
            contributions.get(4));
        assertEquals(
            new Contribution(LocalDate.of(2018, 6, 1), 34),
            contributions.get(5));
        assertEquals(
            new Contribution(LocalDate.of(2018, 6, 2), 25),
            contributions.get(6));

        assertEquals(
            new Contribution(LocalDate.of(2019, 6, 1), 5),
            contributions.get(370));

        verifyStatic(Jsoup.class);
        Jsoup.connect("https://github.com/users/pine/contributions");

        verify(httpConnection).get();
    }
}
