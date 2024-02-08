package org.bellintegrator.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class GoogleSearchTests extends BaseTests {

    @ParameterizedTest
    @ValueSource(strings = { "Гладиолус", "Тюльпан" })
    @DisplayName("Проверка отображения результатов поиска")
    public void testSearchResultsDisplayed(String searchQuery) {
        chromeDriver.get("https://www.google.com");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        Assertions.assertFalse(resultsPage.getSearchResultsTitles().isEmpty(), "Результаты поиска для запроса \"" + searchQuery + "\" не отображаются.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Гладиолус", "Роза" })
    @DisplayName("Проверка наличия ссылки на Википедию")
    public void testWikipediaLinkPresent(String searchQuery) {
        chromeDriver.get("https://www.google.com");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        Assertions.assertTrue(resultsPage.isWikipediaLinkPresent(), "Ссылка на Википедию о \"" + searchQuery + "\" не найдена среди результатов поиска.");
    }
}


