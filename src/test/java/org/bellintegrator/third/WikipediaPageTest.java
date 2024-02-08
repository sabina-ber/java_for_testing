package org.bellintegrator.third;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Stream;

public class WikipediaPageTest extends BaseTests {

    private static List<List<String>> teachersData;

    @BeforeEach
    public void setUpData() {
        chromeDriver.get("https://www.google.com");
        GoogleHomePage homePage = new GoogleHomePage(chromeDriver);
        homePage.searchFor("таблица");
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(chromeDriver);
        resultsPage.clickFirstWikipediaLink();
        resultsPage.switchToNewTab();
        WikipediaPage wikipediaPage = new WikipediaPage(chromeDriver);
        teachersData = wikipediaPage.getTeachersData();
        System.out.println("Данные из таблицы: " + teachersData);
        Assertions.assertFalse(teachersData.isEmpty(), "Таблица преподавателей пуста");
    }

    private static Stream<List<String>> firstTeacherDataProvider() {
        return Stream.of(List.of("Сергей", "Владимирович"));
    }

    private static Stream<List<String>> lastTeacherDataProvider() {
        return Stream.of(List.of("Сергей", "Адамович"));
    }

    @ParameterizedTest
    @MethodSource("firstTeacherDataProvider")
    public void testFirstTeacherOrderInTable(List<String> namePatronymic) {
        Assertions.assertTrue(isNameAndPatronymicMatch(teachersData.get(0), namePatronymic), "Первый преподаватель в списке не соответствует ожидаемому");
    }

    @ParameterizedTest
    @MethodSource("lastTeacherDataProvider")
    public void testLastTeacherOrderInTable(List<String> namePatronymic) {
        Assertions.assertTrue(isNameAndPatronymicMatch(teachersData.get(teachersData.size() - 1), namePatronymic), "Последний преподаватель в списке не соответствует ожидаемому");
    }

    private boolean isNameAndPatronymicMatch(List<String> rowData, List<String> namePatronymic) {
        if (rowData.size() < 3) return false;
        return rowData.get(1).equals(namePatronymic.get(0)) && rowData.get(2).equals(namePatronymic.get(1));
    }
}

