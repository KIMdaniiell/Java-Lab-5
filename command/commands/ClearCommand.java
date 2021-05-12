package command.commands;

import command.CanEdit;
import command.NonArgumentable;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command clears main collection Stack<MusicBand>
 */
public class ClearCommand implements CanEdit {  //очистить коллекцию
    @Override
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>0){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        mystack.clear();
        return mystack;
    }
}
