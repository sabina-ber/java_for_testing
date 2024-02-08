package org.bellintegrator.second;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTests extends BaseTests {

    @ParameterizedTest
    @ValueSource(strings = { "Открытие" })
    public void testGoogleHomePageOpens(String searchQuery) {
        chromeDriver.get("https://www.google.com/");
        assertTrue(chromeDriver.getTitle().contains("Google"), "Главная страница Google не открылась.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Открытие" })
    public void testSearchForOpenBank(String searchQuery) {
        chromeDriver.get("https://www.google.com/");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        assertTrue(resultsPage.isResultWithTitlePresent("Банк Открытие: кредит наличными, ипотека, кредитные и ..."),
                "На странице результатов поиска отсутствует заголовок с текстом \"Банк Открытие: кредит наличными, ипотека, кредитные и ...\"");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Открытие" })
    public void testOpenTheOpenBankPage(String searchQuery) {
        chromeDriver.get("https://www.google.com/");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        assertTrue(resultsPage.isResultWithTitlePresent("Банк Открытие: кредит наличными, ипотека, кредитные и ..."),
                "На странице результатов поиска отсутствует заголовок с текстом \"Банк Открытие: кредит наличными, ипотека, кредитные и ...\"");
    }
}


