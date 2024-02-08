package org.bellintegrator.first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс представляет главную страницу Google и обеспечивает взаимодействие с поисковой формой.
 * Использует Page Factory для инициализации элементов страницы.
 *
 * @author Автор: Сабина Березина
 */
public class GoogleHomePage {

    protected WebDriver driver;

    /**
     * Поле ввода для поискового запроса.
     */
    @FindBy(name = "q")
    private WebElement searchBox;

    /**
     * Конструктор класса GoogleHomePage.
     * Инициализирует экземпляр WebDriver и элементы страницы.
     *
     * @param driver WebDriver, используемый для взаимодействия с браузером.
     */
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Выполняет поисковый запрос, вводя текст и отправляя форму поиска.
     *
     * @param text Текст поискового запроса.
     */
    public void searchFor(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
    }
}
