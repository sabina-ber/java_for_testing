package org.bellintegrator.third;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

class GoogleSearchTests extends BaseTests {

    @ParameterizedTest(name = "Проверка открытия главной страницы Google и наличия ссылки на Википедию для запроса {0}")
    @ValueSource(strings = {"таблица"}) // Параметр для тестирования
    void testGoogleSearchAndWikipediaLink(String searchQuery) {
        chromeDriver.get("https://www.google.com/");
        String title = chromeDriver.getTitle();
        Assertions.assertTrue(title.contains("Google"), "Главная страница Google не открылась.");

        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);

        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        Assertions.assertFalse(resultsPage.getSearchResultsTitles().isEmpty(), "Результаты поиска не отображаются для запроса \"" + searchQuery + "\".");
        Assertions.assertTrue(resultsPage.isWikipediaLinkPresent(), "Ссылка на Википедию не найдена среди результатов поиска для запроса \"" + searchQuery + "\".");
    }
}



