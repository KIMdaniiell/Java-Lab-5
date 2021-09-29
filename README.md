# Java-Lab-5    |  Лабораторная работа 5


Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса MusicBand.
========================

Разработанная программа должна удовлетворять следующим требованиям:
-------------------------
        +Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
        +Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
        +Для хранения необходимо использовать коллекцию типа java.util.Stack
        +При запуске приложения коллекция должна автоматически заполняться значениями из файла.
        +Имя файла должно передаваться программе с помощью: переменная окружения.
        +Данные должны храниться в файле в формате xml
        +Чтение данных из файла необходимо реализовать с помощью класса java.util.Scanner
        +Запись данных в файл необходимо реализовать с помощью класса java.io.PrintWriter
        +Все классы в программе должны быть задокументированы в формате javadoc.
        +Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутствие прав доступа к файлу и т.п.).

    
В интерактивном режиме программа должна поддерживать выполнение следующих команд:
-------------------------
	+help : вывести справку по доступным командам
	+info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
	+show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
	+add {element} : добавить новый элемент в коллекцию
	+update id {element} : обновить значение элемента коллекции, id которого равен заданному
	+remove_by_id id : удалить элемент из коллекции по его id
	+clear : очистить коллекцию
	+save : сохранить коллекцию в файл
	+execute_script file_name : считать и исполнить скрипт из указанного файла. 
	+exit : завершить программу (без сохранения в файл)
	+remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
	+reorder : отсортировать коллекцию в порядке, обратном нынешнему
	+sort : отсортировать коллекцию в естественном порядке
	+remove_any_by_description description : удалить из коллекции один элемент, значение поля description которого эквивалентно заданному
	+filter_less_than_genre genre : вывести элементы, значение поля genre которых меньше заданного
	+print_field_descending_description : вывести значения поля description всех элементов в порядке убывания
    
    
Формат ввода команд:
-------------------------
        +Все аргументы команды, являющиеся стандартными типами данных, должны вводиться в той же строке, что и имя команды.
        +Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
        +При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
	+Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
	+При некорректном пользовательском вводе должно быть показано сообщение об ошибке и предложено повторить ввод поля.
	+Для ввода значений null использовать пустую строку.
	+Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.

Описание хранимых в коллекции классов:
-------------------------
        -описание утеряно-
