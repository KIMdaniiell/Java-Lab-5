package command.commands;

import command.Command;
import command.NonArgumentable;

import java.util.Stack;

/**
 * This command end shuts down the program
 */
public class ExitCommand extends Command implements NonArgumentable {//завершить программу (без сохранения в файл)

    @Override
    public void execute(Stack mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        System.exit(0);
    }

    @Override
    public String describe() {
        return "Завершает программу без сохранения в файл";
    }

}
