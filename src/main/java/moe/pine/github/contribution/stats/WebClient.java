package moe.pine.github.contribution.stats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WebClient {
    private static final String ENDPOINT = "https://github.com/users/%s/contributions";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Nonnull
    @SuppressWarnings("ResultOfMethodCallIgnored")
    List<Contribution> get(@Nonnull final String username) throws IOException {
        Objects.requireNonNull(username);

        if (username.isEmpty()) {
            throw new IllegalArgumentException("`username` should not be empty.");
        }

        final String endpoint = String.format(ENDPOINT, username);
        final Document document = Jsoup.connect(endpoint).get();
        final Elements elements = document.select("rect");

        return elements
            .stream()
            .flatMap(element -> {
                @Nonnull final String dateString = element.attr("data-date");
                @Nonnull final String countString = element.attr("data-count");

                if (dateString.isEmpty()) {
                    return Stream.empty();
                }
                if (countString.isEmpty()) {
                    return Stream.empty();
                }

                final LocalDate date = LocalDate.parse(dateString, FORMATTER);
                final int count = Integer.parseInt(countString);
                return Stream.of(new Contribution(date, count));
            })
            .collect(Collectors.toList());
    }
}
