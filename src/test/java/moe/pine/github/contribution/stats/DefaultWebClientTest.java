package moe.pine.github.contribution.stats;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DefaultWebClientTest {
    private DefaultWebClient defaultWebClient;
    private MockWebServer mockWebServer;

    @Before
    public void setUp() {
        defaultWebClient = new DefaultWebClient();
        mockWebServer = new MockWebServer();
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void getTest() throws InterruptedException {
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setBody("body");
        mockWebServer.enqueue(mockResponse);

        final String uri = mockWebServer.url("/test").toString();
        final String body = defaultWebClient.get(uri);
        assertEquals("body", body);

        final RecordedRequest recordedRequest =
            mockWebServer.takeRequest(0L, TimeUnit.MILLISECONDS);
        assertNotNull(recordedRequest);
        assertEquals("/test", recordedRequest.getPath());
    }
}
