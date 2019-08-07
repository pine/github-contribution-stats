package moe.pine.github.contribution.stats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Parser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    List<Contribution> parse(final String body) {
        Objects.requireNonNull(body);

        final Document document = Jsoup.parse(body);
        final Elements elements = document.select("rect");
        final List<Contribution> contributions =
            elements
                .stream()
                .flatMap(element -> {
                    final String dateString = element.attr("data-date");
                    final String countString = element.attr("data-count");

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

        return Collections.unmodifiableList(contributions);
    }
}
