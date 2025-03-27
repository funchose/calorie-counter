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

4. Протестировать API можно с помощью Postman:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/37529477-e0b82403-ff30-497e-b578-dc42d569897e?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D37529477-e0b82403-ff30-497e-b578-dc42d569897e%26entityType%3Dcollection%26workspaceId%3D65e1c2be-d95e-4612-9179-10ceabcea9f7)

Приложение при запуске создаст пустую таблицу в базе данных. К базе данных можно подключиться по порту 5433.

## Авторы <a name="authors"></a>
 **Анна Поповa**

- GitHub: [funchose](https://github.com/funchose)
- Telegram @funch0se
