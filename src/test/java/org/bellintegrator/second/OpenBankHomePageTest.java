package org.bellintegrator.second;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenBankHomePageTest extends BaseTests {

    @ParameterizedTest
    @ValueSource(strings = { "Открытие" })
    public void testOpenBankPageExchangeRateBlock(String searchQuery) {
        commonTestSteps(searchQuery);
        OpenBankHomePage openBankHomePage = new OpenBankHomePage(chromeDriver);
        assertTrue(openBankHomePage.isExchangeBlockPresent(), "Блок 'Курс обмена' не найден.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Открытие" })
    public void testAllCoursesLinkPresentOnOpenBankHomePage(String searchQuery) {
        commonTestSteps(searchQuery);
        OpenBankHomePage openBankHomePage = new OpenBankHomePage(chromeDriver);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10); // Время ожидания до 10 секунд
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Все курсы')]")));
        assertTrue(openBankHomePage.isAllCoursesLinkPresent(), "Ссылка 'Все курсы' не найдена на домашней странице банка 'Открытие'.");
    }

    private void commonTestSteps(String searchQuery) {
        chromeDriver.get("https://www.google.com/");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor(searchQuery);
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        resultsPage.clickOnLinkWithTitle("Банк Открытие: кредит наличными, ипотека, кредитные и ...");
        resultsPage.switchToNewTab();
    }
}




