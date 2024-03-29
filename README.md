# Учебный проект на Java

## Описание

Этот репозиторий содержит учебный проект на Java, в котором реализованы задания по автоматизированному тестированию с использованием Selenium WebDriver. Задача каждого теста - проверить конкретные функциональные аспекты работы поисковой системы Google.

## Задания

### Задание 1: Поиск в Google

**Цель**: проверить вывод результатов поиска в Google.

#### Шаги

1. **Перейти по ссылке**: https://www.google.com/
   - *Ожидаемый результат*: Главная страница поисковой системы Google открыта.
2. **Ввести в строку поиска**: "Гладиолус" и нажать поиск.
   - *Ожидаемый результат*: На странице отображаются результаты поиска. На первой странице есть ссылка на википедию.

### Задание 2: Поиск с открытием новой вкладки

**Цель**: проверить открытие ссылок в новой вкладке и отображение информации.

#### Предусловие

- Система поиска Google настроена открывать ссылки в новой вкладке.

#### Шаги

1. **Перейти по ссылке**: https://www.google.com/
   - *Ожидаемый результат*: Главная страница поисковой системы Google открыта.
2. **Ввести в строку поиска**: "Открытие" и нажать поиск.
   - *Ожидаемый результат*: На странице отображаются результаты поиска. На первой странице есть заголовок с текстом "Банк Открытие: кредит наличными, ипотека, кредитные и ...".
3. **Кликнуть по заголовку**: "Банк Открытие: кредит наличными, ипотека, кредитные и ..."
   - *Ожидаемый результат*: Открылась новая вкладка. На странице есть блок "Курс обмена".
4. **Кликнуть по тексту**: "Все курсы".
   - *Ожидаемый результат*: Открылась страница содержащая не менее трех курсов валют. Курс покупки для долларов меньше курса продажи доллара. Курс покупки евро меньше курса продажи евро.

### Задание 3: Поиск с открытием страницы википедии

**Цель**: проверить открытие статей википедии и корректность отображаемой информации.

#### Предусловие

- Система поиска Google настроена открывать ссылки в новой вкладке.

#### Шаги

1. **Перейти по ссылке**: https://www.google.com/
   - *Ожидаемый результат*: Главная страница поисковой системы Google открыта.
2. **Ввести в строку поиска**: "таблица" и нажать поиск.
   - *Ожидаемый результат*: На странице отображаются результаты поиска. На первой странице есть заголовок с текстом "Таблица".
3. **Кликнуть по заголовку**: “Таблица”.
   - *Ожидаемый результат*: Открылась страница википедии. В таблице “Преподаватели кафедры программирования” “Сергей Владимирович” идет первым в списке, а “Сергей Адамович” последним.

