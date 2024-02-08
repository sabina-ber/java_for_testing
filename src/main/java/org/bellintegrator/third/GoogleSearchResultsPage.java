package org.bellintegrator.third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

/**
 * Класс для работы со страницей результатов поиска Google.
 * Предоставляет методы для взаимодействия с результатами поиска, включая переходы по ссылкам и проверки наличия определенных результатов.
 * @author Автор: Сабина Березина
 */
public class GoogleSearchResultsPage {

    protected WebDriver driver;

    /**
     * Находит заголовки результатов поиска на странице.
     */
    @FindBy(xpath = "//a/h3")
    private List<WebElement> searchResultsTitles;

    /**
     * Находит ссылки на Википедию в результатах поиска.
     */
    @FindBy(xpath = "//a[contains(@href, 'wikipedia.org')]")
    private List<WebElement> wikipediaLinks;

    /**
     * Конструктор для инициализации страницы результатов поиска Google с заданным драйвером.
     *
     * @param driver WebDriver, используемый для взаимодействия с браузером.
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Кликает по ссылке в результате поиска, которая содержит заданный текст.
     *
     * @param titlePart Часть заголовка ссылки для поиска и клика.
     */
    public void clickOnLinkWithTitle(String titlePart) {
        for (WebElement searchResult : searchResultsTitles) {
            if (searchResult.getText().contains(titlePart)) {
                searchResult.click();
                break;
            }
        }
    }

    /**
     * Переключается на новую вкладку (новое окно браузера) и активирует ее.
     */
    public void switchToNewTab() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(driver.getWindowHandle())) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    /**
     * Проверяет наличие результата поиска с заданным текстом в заголовке.
     *
     * @param titlePart Часть заголовка для проверки присутствия среди результатов поиска.
     * @return true, если такой результат найден.
     */
    public boolean isResultWithTitlePresent(String titlePart) {
        return searchResultsTitles.stream().anyMatch(e -> e.getText().contains(titlePart));
    }


    /**
     * Проверяет, присутствуют ли в результатах поиска ссылки на Википедию.
     *
     * @return true, если найдена хотя бы одна ссылка на Википедию.
     */
    public boolean isWikipediaLinkPresent() {
        return !wikipediaLinks.isEmpty();
    }

    /**
     * Возвращает список WebElement, представляющих заголовки результатов поиска.
     *
     * @return Список WebElement с заголовками результатов поиска.
     */
    public List<WebElement> getSearchResultsTitles() {
        return searchResultsTitles;
    }

    /**
     * Кликает по первой найденной ссылке на Википедию в результатах поиска.
     */
    public void clickFirstWikipediaLink() {
        List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href, 'wikipedia.org')]"));
        if (!links.isEmpty()) {
            links.get(0).click();
        }
    }

}
