package command.commands;

import command.CanEdit;
import command.Command;

import data.format.MusicBand;

import java.util.Collections;
import java.util.Stack;

/**
 * This command sorts main collection Stack<MusicBand> in revered order
 */
public class ReorderCommand extends Command implements CanEdit {
    //отсортировать коллекцию в порядке, обратном нынешнему
    @Override
    public String describe() {
        return "Отсортировывает коллекцию в порядке, обратном нынешнему";
    }

    @Override
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        Collections.reverse(mystack);
        return mystack;
    }
}
