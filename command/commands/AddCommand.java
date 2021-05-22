package command.commands;

import command.CanEdit;
import command.ReadsBand;
import data.format.MusicBand;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * This command adds new element info main collection Stack<MusicBand>
 */
public class AddCommand extends ReadsBand implements CanEdit {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length > 0) {
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        MusicBand myband = addition(mystack);
        mystack.push(myband);
        System.out.println("Был добавлен новый объект - "+myband.toString());
        return mystack;
    }
}
