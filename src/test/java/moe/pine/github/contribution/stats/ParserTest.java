package moe.pine.github.contribution.stats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
    @InjectMocks
    private Parser parser;

    @Test
    public void getTest() {
        final List<Contribution> contributions = parser.parse(TestUtils.getContributionsHtml());
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
    }


    @Test(expected = NullPointerException.class)
    public void getTest_nullBody() throws IOException {
        parser.parse(null);
    }
}
