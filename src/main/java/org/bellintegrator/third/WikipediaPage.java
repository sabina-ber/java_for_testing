package org.bellintegrator.third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс представляет страницу Википедии с таблицей преподавателей кафедры программирования.
 * Позволяет извлекать данные о преподавателях для дальнейшего анализа.
 * @author Автор: Сабина Березина
 */
public class WikipediaPage {
    protected WebDriver driver;

    /**
     * Локатор для поиска строк таблицы преподавателей программирования.
     */
    @FindBy(xpath = "//table[.//caption[contains(text(), 'Преподаватели кафедры программирования')]]//tr")
    private List<WebElement> programmingFacultyTableRows;

    /**
     * Конструктор класса WikipediaPage.
     * Инициализирует новый экземпляр страницы с использованием драйвера браузера.
     *
     * @param driver WebDriver, используемый для взаимодействия со страницей.
     */
    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Извлекает данные о преподавателях кафедры программирования из таблицы.
     * Возвращает список списков строк, где каждый внутренний список представляет
     * одну строку таблицы (фамилию, имя и отчество преподавателя).
     *
     * @return Список данных о преподавателях.
     */
    public List<List<String>> getTeachersData() {
        List<List<String>> teachersData = new ArrayList<>();
        for (int i = 1; i < programmingFacultyTableRows.size(); i++) {
            List<WebElement> cells = programmingFacultyTableRows.get(i).findElements(By.tagName("td"));
            List<String> rowData = cells.stream().map(WebElement::getText).collect(Collectors.toList());
            teachersData.add(rowData);
        }
        return teachersData;
    }

    /**
     * Метод для получения текста из первой строки данных таблицы.
     * @return Текст первой строки данных таблицы.
     */
    public String getTextOfFirstDataRow() {
        return programmingFacultyTableRows.get(1).getText();
    }

    /**
     * Метод для получения текста из последней строки данных таблицы.
     * @return Текст последней строки данных таблицы.
     */
    public String getTextOfLastDataRow() {
        return programmingFacultyTableRows.get(programmingFacultyTableRows.size() - 1).getText();
    }
}

