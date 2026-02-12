# Дипломный проект. Задание 1: Юнит-тесты

**Stellar Burgers**   
В этом проекте протестирован класс `Burger` с помощью **JUnit 4**, **Mockito** и **JaCoCo**.

---

## ✅ Что сделано
- Покрыты тестами все методы класса `Burger`
- Использованы моки для `Bun` и `Ingredient`
- Параметризованные тесты для `getPrice()` и `getReceipt()`
- Подключён JaCoCo — **покрытие 100%**

---

## 🚀 Запуск тестов
```bash
Запуск тестов: mvn clean test
Отчёт JaCoCo: mvn jacoco:report

Открыть: target/site/jacoco/index.html
```
🛠 Стек
Java 11

Maven

JUnit 4.13.2

Mockito 5.20.0

JaCoCo 0.8.7