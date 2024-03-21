# Fibonacci Benchmark

Проект "Fibonacci Benchmark" представляет собой набор тестов производительности для различных реализаций алгоритма Фибоначчи.

## Содержание

- Введение
- Тесты производительности
- Описание классов
- Запуск
- Результат

## Введение

Алгоритм Фибоначчи - это простой числовой алгоритм, который используется во многих областях, включая математику, теоретическую информатику и теорию игр. Этот проект содержит несколько реализаций алгоритма Фибоначчи и использует библиотеку JMH (Java Microbenchmark Harness) для измерения их производительности.

## Тесты производительности

В проекте представлены следующие тесты производительности:

- **Рекурсивный**: Этот тест измеряет производительность рекурсивной реализации алгоритма Фибоначчи.
- **Итеративный**: Этот тест измеряет производительность итеративной реализации алгоритма Фибоначчи.
- **Поток**: Этот тест измеряет производительность реализации алгоритма Фибоначчи с использованием потоков Java.
- **Параллельный поток**: Этот тест измеряет производительность реализации алгоритма Фибоначчи с использованием параллельных потоков Java.

## Класс Fibonacci

Класс `Fibonacci` содержит три метода:
- `fibonacciIterative(int n)`: Вычисляет n-ое число Фибоначчи итеративно.
- `fibonacciRecursive(long n)`: Вычисляет n-ое число Фибоначчи рекурсивно.
- `fibonacciStream(int n)`: Вычисляет n-ое число Фибоначчи с использованием Stream API.

## Класс FibonacciBenchmark

Класс `FibonacciBenchmark` содержит методы для бенчмаркинга каждого из методов вычисления чисел Фибоначчи. Он использует JMH (Java Microbenchmark Harness) для измерения производительности каждого метода.

## Запуск

Чтобы запустить тесты производительности, выполните следующую команду:

```java -jar target/benchmarks.jar ```

Результаты тестов будут сохранены в файле fibonacci-jmh.json.

[JMH Visualizer](Screenshot 2024-03-21 104134.png)