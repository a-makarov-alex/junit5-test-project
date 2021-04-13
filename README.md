"# junit5-test-project" 

Проект создан для отработки:
- Внедрения зависимостей (guice, junit5)
- Использования конфигов (aeonbits/owner)

Используются классы API и фейковой DB, которую можно позже подключить.
Запуск:
mvn clean install
Отчет, скорее всего:
mvn allure:report

Логи см в src/test/resources/logs.log