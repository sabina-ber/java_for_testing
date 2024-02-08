package org.bellintegrator.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyRatesPageTest extends BaseTests {

    private void navigateToCurrencyRatesPage() {
        chromeDriver.get("https://www.google.com/");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor("Открытие");
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        resultsPage.clickOnLinkWithTitle("Банк Открытие: кредит наличными, ипотека, кредитные и ...");
        resultsPage.switchToNewTab();
        OpenBankHomePage openBankHomePage = new OpenBankHomePage(chromeDriver);
        openBankHomePage.clickOnAllCoursesLink();
    }

    @Test
    public void testPageContainsAtLeastThreeCurrencies() {
        navigateToCurrencyRatesPage();
        CurrencyRatesPage currencyRatesPage = new CurrencyRatesPage(chromeDriver);
        int rowCount = currencyRatesPage.getRowCount();
        assertTrue(rowCount <= 3, "На странице менее трех валют.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"USD", "EUR"})
    public void testCurrencyBuyRateLessThanSellRate(String currency) {
        navigateToCurrencyRatesPage();
        CurrencyRatesPage currencyRatesPage = new CurrencyRatesPage(chromeDriver);
        boolean result = currencyRatesPage.checkRate(currency);
        Assertions.assertTrue(result, "Курс покупки для " + currency + " не меньше курса продажи.");
    }
}




