# Calorie Counter <a name="about-project"></a>

> **Calorie Counter** - REST API сервис для отслеживания дневной нормы калорий пользователя и учета съеденных блюд

### Технологии <a name="built-with"></a>

  <ul>
    <li>Java 21</li>
    <li>Maven 3.9.8</li>
    <li>PostgreSQL 16.2</li>
  </ul>

## Использование
Для запуска приложения:
1. Склонируйте репозиторий в нужную папку и откройте ее в терминале
  
2. Запустите команду `docker compose up` с указанием значения переменной окружения `DB_DIR` пути до папки, где будут храниться данные БД из контейнера, например:

   `DB_DIR=/home/user/docker/ docker compose up`
3. Документация Swagger доступна по [ссылке](http://localhost:8080/swagger-ui/index.html#/)

4. Протестировать API можно по [ссылке](https://web.postman.co/workspace/4400b487-b6e8-4775-87b2-e58386bc8aae/documentation/37529477-e2c18649-52fd-43ff-a7bd-c211eff84638)

Приложение при запуске создаст пустую таблицу в базе данных. К базе данных можно подключиться по порту 5433.

## Авторы <a name="authors"></a>
 **Анна Поповa**

- GitHub: [funchose](https://github.com/funchose)
- Telegram @funch0se
