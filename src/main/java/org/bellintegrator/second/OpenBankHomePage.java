package org.bellintegrator.second;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс представляет домашнюю страницу банка "Открытие" и предоставляет методы для взаимодействия с ключевыми элементами страницы.
 * @author Автор: Сабина Березина
 */
public class OpenBankHomePage {

    protected WebDriver driver;

    /**
     * Ссылка "Все курсы" на домашней странице.
     */
    @FindBy(xpath = "//a[contains(text(),'Все курсы')]")
    private WebElement allCoursesLink;

    /**
     * Блок с курсами обмена валют на домашней странице.
     */
    @FindBy(xpath = "//*[@data-block-id='exchange']")
    private WebElement exchangeBlock;

    /**
     * Конструктор класса OpenBankHomePage.
     * Инициализирует новый экземпляр драйвера и элементы страницы.
     *
     * @param driver WebDriver, используемый для взаимодействия с браузером.
     */
    public OpenBankHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Выполняет клик по ссылке "Все курсы" на странице, используя JavaScript.
     * Предпочтительно, когда стандартный клик не работает.
     */
    public void clickOnAllCoursesLink() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allCoursesLink);
        } catch (Exception e) {
            System.out.println("Не удалось кликнуть на ссылку 'Все курсы' через JavaScript.");
            e.printStackTrace();
        }
    }

    /**
     * Проверяет, отображается ли на странице блок с курсами обмена валют.
     *
     * @return true, если блок отображается.
     */
    public boolean isExchangeBlockPresent() {
        try {
            return exchangeBlock.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Проверяет, отображается ли на странице ссылка "Все курсы".
     *
     * @return true, если ссылка отображается.
     */
    public boolean isAllCoursesLinkPresent() {
        try {
            return allCoursesLink.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
