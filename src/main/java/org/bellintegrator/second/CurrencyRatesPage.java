package org.bellintegrator.second;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Класс представляет страницу курсов валют и предоставляет методы для получения и анализа курсов покупки и продажи валют.
 * @author Автор: Сабина Березина
 */
public class CurrencyRatesPage {

    protected WebDriver driver;

    /**
     * Поиск строк таблицы с курсами валют на странице.
     */
    @FindBy(css = ".card-rates-table.cards tbody tr")
    private List<WebElement> currencyRows;

    /**
     * Конструктор класса CurrencyRatesPage.
     * Инициализирует новый экземпляр страницы с использованием драйвера браузера.
     *
     * @param driver WebDriver, используемый для взаимодействия со страницей.
     */
    public CurrencyRatesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Возвращает количество строк в таблице курсов валют.
     *
     * @return Количество строк в таблице курсов валют.
     */
    public int getRowCount() {
        return currencyRows.size();
    }

    /**
     * Возвращает курс покупки валюты с заданным кодом.
     *
     * @param currencyCode Код валюты.
     * @return курс покупки валюты.
     */
    public boolean checkRate(String currencyCode) {
        WebElement currencyRow = findCurrencyRowByCurrencyCode(currencyCode);
        if (currencyRow != null) {
            double buyRate = getBuyRateForRow(currencyRow);
            double sellRate = getSellRateForRow(currencyRow);
            return buyRate > sellRate;
        }
        return false;
    }

    /**
     * Находит строку таблицы с курсами валют по коду валюты.
     *
     * @param currencyCode Код валюты.
     * @return WebElement, представляющий строку таблицы с курсами валют.
     */
    private WebElement findCurrencyRowByCurrencyCode(String currencyCode) {
        List<WebElement> currencyRows = driver.findElements(By.cssSelector(".card-rates-table.cards tbody tr"));

        for (WebElement row : currencyRows) {
            WebElement currencyTextElement = row.findElement(By.xpath(".//span[@class='currency__text']"));
            if (currencyTextElement.getText().equals(currencyCode)) {
                return row;
            }
        }
        return null;
    }

    /**
     * Возвращает курс покупки валюты для заданной строки таблицы.
     *
     * @param row Строка таблицы с курсами валют.
     * @return курс покупки валюты.
     */
    private double getBuyRateForRow(WebElement row) {
        WebElement buyRateElement = row.findElement(By.xpath(".//td[@class='card-rates-table__cell card-rates-table__purchase large-text']"));
        String buyRateText = buyRateElement.getText().replace(",", ".");
        return Double.parseDouble(buyRateText);
    }

    /**
     * Возвращает курс продажи валюты для заданной строки таблицы.
     *
     * @param row Строка таблицы с курсами валют.
     * @return курс продажи валюты.
     */
    private double getSellRateForRow(WebElement row) {
        WebElement sellRateElement = row.findElement(By.xpath(".//td[@class='card-rates-table__cell card-rates-table__sale large-text']"));
        String sellRateText = sellRateElement.getText().replace(",", ".");
        return Double.parseDouble(sellRateText);
    }
}


