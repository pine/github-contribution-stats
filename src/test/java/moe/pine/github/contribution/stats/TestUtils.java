package moe.pine.github.contribution.stats;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

class TestUtils {
    static String getContributionsHtml() {
        try {
            return IOUtils.toString(
                TestUtils.class.getResourceAsStream("/contributions.html"),
                StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static List<Contribution> getContributions() {
        final Document document = Jsoup.parse(getContributionsHtml());
        return new WebClient().getByDocument(document);
    }
}
