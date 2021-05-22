package command.commands;

import command.CanEdit;
import data.format.MusicBand;

import java.util.Collections;
import java.util.Stack;

/**
 * This command sorts main collection Stack<MusicBand> in revered order
 */
public class ReorderCommand implements CanEdit {

    @Override
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length > 0) {
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        Collections.reverse(mystack);
        System.out.println("Коллекция отсортирована в обратном порядке.");
        return mystack;
    }
}
