package command.commands;

import command.CanEdit;
import command.Command;
import command.NonArgumentable;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command clears main collection Stack<MusicBand>
 */
public class ClearCommand extends Command implements CanEdit {  //очистить коллекцию
    @Override
    public Stack<MusicBand> execute(Stack mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        mystack.clear();
        return mystack;
    }

    @Override
    public String describe() {
        return "Очищает коллекцию";
    }
}
