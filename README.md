# Calorie Counter <a name="about-project"></a>

> **Calorie Counter** - REST API сервис для отслеживания дневной нормы калорий пользователя и учета съеденных блюд

## Технологии <a name="built-with"></a>

  <ul>
    <li>Java 21</li>
    <li>Maven 3.9.8</li>
    <li>Spring Boot 3.4.4</li>
    <li>PostgreSQL 16.2</li>
  </ul>

## Описание проекта

### Функциональные требования
- **Приложение автоматически рассчитывает дневную норму калорий для пользователя (по формуле Харриса-Бенедикта)**
- **Приложение хранит следующие данные о пользователях:**
  - ID
  - Имя
  - Email
  - Возраст
  - Вес
  - Рост
  - Цель (Похудение, Поддержание массы, Набор массы)
- **Для более точного расчета нормы калорий добавлены параметры Пол и Уровень активности:**
    - Минимальный - никаких физических нагрузок
    - Низкий - физические нагрузки 1-3 раза в неделю
    - Средний - физические нагрузки 3-5 дней в неделю
    - Высокий - физические нагрузки 6-7 раз в неделю
    - Очень высокий - тренировки чаще, чем раз в день
- **Приложение позволяет добавлять блюда со следующими параметрами:**
  - ID
  - Название
  - Количество калорий на порцию
  - Белки / Жиры / Углеводы
- **Приложение позволяет добавлять информацию о приемах пищи со списком блюд**
- **Приложение позволяет формировать отчеты:**
  - Дневной отчет с суммой всех калорий и приемов пищи. *Реализована возможность выбора даты для отчета, по умолчанию составляется отчет за текущий день*
  - Отчет с проверкой, уложился ли пользователь в свою дневную норму калорий. *Реализована возможность выбора даты для отчета, по умолчанию составляется отчет за текущий день*
  - Отчет об истории питания по дням. *Реализована возможность выбирать разные диапазоны дат, по умолчанию выбираются приемы пищи за все время*

### Нефункциональные требования
 - Осуществлена валидация входных данных: уникальность email, и названия блюд, проверка роста, веса, возраста пользователя
 - Написаны тесты для проверки вычисления нормы калорий с различными входными данными
 - Реализована обработка ошибок в случае, если не найден пользователь, блюдо, прием пищи или в случае некорректности введенных данных

### ER-диаграмма базы данных

![erd](https://github.com/user-attachments/assets/84e1e426-c8a5-40a2-8858-7054e3d9c87b)

### Отношения

*Пользователи и приемы пищи:*
<ul>
  <li>Каждый пользователь может иметь много приемов пищи - 1:N</li>
</ul>

*Блюда и приемы пищи:*
<ul>
  <li>Каждое блюдо может относиться к разным приемам пищи, каждый прием пищи может состоять из нескольких блюд - N:N</li>
</ul>


## Использование
Для запуска приложения:
1. Склонируйте репозиторий в нужную папку и откройте ее в терминале
  
2. Запустите команду `docker compose up` с указанием значения переменной окружения `DB_DIR` пути до папки, где будут храниться данные БД из контейнера, например:

   `DB_DIR=/home/user/docker/ docker compose up`
3. Документация Swagger доступна по [ссылке](http://localhost:8080/swagger-ui/index.html#/)

4. Протестировать API можно с помощью Postman:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/37529477-e0b82403-ff30-497e-b578-dc42d569897e?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D37529477-e0b82403-ff30-497e-b578-dc42d569897e%26entityType%3Dcollection%26workspaceId%3D65e1c2be-d95e-4612-9179-10ceabcea9f7)

*Комментарий: Приложение при запуске создаст пустые таблицы в базе данных. К базе данных можно подключиться по порту 5433*

## Авторы <a name="authors"></a>
 **Анна Поповa**

- GitHub: [funchose](https://github.com/funchose)
- Telegram @funch0se
