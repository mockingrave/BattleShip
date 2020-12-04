## **Валидатор поля для игры "Морской бой"**

Данная программа создана для проверки поля,
представленного в виде набора строк, состоящих из последовательности
"." и "Х", где "Х" - корабль, а "." - пустое место.

**Программа проверяет:**\
- дистанцию между кораблями _(минимум 1 клетка)_\
- форму кораблей _(клетки кораблей должны составлять прямые линии)_\
- наличие и количество кораблей заданных типов\
_(1 корабль из 4 клеток, 2 из 3-х клеток, 3 из 2-х клеток и 4 из 1-й клетки)_

Проверяемые параметры взяты из классических правил морского боя.

### Требования / зависимости
- JDK 13+
    - javac

### Установка
1) Убедитесь, что вы установили все требования / зависимости
2) Клонируйте этот репозиторий
3) Перейдите в каталог проекта
4) Используйте javac для компиляции исходного кода
5) Для запуска программы: java ru.mockingrave.Main

#### Версия
1.0