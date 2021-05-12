package command.commands;


import command.NonArgumentable;
import java.util.Stack;

/**
 * This command end shuts down the program
 */
public class ExitCommand implements NonArgumentable {//завершить программу (без сохранения в файл)

    @Override
    public void execute(Stack mystack, String[] argument) {
        if (argument.length>0){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        System.exit(0);
    }
}
