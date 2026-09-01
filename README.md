# 🎬 Cinema REST API

Простой REST API для управления кинотеатром: фильмы и зрители. Сделан на Java + Spring Boot как EndTerm-проект.

Данные хранятся в PostgreSQL, обмен между клиентом и сервером - через JSON.

## Технологии

Java · Spring Boot · JDBC · PostgreSQL · Maven

## Что умеет

- CRUD для фильмов и зрителей (добавить / получить / обновить / удалить)
- Сортировка фильмов по рейтингу
- Централизованная обработка ошибок через `GlobalExceptionHandler`
- ООП: `Person` - абстрактный класс, `Viewer` его наследует и переопределяет `getRole()`

## Структура

```
kz.star.cinema
├── model        # Person, Viewer, Movie
├── dao          # SQL-запросы к PostgreSQL (JDBC)
├── controller   # REST-эндпоинты
└── exception    # обработка ошибок
```

## API

**Фильмы**
| Метод | Эндпоинт | Описание |
|---|---|---|
| POST | `/movies` | добавить фильм |
| GET | `/movies` | получить все фильмы |
| GET | `/movies/sorted` | фильмы по рейтингу |
| PUT | `/movies/{id}/price` | изменить цену |
| DELETE | `/movies/{id}` | удалить фильм |

**Зрители**
| Метод | Эндпоинт | Описание |
|---|---|---|
| POST | `/viewers` | добавить зрителя |
| GET | `/viewers` | получить всех зрителей |
| PUT | `/viewers/{id}/movie` | изменить фильм зрителя |
| DELETE | `/viewers/{id}` | удалить зрителя |

Пример запроса на добавление фильма:

```json
POST /movies
{
  "title": "Joker",
  "agelimit": 16,
  "rating": 8.5,
  "price": 10.0
}
```

## Как запустить

1. Клонировать репозиторий:
   ```
   git clone https://github.com/Zhuldyz07/cinema.git
   ```
2. Открыть в IntelliJ IDEA
3. Создать базу `cinema_db` в PostgreSQL и таблицы `movies`, `viewers`
4. Указать свои данные подключения в `src/main/resources/application.properties`
5. Запустить `CinemaApplication.java` — сервер поднимется на `http://localhost:8080`
6. Тестировать эндпоинты через Postman

## Автор

Zhuldyz Smagul
