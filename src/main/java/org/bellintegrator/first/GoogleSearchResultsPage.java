package org.bellintegrator.first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Класс страницы результатов поиска Google, предоставляет методы для работы с результатами поиска.
 * Использует Page Factory для инициализации веб-элементов.
 *
 * @author Автор: Сабина Березина
 */
public class GoogleSearchResultsPage {

    protected WebDriver driver;

    /**
     * Список заголовков результатов поиска.
     */
    @FindBy(xpath = "//a[h3]/h3")
    private List<WebElement> searchResultsTitles;

    /**
     * Список ссылок на Википедию среди результатов поиска.
     */
    @FindBy(xpath = "//a[contains(@href, 'wikipedia.org')]")
    private List<WebElement> wikipediaLinks;

    /**
     * Конструктор класса GoogleSearchResultsPage.
     *
     * @param driver WebDriver, используемый для взаимодействия с браузером.
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Возвращает список заголовков результатов поиска.
     *
     * @return список WebElement, представляющих заголовки результатов поиска.
     */
    public List<WebElement> getSearchResultsTitles() {
        return searchResultsTitles;
    }

    /**
     * Проверяет наличие ссылки на Википедию среди результатов поиска.
     *
     * @return true, если ссылка на Википедию присутствует, иначе false.
     */
    public boolean isWikipediaLinkPresent() {
        return !wikipediaLinks.isEmpty();
    }
}
